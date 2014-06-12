package sampleworksheet

import scala.math.BigDecimal

object Functions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def multiply(x: Int, y: Int) = x * y            //> multiply: (x: Int, y: Int)Int
  
  
  def timeFive = multiply(5, _:Int)               //> timeFive: => Int => Int
  
  def withTest(cost: BigDecimal, state: String): BigDecimal = {
   state match {
   	case "NH" => cost
   	case  "MA" => cost * 5.3
   }
   cost + 1
  }                                               //> withTest: (cost: scala.math.BigDecimal, state: String)scala.math.BigDecimal
  
  withTest(BigDecimal(2.2), "MA")                 //> res0: scala.math.BigDecimal = 3.2
  
}