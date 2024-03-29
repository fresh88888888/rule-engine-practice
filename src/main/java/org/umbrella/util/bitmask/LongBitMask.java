package org.umbrella.util.bitmask;

public class LongBitMask extends SingleLongBitMask {

    private long mask;

    public LongBitMask() {
    }

    public LongBitMask(long mask) {
        this.mask = mask;
    }

    @Override
    public BitMask set(int index) {
        if (index >= 64) {
            return BitMask.getEmpty(index + 1).setAll(this).set(0);
        }
        this.mask = this.mask | (1L << index);

        return this;
    }

    @Override
    public BitMask setAll(BitMask mask) {
        if (mask instanceof LongBitMask) {
            this.mask |= ((LongBitMask) mask).asLong();
        } else if (mask instanceof AllSetBitMask) {
            return AllSetBitMask.get();
        } else if (mask instanceof AllSetButLastBitMask) {
            return isSet(0) ? AllSetBitMask.get() : AllSetButLastBitMask.get();
        } else if (mask instanceof OpenBitSet) {
            return mask.setAll(this);
        } else if (mask instanceof EmptyButLastBitMask) {
            return set(0);
        }

        return this;
    }

    @Override
    public BitMask reset(int index) {
        if (index < 64) {
            mask = mask & (Long.MAX_VALUE - (1L << index));
        }

        return this;
    }

    @Override
    public BitMask resetAll(BitMask mask) {
        if (mask instanceof LongBitMask) {
            this.mask &= (-1L - ((LongBitMask) mask).asLong());
        } else if (mask instanceof AllSetBitMask) {
            this.mask &= 0;
        } else if (mask instanceof AllSetButLastBitMask) {
            this.mask &= Long.MIN_VALUE;
        } else if (mask instanceof EmptyButLastBitMask) {
            reset(0);
        } else if (!(mask instanceof EmptyBitMask)) {
            throw new RuntimeException("Cannot resetAll a LongBitMask with a " + mask.getClass().getSimpleName());
        }

        return this;
    }

    @Override
    public boolean isSet(int index) {
        long bit = 1L << index;
        return (mask & bit) == bit;
    }

    @Override
    public boolean isAllSet() {
        return mask == -1L;
    }

    @Override
    public boolean isEmpty() {
        return mask == 0L;
    }

    @Override
    public boolean intersects(BitMask mask) {
        return mask instanceof LongBitMask ? (this.mask & ((LongBitMask) mask).asLong()) != 0 : mask.intersects(mask);
    }

    @Override
    public String getInstancingStatement() {
        BitMask normalizedMask = normalize();
        return normalizedMask instanceof LongBitMask ? "new " + LongBitMask.class.getCanonicalName() + "(" + mask + "L)"
                : normalizedMask.getInstancingStatement();
    }

    @Override
    public LongBitMask clone() {
        return new LongBitMask(mask);
    }

    @Override
    public long asLong() {
        return mask;
    }

    private BitMask normalize() {
        if (mask == 0L) {
            return EmptyBitMask.get();
        } else if (mask == 1L) {
            return EmptyButLastBitMask.get();
        } else if (mask == Long.MAX_VALUE) {
            return AllSetButLastBitMask.get();
        } else if (mask == -1L) {
            return AllSetBitMask.get();
        }
        return this;
    }
}
