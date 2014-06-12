package week5

object ListPlay {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(18); 
  
  val xs = Nil;System.out.println("""xs  : scala.collection.immutable.Nil.type = """ + $show(xs ));$skip(15); val res$0 = 
  1 :: 2 :: xs;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(13); val res$1 = 
  
  0 :: xs;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(154); 
  
  def last[T] (xs: List[T]): T = xs match {
  	case List() => throw new Error("last of empty list")
  	case List(x) => x
  	case y::ys => last(ys)
  };System.out.println("""last: [T](xs: List[T])T""");$skip(170); 
  
  def init[T] (xs: List[T]): List[T] = xs match {
  	case List() => throw new Error("last of empty list")
  	case List(x) => List()
  	case y::ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(130); 
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
   case List() => ys
   case z:: zs => z :: concat(zs, ys)
  };System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(122); 
  
  def reverse[T](xs: List[T]): List[T] = xs match {
   	case List() => xs
   	case y::ys => reverse(ys) ++ List(y)
  };System.out.println("""reverse: [T](xs: List[T])List[T]""");$skip(74); 
  
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(201); 
  def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() => List()
  	case h::t => ( h match {
  		case list: List[Any] => flatten(list)
  		case elem => List(elem)
  	}) ::: flatten(t)
  };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(48); val res$2 = 
  
  flatten(List(List(1,2),3,List(4,List(6))));System.out.println("""res2: List[Any] = """ + $show(res$2));$skip(421); 
  
  
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
  };System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(395); 
  
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
  };System.out.println("""mergesort: (xs: List[Int])List[Int]""");$skip(33); val res$3 = 
  
  mergesort(List(2,-4,5,7,1));System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(425); 
  
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
  };System.out.println("""mergesort1: [T](xs: List[T])(implicit ord: Ordering[T])List[T]""");$skip(33); val res$4 = 
  
  mergesort(List(2,-4,5,7,1));System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(47); val res$5 = 
  
  mergesort1(List("b","d","a","c","z","x"));System.out.println("""res5: List[String] = """ + $show(res$5));$skip(30); 
  
  val y = List (1,2,3,4,5);System.out.println("""y  : List[Int] = """ + $show(y ));$skip(20); val res$6 = 
  y map (x => x +1);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(124); 
  
  def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil => List()
  case y::ys => y * y :: squareList(ys)
  };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(69); 
  
  def squareList1(xs: List[Int]): List[Int] = xs map (x => x * x);System.out.println("""squareList1: (xs: List[Int])List[Int]""");$skip(26); val res$7 = 
  squareList(List(1,2,3));System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(27); val res$8 = 
  squareList1(List(1,2,3));System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(147); 
  
  def posElem(xs: List[Int]): List[Int] = xs match {
    	case Nil => Nil
    	case y::ys => if (y > 0) y :: posElem(ys) else posElem(ys)
    };System.out.println("""posElem: (xs: List[Int])List[Int]""");$skip(72); 
    
    def posElem1(xs: List[Int]): List[Int] = xs filter(x => x > 0);System.out.println("""posElem1: (xs: List[Int])List[Int]""")}
  
  
}
