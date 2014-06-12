object Week22 {
 def cubeOf(n: Int) = n * n* n                    //> cubeOf: (n: Int)Int
  // Currying - removing repitive declaration of parameters
  def sumHigher2(f: Int => Int): (Int, Int) => Int = {
   def sumF(a: Int, b: Int): Int = {
     if (a > b) 0 else f(a) + sumF(a+1, b)
   }
   sumF
  }                                               //> sumHigher2: (f: Int => Int)(Int, Int) => Int
  // with this now we can define other fuctions as
  def sumOfInts2 = sumHigher2(x => x)             //> sumOfInts2: => (Int, Int) => Int
  def sumOfSq2 = sumHigher2(x => x*x)             //> sumOfSq2: => (Int, Int) => Int
  def sumOfCube2 = sumHigher2(x => x*x*x)         //> sumOfCube2: => (Int, Int) => Int
  // with this we avoided repetitive parameter a & b.
  
  sumOfInts2(1, 2)                                //> res0: Int = 3
  sumOfSq2(1, 10)                                 //> res1: Int = 385
  // Or avoid middleman and directly call single functions
  sumHigher2(cubeOf)(1, 10)                       //> res2: Int = 3025
  
  // shorter version of currying
  
  def sumf(f: Int => Int)(a: Int, b: Int): Int = {
  	if (a > b) 0 else f(a) + sumf(f)(a+1, b)
  }                                               //> sumf: (f: Int => Int)(a: Int, b: Int)Int
  
  def product(f: Int => Int) (a: Int, b: Int): Int = {
  if ( a > b) 1 else f(a) * product(f) (a+1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x=> x*x)(3, 4)                          //> res3: Int = 144
  
  def fact(n: Int) = product(x=> x)(1, n)         //> fact: (n: Int)Int
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int) (a: Int, b:Int): Int= {
   if (a > b) zero else
   combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
  
  def product1(f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b)
                                                  //> product1: (f: Int => Int)(a: Int, b: Int)Int
   product1(x=> x*x)(3, 4)                        //> res4: Int = 144
   def fact1(n: Int) = product1(x => x)(1, n)     //> fact1: (n: Int)Int
   fact1(5)                                       //> res5: Int = 120
   
   
}