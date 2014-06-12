package week3

object classhierarchy {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val s1= new NonEmpty(2, Empty, Empty)           //> s1  : week3.NonEmpty = {.2.}
  val s2 = s1 incl 3                              //> s2  : week3.IntSet = {.2{.3.}}
  val s3 = s2 incl  1                             //> s3  : week3.IntSet = {{.1.}2{.3.}}
  val s4 = new NonEmpty(5, Empty, Empty)          //> s4  : week3.NonEmpty = {.5.}
  val s5 = s4 incl 4                              //> s5  : week3.IntSet = {{.4.}5.}
  val s6 = s5 incl 6                              //> s6  : week3.IntSet = {{.4.}5{.6.}}
  val s7 = s3 union s6                            //> s7  : week3.IntSet = {{{.1{{.2.}3.}}4.}5{.6.}}
}

// A binary Tree example with class heirarchy. An example of persistent data structure immutable structure.

abstract class IntSet {

def incl(x: Int): IntSet
def contains(x: Int): Boolean
def union(other: IntSet): IntSet

}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	
	def contains(x: Int) = if (x < elem) left contains x
												 else if (x > elem) right contains x
												 else true
	
	def incl(x: Int): IntSet = if (x < elem) new NonEmpty(elem, left incl x, right)
															else if (x > elem) new NonEmpty(elem, left, right incl x)
															else this
															
	def union(other: IntSet): IntSet = ((left union right) union other) incl elem
	
	override def toString = "{" + left + elem + right + "}" // specify override when overriding concrete parent class methods
}
object Empty extends IntSet {

	def contains(x: Int) = false
	
	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	def union(other: IntSet): IntSet = other
	override def toString = "."
	
}