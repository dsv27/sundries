package org.dsv.spark.utils;
import org.apache.commons.codec.digest.MurmurHash3;
import java.nio.charset.StandardCharsets;
import org.apache.spark.sql.api.java.UDF1;

public class hash64 implements UDF1<String, Long>{
    private static final long serialVersionUID = 1L;
    @Override
    public Long call(String str)  throws Exception {
        if (str == null) return (null);
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        long[] hash = MurmurHash3.hash128(data);
        return (hash[0]);
    }
}


