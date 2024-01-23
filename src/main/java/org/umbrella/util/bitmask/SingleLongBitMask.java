package org.umbrella.util.bitmask;

public abstract class SingleLongBitMask implements BitMask{

    public abstract long asLong();

    public abstract SingleLongBitMask clone();
    
    @Override
    public int hashCode() {
        return (int) (asLong() ^ (asLong() >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        return obj instanceof SingleLongBitMask && asLong() == ((SingleLongBitMask) obj).asLong();
    }

    @Override
    public String toString() {
        return "" + asLong();
    }

}
