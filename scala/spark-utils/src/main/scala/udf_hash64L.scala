package org.dsv.spark.utils

import org.apache.commons.codec.digest.MurmurHash3
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

class udf_hash64L extends Serializable {
  def getUdf: UserDefinedFunction =
    udf((Str: String) => MurmurHash3_128x64(Str))

  def MurmurHash3_128x64(Str: String): Option[Long] = {
    Option(Str).map((x: String) => MurmurHash3.hash128x64(x.getBytes())(1))
  }
}
