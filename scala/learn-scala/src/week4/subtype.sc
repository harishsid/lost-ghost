package week4

import week4.List

object subtype {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  // Peano numbers
  abstract class Nat {
   def isZero: Boolean
   def predecessor: Nat
   def successor = new Succ(this)
   def + (that: Nat): Nat
   def - (that: Nat): Nat
  }
  
 
  object Zero extends Nat {
   def isZero = true;
   def predecessor = throw new Error("0.predecessor")
   def + (that: Nat) = that
   def - (that: Nat) = if (that.isZero) this else throw new Error("negative number")
  }
  
   class Succ(n: Nat) extends Nat {
   def isZero = false
   def predecessor = n
   def + (that: Nat) = new Succ(n+that)
   def - (that: Nat) = if (that.isZero) this else n - that.predecessor
  }
  
  // pattern matching
  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(n1: Expr, n2: Expr) extends Expr
  
   def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
   }                                              //> eval: (e: week4.subtype.Expr)Int
   
   def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(l, r) => show(l) + " + " + show(r)
   }                                              //> show: (e: week4.subtype.Expr)String
   
   show(Sum(Number(1), Number(2)))                //> res0: String = 1 + 2
   
   
   
   
  
  
}