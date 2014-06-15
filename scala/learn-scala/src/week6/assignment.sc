package week6

object assignment {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  "WEl come".toLowerCase.filter(_.isLetter)       //> res0: String = welcome
  
  def combination(ls: List[(Char, Int)]): List[List[(Char, Int)]] = ls match {
    case List() => List(List())
    case (char, count)::xs =>  {
      val prev = combination(xs)
      prev ::: (for {
    	  comb <- prev
    	  c <- 1 to count
      } yield ((char, c) :: comb))
    }
    }                                             //> combination: (ls: List[(Char, Int)])List[List[(Char, Int)]]
    
   
}