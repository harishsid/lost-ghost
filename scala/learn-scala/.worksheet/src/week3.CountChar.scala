package week3

object CountChar {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(41); 

  val text = "this is 1 string of text";System.out.println("""text  : String = """ + $show(text ));$skip(68); 
  // Initalize array with ascii idex
  val cc = new Array[Int](123);System.out.println("""cc  : Array[Int] = """ + $show(cc ));$skip(133); 

  def countChar(c: Char) = {
    if (!c.isWhitespace) {
      val index = c.toLower.toInt
      cc(index) = cc(index) + 1
    }
  };System.out.println("""countChar: (c: Char)Unit""");$skip(27); 

  text.foreach(countChar);$skip(131); 

  // print char count
  for (i <- 99 to 122) {
    val count = cc(i)
    if (count > 0)
      println(i.toChar + " " + count)
  };$skip(131); 
  // print number count
  for (i <- 48 to 57) {
    val count = cc(i)
    if (count > 0)
      println(i.toChar + " " + count)
  };$skip(16); 
  println("je")}

}
