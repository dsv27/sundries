package org.dsv.spark.utils

import org.apache.commons.codec.digest.MurmurHash3
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

class udf_hash32 extends Serializable {
  def getUdf: UserDefinedFunction = udf((Str: String) => MurmurHash3_32x86(Str))

  def MurmurHash3_32x86(Str: String): Option[Int] = {
    Option(Str).map((x: String) => MurmurHash3.hash32x86(x.getBytes()))
  }
}
