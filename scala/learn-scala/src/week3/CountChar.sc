package week3

object CountChar {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val text = "this is 1 string of text"           //> text  : String = this is 1 string of text
  // Initalize array with ascii idex
  val cc = new Array[Int](123)                    //> cc  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                                  //| 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                                                  //| , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                  //|  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                                  //| 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                                                  //| , 0, 0, 0, 0)

  def countChar(c: Char) = {
    if (!c.isWhitespace) {
      val index = c.toLower.toInt
      cc(index) = cc(index) + 1
    }
  }                                               //> countChar: (c: Char)Unit

  text.foreach(countChar)

  // print char count
  for (i <- 99 to 122) {
    val count = cc(i)
    if (count > 0)
      println(i.toChar + " " + count)
  }                                               //> e 1
                                                  //| f 1
                                                  //| g 1
                                                  //| h 1
                                                  //| i 3
                                                  //| n 1
                                                  //| o 1
                                                  //| r 1
                                                  //| s 3
                                                  //| t 4
                                                  //| x 1
  // print number count
  for (i <- 48 to 57) {
    val count = cc(i)
    if (count > 0)
      println(i.toChar + " " + count)
  }                                               //> 1 1
  println("je")                                   //> je

}