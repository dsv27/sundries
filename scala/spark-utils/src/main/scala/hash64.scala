package org.dsv.spark.utils
import org.apache.spark.sql.api.java.UDF1
import org.apache.commons.codec.digest.MurmurHash3

class hash64 extends UDF1[String, Long] {

  override def call(Str: String): Long = {
    MurmurHash3.hash128x64(Str.getBytes())(0)
  }
}
