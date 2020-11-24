package org.dsv.utils;

import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.charset.StandardCharsets;

public final class hash {
    public static Integer hash32 (String str)  throws Exception  {
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        return (MurmurHash3.hash32x86(data));
    }
    public static  Long hash64(String str)  throws Exception {
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        long[] hash = MurmurHash3.hash128(data);
        return (hash[0]);
    }
    public static  Long hash64L(String str) throws Exception  {
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        long[] hash = MurmurHash3.hash128(data);
        return (hash[1]);
    }
}
