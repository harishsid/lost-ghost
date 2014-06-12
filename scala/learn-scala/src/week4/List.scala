package week4

trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  override def toString = "[" + head.toString +" , " + tail.toString + "]"
  
}

class Nil[T] extends List[T] {
  def head = throw new java.util.NoSuchElementException("head of EmptyList")
  def tail = throw new java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true
  override def toString = "[Nil]"
}

object Main extends App {
  
  def singleton[T](elem: T) = new Cons[T] (elem, new Nil[T])
  singleton(1)
  
  println(singleton(true).toString)
}
