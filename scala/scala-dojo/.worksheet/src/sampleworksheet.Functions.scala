package sampleworksheet

import scala.math.BigDecimal

object Functions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(117); 
  println("Welcome to the Scala worksheet");$skip(42); 
  
  def multiply(x: Int, y: Int) = x * y;System.out.println("""multiply: (x: Int, y: Int)Int""");$skip(42); 
  
  
  def timeFive = multiply(5, _:Int);System.out.println("""timeFive: => Int => Int""");$skip(156); 
  
  def withTest(cost: BigDecimal, state: String): BigDecimal = {
   state match {
   	case "NH" => cost
   	case  "MA" => cost * 5.3
   }
   cost + 1
  };System.out.println("""withTest: (cost: scala.math.BigDecimal, state: String)scala.math.BigDecimal""");$skip(37); val res$0 = 
  
  withTest(BigDecimal(2.2), "MA");System.out.println("""res0: scala.math.BigDecimal = """ + $show(res$0))}
  
}
