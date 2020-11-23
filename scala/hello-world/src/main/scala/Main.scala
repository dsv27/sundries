
/*
object Main extends App {
  println("Hello, World! 2")
  val messages = """|Test 
                    |2
                    |""".stripMargin
  println(messages)
}
*/

trait HelloWord {
  val helloWord = "Hello Word, with trait !!!"
}

object Main extends App with HelloWord {

  println(helloWord)

}