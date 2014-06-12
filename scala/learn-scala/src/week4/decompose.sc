package week4

object decompose {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  }
  
  class Number(n: Int) extends Expr {
  def isNumber:Boolean = true
  def isSum: Boolean = false;
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.lefOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
  
  }
  
  class Sum(e1: Expr, e2: Expr) extends Expr {
  	def isNumber = false
  	def isSum = true
  	def numValue: Int = throw new Error("Sum.numValue")
  	def leftOp: Expr = e1
  	def rightOp: Expr = e2
  }
  
  def eval(e: Expr): Int = {
   if (e.isNumber)  e.numValue
   else if(e.isSum) eval(e.leftOp) + eval(e.rightOp)
   else throw new Error("Unknown Expression" + e)
  }                                               //> eval: (e: week4.decompose.Expr)Int
  
}