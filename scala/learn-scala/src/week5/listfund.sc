package week5

object listfund {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val nums = List(2,-4,5,7,1)                     //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "oragne", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, oragne, banana)
  
  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot(x => x > 0)                      //> res1: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  nums takeWhile(x => x > 0)                      //> res3: List[Int] = List(2)
  nums dropWhile(x => x > 0)                      //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
  
  val data = List("a", "a", "b", "c", "c", "a")   //> data  : List[String] = List(a, a, b, c, c, a)
 
  def pack[T] (xs: List[T]): List[List[T]] = xs match {
  	case Nil => Nil
  	case y::ys =>
  	val (first, rest) = xs span (x=> y == x)
  	first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  pack(data)                                      //> res6: List[List[String]] = List(List(a, a), List(b), List(c, c), List(a))
  
  def encode[T] (xs: List[T]): List[(T, Int)] = pack(xs) map (y => (y.head, y.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
  encode(List("a", "a","a", "b", "c", "c", "a") ) //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  
 def sum(xs: List[Int]) = (0 :: xs) reduceLeft((x,y) => x + y)
                                                  //> sum: (xs: List[Int])Int
  def product(xs: List[Int]) = (1 :: xs) reduceLeft(_ * _)
                                                  //> product: (xs: List[Int])Int
  
  }