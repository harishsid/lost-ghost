package common

object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
   def times(chars: List[Char]): List[(Char, Int)] = {
      def _times(chars: List[Char], acc: List[(Char, Int)]):List[(Char,Int)]= {
	  def __times(c: Char, acc: List[(Char, Int)]):List[(Char,Int)]=
	    acc match {
	      case Nil => (c,1)::List()
	      case head::tail if head._1 == c => (c,head._2+1) :: tail
	      case head::tail => head :: __times(c,tail)
	    }
	  chars match {
	    case Nil => acc
	    case head::tail => _times(tail,__times(head,acc))
	  }
	}
      _times(chars,List())
    }                                             //> times: (chars: List[Char])List[(Char, Int)]
    
    
    times("acbcbabcaabdz".toList)                 //> res0: List[(Char, Int)] = List((a,4), (c,3), (b,4), (d,1), (z,1))
    
    val a = 1 :: 2 :: Nil                         //> a  : List[Int] = List(1, 2)
    
    
    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
     case List() => List(x)
     case y::ys => if (x <= y) x :: xs else y :: insert(x, ys)
    }                                             //> insert: (x: Int, xs: List[Int])List[Int]
    
    def isort(xs: List[Int]) : List[Int] =  xs match {
     case List() => List()
     case y :: ys => insert(y, isort(ys))
    }                                             //> isort: (xs: List[Int])List[Int]
    
    isort(List(2,9,4,3,7,9))                      //> res1: List[Int] = List(2, 3, 4, 7, 9, 9)
    
    
}