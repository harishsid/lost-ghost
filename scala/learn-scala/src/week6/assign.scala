package week6

object assign extends App {

  
  def combination(ls: List[(Char, Int)]): List[List[(Char, Int)]] = ls match {
  	case Nil => List(List())
  	case x:: xs =>
  		val combs = combination(xs)
        combs ::: (for {
          comb <- combs
          i <- 1 to x._2
        } yield (x._1, i) :: comb)
     }                                            //> combination: (ls: List[(Char, Int)])List[List[(Char, Int)]]
     combination(List(('a',2))) 
}