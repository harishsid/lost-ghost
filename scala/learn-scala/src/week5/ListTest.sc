package week5

object ListTest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def init[T](xs: List[T]): List[T] = xs match {
  	case List() => throw new Error("Empty list")
  	case List(x) => List()
  	case y::ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  init(List(1,2,3,4,5,6))                         //> res0: List[Int] = List(1, 2, 3, 4, 5)
  
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  
  	val n = xs.length/2
  	if (n ==0) xs
  	else {
  		def merge(xs:List[T], ys: List[T]): List[T] = (xs, ys) match {
  			case (Nil, ys) => ys
  			case (xs, Nil) => xs
  			case (x::xs1, y::ys1) =>
  				if (lt(x,y)) x:: merge(xs1, ys)
  				else y:: merge(xs, ys1)
  		}
  		val (f,l) = xs splitAt n
  		merge(msort(f)(lt), msort(l)(lt))
  	}
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  
 msort(List(4,1,3,-10,10,15,2))((x, y) => x < y)  //> res1: List[Int] = List(-10, 1, 2, 3, 4, 10, 15)
  
  val fruits = List("apple", "pineapple", "orrange", "banna")
                                                  //> fruits  : List[String] = List(apple, pineapple, orrange, banna)
  msort(fruits)((x, y) => (x compareTo y) < 0)    //> res2: List[String] = List(apple, banna, orrange, pineapple)
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldRight ys) (_ :: _)
                                                  //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  List(1,2).foldLeft(List(0))(_ ++ List(_))       //> res3: List[Int] = List(0, 1, 2)
  
  concat (fruits, Nil)                            //> res4: List[String] = List(apple, pineapple, orrange, banna)
  
  
  def mapFund[T,U](xs: List[T], f: T=> U): List[U] = (xs foldRight List[U]()) (f(_) :: _)
                                                  //> mapFund: [T, U](xs: List[T], f: T => U)List[U]
                                                  
 	 
 
 def f(x: Int) = x + 1                            //> f: (x: Int)Int
 
 List(1,2) map (_ +1)                             //> res5: List[Int] = List(2, 3)
 
  mapFund(List(1,3), (x: Int) => x + 1)           //> res6: List[Int] = List(2, 4)
  
  def leghtFun[T](xs: List[T]): Int = (xs foldRight 0) ((_, l) => l +1)
                                                  //> leghtFun: [T](xs: List[T])Int
  leghtFun(List("a","b","c"))                     //> res7: Int = 3
}