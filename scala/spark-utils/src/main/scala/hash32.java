package org.dsv.spark.utils;
import org.apache.commons.codec.digest.MurmurHash3;
import java.nio.charset.StandardCharsets;
import org.apache.spark.sql.api.java.UDF1;


public class hash32 implements UDF1<String, Integer>{
    private static final long serialVersionUID = 1L;
    @Override
    public Integer call(String str) throws Exception {
        if (str == null) return (null);
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        return (MurmurHash3.hash32x86(data));
    }
}
