object Week23 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
   type Set = Int => Boolean
    val bound = 1000                              //> bound  : Int = 1000
      def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: Int => Boolean)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: Int => Boolean)Unit

   /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
   printSet(s)
    def iter(a: Int): Boolean = {
      if (s(a) && !p(a)) {println("hi"); false}
      else if (a > bound) {println("hi" + a); true}
      else iter(a+1)
    }
    iter(-bound)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean
  
  forall(a => (a==1 || a==3|| a==4||a==5||a==7||a==1000), b => b<5)
                                                  //> {1,3,4,5,7,1000}
                                                  //| hi
                                                  //| res0: Boolean = false
  
  forall(a=> (a>0 && a<5), b => b<5)              //> {1,2,3,4}
                                                  //| hi1001
                                                  //| res1: Boolean = true
  forall (a=> a< -10000, b=> b<10000)             //> {}
                                                  //| hi1001
                                                  //| res2: Boolean = true
                
 def map(s: Set, f: Int => Int): Set = a => if (s(a)) s(f(a)) else s(a)
                                                  //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean
 
 printSet(map(a => (a>0 && a<5), b=> b))          //> {1,2,3,4}
                
}