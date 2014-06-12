package week3

object classhierarchy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
  println("Welcome to the Scala worksheet");$skip(43); 
  
  val s1= new NonEmpty(2, Empty, Empty);System.out.println("""s1  : week3.NonEmpty = """ + $show(s1 ));$skip(21); 
  val s2 = s1 incl 3;System.out.println("""s2  : week3.IntSet = """ + $show(s2 ));$skip(22); 
  val s3 = s2 incl  1;System.out.println("""s3  : week3.IntSet = """ + $show(s3 ));$skip(41); 
  val s4 = new NonEmpty(5, Empty, Empty);System.out.println("""s4  : week3.NonEmpty = """ + $show(s4 ));$skip(21); 
  val s5 = s4 incl 4;System.out.println("""s5  : week3.IntSet = """ + $show(s5 ));$skip(21); 
  val s6 = s5 incl 6;System.out.println("""s6  : week3.IntSet = """ + $show(s6 ));$skip(23); 
  val s7 = s3 union s6;System.out.println("""s7  : week3.IntSet = """ + $show(s7 ))}
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
