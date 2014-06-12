package sampleworksheet

object HelloScalaworksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 

  println("Welcome to the Scala worksheet");$skip(13); 
  
  val x=5;System.out.println("""x  : Int = """ + $show(x ));$skip(13); 
  
  val y=6;System.out.println("""y  : Int = """ + $show(y ));$skip(31); 
  
  var text1: String = "ABC";System.out.println("""text1  : String = """ + $show(text1 ));$skip(23); 
  
  var text2 = "DEF";System.out.println("""text2  : String = """ + $show(text2 ));$skip(17); 
  var myvar = 12;System.out.println("""myvar  : Int = """ + $show(myvar ));$skip(42); 
  
  def addNumber(x: Int, y:Int) = x + y;System.out.println("""addNumber: (x: Int, y: Int)Int""");$skip(21); val res$0 = 
  
  addNumber(1, y)
  
  class Calculator() {
  	def add(x: Int, y: Int) = x + y
  }
  
  class Book(val title: String, val author: String) {
     override def toString() = title
  
  };System.out.println("""res0: Int = """ + $show(res$0));$skip(206); 
  
  val b = new Book("Scala","Martin");System.out.println("""b  : sampleworksheet.HelloScalaworksheet.Book = """ + $show(b ));$skip(13); val res$1 = 
  
  b.title;System.out.println("""res1: String = """ + $show(res$1));$skip(11); val res$2 = 
  b.author;System.out.println("""res2: String = """ + $show(res$2))}
  
}
