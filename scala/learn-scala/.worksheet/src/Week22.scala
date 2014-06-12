object Week22 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(46); 
 def cubeOf(n: Int) = n * n* n;System.out.println("""cubeOf: (n: Int)Int""");$skip(212); 
  // Currying - removing repitive declaration of parameters
  def sumHigher2(f: Int => Int): (Int, Int) => Int = {
   def sumF(a: Int, b: Int): Int = {
     if (a > b) 0 else f(a) + sumF(a+1, b)
   }
   sumF
  };System.out.println("""sumHigher2: (f: Int => Int)(Int, Int) => Int""");$skip(89); 
  // with this now we can define other fuctions as
  def sumOfInts2 = sumHigher2(x => x);System.out.println("""sumOfInts2: => (Int, Int) => Int""");$skip(38); 
  def sumOfSq2 = sumHigher2(x => x*x);System.out.println("""sumOfSq2: => (Int, Int) => Int""");$skip(42); 
  def sumOfCube2 = sumHigher2(x => x*x*x);System.out.println("""sumOfCube2: => (Int, Int) => Int""");$skip(76); val res$0 = 
  // with this we avoided repetitive parameter a & b.
  
  sumOfInts2(1, 2);System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
  sumOfSq2(1, 10);System.out.println("""res1: Int = """ + $show(res$1));$skip(87); val res$2 = 
  // Or avoid middleman and directly call single functions
  sumHigher2(cubeOf)(1, 10);System.out.println("""res2: Int = """ + $show(res$2));$skip(138); 
  
  // shorter version of currying
  
  def sumf(f: Int => Int)(a: Int, b: Int): Int = {
  	if (a > b) 0 else f(a) + sumf(f)(a+1, b)
  };System.out.println("""sumf: (f: Int => Int)(a: Int, b: Int)Int""");$skip(110); 
  
  def product(f: Int => Int) (a: Int, b: Int): Int = {
  if ( a > b) 1 else f(a) * product(f) (a+1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(25); val res$3 = 
  product(x=> x*x)(3, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(45); 
  
  def fact(n: Int) = product(x=> x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(179); 
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a: Int, b:Int): Int= {
   if (a > b) zero else
   combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(96); 
  
  def product1(f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b);System.out.println("""product1: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$4 = 
   product1(x=> x*x)(3, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(46); 
   def fact1(n: Int) = product1(x => x)(1, n);System.out.println("""fact1: (n: Int)Int""");$skip(12); val res$5 = 
   fact1(5);System.out.println("""res5: Int = """ + $show(res$5))}
   
   
}
