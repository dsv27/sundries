package org.dsv.spark.utils

import org.apache.commons.codec.digest.MurmurHash3
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

class udf_hash64 extends Serializable {
  def getUdf: UserDefinedFunction = udf((Str: String) => MurmurHash3_128x64(Str))

  def MurmurHash3_128x64(Str: String): Long = {
    if (Str.==(null)) return 0
    MurmurHash3.hash128x64(Str getBytes())(0)
  }
}

