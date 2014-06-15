package week6

object CollectionPlay {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
   val nums = Vector(1,2,3)                       //> nums  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3)
  val people = Vector("Mat", "Devin")             //> people  : scala.collection.immutable.Vector[String] = Vector(Mat, Devin)
  
  0 +: nums                                       //> res0: scala.collection.immutable.Vector[Int] = Vector(0, 1, 2, 3)
  
  people :+ "Meghan"                              //> res1: scala.collection.immutable.Vector[String] = Vector(Mat, Devin, Meghan)
                                                  //| 
  
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (_ *2)                                   //> res2: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  
  s filter (_.isUpper)                            //> res3: String = HW
  
  val n  = 7                                      //> n  : Int = 7
  
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ !=0)
                                                  //> isPrime: (n: Int)Boolean
  
  val pairs = (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter(pair =>
  isPrime(pair._1 + pair._2))                     //> pairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (
                                                  //| 3,2), (4,1), (4,3), (5,2), (6,1), (6,5))
  
  for  {
  	i <- 1 until n
  	j <- 1 until i
    if  isPrime(i +j)
    } yield (i, j)                                //> res4: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
    
    def scalaProduct(xs: List[Double], ys: List[Double]): Double = ( for((x, y) <- xs zip ys) yield x * y) sum
                                                  //> scalaProduct: (xs: List[Double], ys: List[Double])Double
}