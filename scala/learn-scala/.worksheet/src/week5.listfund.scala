package week5

object listfund {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(33); 
  
  val nums = List(2,-4,5,7,1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "oragne", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(30); val res$0 = 
  
  nums filter (x => x > 0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(29); val res$1 = 
  nums filterNot(x => x > 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(30); val res$2 = 
  nums partition (x => x > 0);System.out.println("""res2: (List[Int], List[Int]) = """ + $show(res$2));$skip(29); val res$3 = 
  nums takeWhile(x => x > 0);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(29); val res$4 = 
  nums dropWhile(x => x > 0);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(25); val res$5 = 
  nums span (x => x > 0);System.out.println("""res5: (List[Int], List[Int]) = """ + $show(res$5));$skip(51); 
  
  val data = List("a", "a", "b", "c", "c", "a");System.out.println("""data  : List[String] = """ + $show(data ));$skip(165); 
 
  def pack[T] (xs: List[T]): List[List[T]] = xs match {
  	case Nil => Nil
  	case y::ys =>
  	val (first, rest) = xs span (x=> y == x)
  	first :: pack(rest)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(13); val res$6 = 
  pack(data);System.out.println("""res6: List[List[String]] = """ + $show(res$6));$skip(90); 
  
  def encode[T] (xs: List[T]): List[(T, Int)] = pack(xs) map (y => (y.head, y.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(50); val res$7 = 
  encode(List("a", "a","a", "b", "c", "c", "a") );System.out.println("""res7: List[(String, Int)] = """ + $show(res$7));$skip(66); 
  
 def sum(xs: List[Int]) = (0 :: xs) reduceLeft((x,y) => x + y);System.out.println("""sum: (xs: List[Int])Int""");$skip(59); 
  def product(xs: List[Int]) = (1 :: xs) reduceLeft(_ * _);System.out.println("""product: (xs: List[Int])Int""")}
  
  }
