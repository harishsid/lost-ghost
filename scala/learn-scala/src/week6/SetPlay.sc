package week6

object SetPlay {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def queens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] =
  	if (k ==0) Set(List())
  	else
  		for {
  			queens <- placeQueens(k-1)
  			col <- 0 until n
  			if isSafe(col, queens)
  			} yield col :: queens
  	 placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  
 
  
  def isSafe(col: Int, queens: List[Int]): Boolean =  {
  	val row = queens.length
  	val queensWithRow = (row -1 to 0 by -1) zip queens
  	queensWithRow forall {
  		 case (r, c) => col!= c && math.abs(col -c) != row -r
  		}
  }                                               //> isSafe: (col: Int, queens: List[Int])Boolean
  queens(4)                                       //> res0: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
  def show(queens: List[Int]) = {
  val lines =
  	for (col <- queens.reverse)
  		yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  		
     "\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])String
  (queens(4) map show) mkString "\n"              //> res1: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
    val q = List(1, 3, 0, 2)                      //> q  : List[Int] = List(1, 3, 0, 2)
    val r = q.length                              //> r  : Int = 4
    val queensWithRow = (r -1 to 0 by -1) zip q   //> queensWithRow  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector(
                                                  //| (3,1), (2,3), (1,0), (0,2))
    
    
}