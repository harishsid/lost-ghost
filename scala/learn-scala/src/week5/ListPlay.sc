package week5

object ListPlay {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val xs = Nil                                    //> xs  : scala.collection.immutable.Nil.type = List()
  1 :: 2 :: xs                                    //> res0: List[Int] = List(1, 2)
  
  0 :: xs                                         //> res1: List[Int] = List(0)
  
  def last[T] (xs: List[T]): T = xs match {
  	case List() => throw new Error("last of empty list")
  	case List(x) => x
  	case y::ys => last(ys)
  }                                               //> last: [T](xs: List[T])T
  
  def init[T] (xs: List[T]): List[T] = xs match {
  	case List() => throw new Error("last of empty list")
  	case List(x) => List()
  	case y::ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
   case List() => ys
   case z:: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  def reverse[T](xs: List[T]): List[T] = xs match {
   	case List() => xs
   	case y::ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]
  
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
  def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() => List()
  	case h::t => ( h match {
  		case list: List[Any] => flatten(list)
  		case elem => List(elem)
  	}) ::: flatten(t)
  }                                               //> flatten: (xs: List[Any])List[Any]
  
  flatten(List(List(1,2),3,List(4,List(6))))      //> res2: List[Any] = List(1, 2, 3, 4, 6)
  
  
  def msort(xs: List[Int]): List[Int] = {
  	val n = xs.length/2
  	if (n == 0) xs
  	else {
  		def merge(xs: List[Int], ys: List[Int]): List[Int] =
  		xs match {
  			case Nil => ys
  			case x:: xs1 => ys match {
  				case Nil => xs
  				case y:: ys1 =>
  				if (x < y) x :: merge(xs1, ys)
  				else y :: merge(xs, ys1)
  			}
  		
  		}
  		val (f, l) = xs splitAt n
  		merge(msort(f), msort(l))
  	}
  }                                               //> msort: (xs: List[Int])List[Int]
  
  def mergesort(xs: List[Int]): List[Int] = {
  	val n = xs.length/2
  	if (n == 0) xs
  	else {
  		def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
  			case (Nil, ys) => ys
  			case (xs, Nil) => xs
  			case (x::xs1, y::ys1) => if (x < y) x :: merge(xs1, ys) else y :: merge(xs, ys1)
  		}
  		val (f, l) = xs splitAt n
  		merge(mergesort(f), mergesort(l))
  	}
  }                                               //> mergesort: (xs: List[Int])List[Int]
  
  mergesort(List(2,-4,5,7,1))                     //> res3: List[Int] = List(-4, 1, 2, 5, 7)
  
  def mergesort1[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  	val n = xs.length/2
  	if (n == 0) xs
  	else {
  		def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
  			case (Nil, ys) => ys
  			case (xs, Nil) => xs
  			case (x::xs1, y::ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
  		}
  		val (f, l) = xs splitAt n
  		merge(mergesort1(f), mergesort1(l))
  	}
  }                                               //> mergesort1: [T](xs: List[T])(implicit ord: Ordering[T])List[T]
  
  mergesort(List(2,-4,5,7,1))                     //> res4: List[Int] = List(-4, 1, 2, 5, 7)
  
  mergesort1(List("b","d","a","c","z","x"))       //> res5: List[String] = List(a, b, c, d, x, z)
  
  val y = List (1,2,3,4,5)                        //> y  : List[Int] = List(1, 2, 3, 4, 5)
  y map (x => x +1)                               //> res6: List[Int] = List(2, 3, 4, 5, 6)
  
  def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil => List()
  case y::ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  def squareList1(xs: List[Int]): List[Int] = xs map (x => x * x)
                                                  //> squareList1: (xs: List[Int])List[Int]
  squareList(List(1,2,3))                         //> res7: List[Int] = List(1, 4, 9)
  squareList1(List(1,2,3))                        //> res8: List[Int] = List(1, 4, 9)
  
  def posElem(xs: List[Int]): List[Int] = xs match {
    	case Nil => Nil
    	case y::ys => if (y > 0) y :: posElem(ys) else posElem(ys)
    }                                             //> posElem: (xs: List[Int])List[Int]
    
    def posElem1(xs: List[Int]): List[Int] = xs filter(x => x > 0)
                                                  //> posElem1: (xs: List[Int])List[Int]
  
  
}