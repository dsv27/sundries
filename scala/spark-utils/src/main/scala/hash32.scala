package org.dsv.spark.utils
import org.apache.spark.sql.api.java.UDF1
import org.apache.commons.codec.digest.MurmurHash3

class hash32 extends UDF1[String, Int] {

  override def call(Str: String): Int = {
    MurmurHash3.hash32x86(Str.getBytes())
  }
}
