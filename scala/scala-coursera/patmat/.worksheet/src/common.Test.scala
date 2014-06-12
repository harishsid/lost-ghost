package common

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(512); 
  
  
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
    };System.out.println("""times: (chars: List[Char])List[(Char, Int)]""");$skip(44); val res$0 = 
    
    
    times("acbcbabcaabdz".toList);System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(23); val res$1 = 
    
    1 :: 2 :: Nil;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(164); 
    
    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
     case List() => List(x)
     case y::ys => if (x <= y) x :: xs else y :: insert(x, ys)
    };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(135); 
    
    def isort(xs: List[Int]) : List[Int] =  xs match {
     case List() => List()
     case y :: ys => insert(y, isort(ys))
    };System.out.println("""isort: (xs: List[Int])List[Int]""");$skip(34); val res$2 = 
    
    isort(List(2,9,4,3,7,9));System.out.println("""res2: List[Int] = """ + $show(res$2))}
}
