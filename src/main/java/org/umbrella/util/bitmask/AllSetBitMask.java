package org.umbrella.util.bitmask;

public class AllSetBitMask extends SingleLongBitMask implements AllSetMask {

    private static final AllSetBitMask INSTANCE = new AllSetBitMask();

    public static AllSetBitMask get() {
        return INSTANCE;
    }

    @Override
    public BitMask set(int index) {
        return this;
    }

    @Override
    public BitMask setAll(BitMask mask) {
        return this;
    }

    @Override
    public BitMask reset(int index) {
        return BitMask.getFull(index + 1).reset(index);
    }

    @Override
    public BitMask resetAll(BitMask mask) {
        if (mask.isEmpty()) {
            return this;
        } else if (mask instanceof EmptyButLastBitMask) {
            return AllSetButLastBitMask.get();
        } else if (mask instanceof AllSetBitMask) {
            return EmptyBitMask.get();
        } else if (mask instanceof AllSetButLastBitMask) {
            return EmptyButLastBitMask.get();
        }

        return this;
    }

    @Override
    public boolean isSet(int index) {
        return true;
    }

    @Override
    public boolean isAllSet() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean intersects(BitMask mask) {
        return true;
    }

    @Override
    public String getInstancingStatement() {
        return AllSetBitMask.class.getCanonicalName() + ".get()";
    }

    @Override
    public long asLong() {
        return -1L;
    }

    @Override
    public SingleLongBitMask clone() {
        return this;
    }

}
