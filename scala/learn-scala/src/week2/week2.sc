import scala.annotation.tailrec
import math.abs

object week2 {
   /**
   * GCD - greatest common denominator using Eclids algorithm
   */
  
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
    }                                             //> gcd: (a: Int, b: Int)Int
  
  /**
   * Factorial example F(n) = N * N- 1 .... * 1
   * Linear recurssion.
   */
  def factorial(n: Int): Int = {
    if (n==0) 1 else n * factorial(n-1)
  }                                               //> factorial: (n: Int)Int
  
  
  /**
   * Factorial example F(n) = N * N- 1 .... * 1
   * with tail recursion
   */
   
  def factorialTail(n: Int): Int = {
   
    def factorialLoop(acc: Int, n: Int): Int = {
      if (n==0) acc else
        factorialLoop(acc * n, n-1)
    }
    factorialLoop(1, n)
  }                                               //> factorialTail: (n: Int)Int
  
  factorialTail(2)                                //> res0: Int = 2
  
  /** Sum of a to b linear recursive way */
  
  def sumOf(a: Int, b: Int): Int = {
   if (a > b) 0 else a + sumOf(a+1, b)
  }                                               //> sumOf: (a: Int, b: Int)Int
  
  sumOf(3, 5)                                     //> res1: Int = 12
  
  def cubeOf(a: Int): Int = a * a* a              //> cubeOf: (a: Int)Int
  
  def sumOfCubes(a: Int, b: Int): Int = {
  	if (a > b) 0 else cubeOf(a) + sumOfCubes(a+1, b)
  }                                               //> sumOfCubes: (a: Int, b: Int)Int
  sumOfCubes(1, 2)                                //> res2: Int = 9
  
  def sumOfFactorial(a: Int, b: Int): Int = {
  	if (a > b) 0 else factorialTail(a) + sumOfFactorial(a+1, b)
  }                                               //> sumOfFactorial: (a: Int, b: Int)Int
  sumOfFactorial(1, 2)                            //> res3: Int = 3
  
  // Higher Order function
  
  def sumHigher(f: Int => Int, a: Int, b: Int): Int = {
   if (a > b) 0 else f(a) + sumHigher(f, a+1, b)
  }                                               //> sumHigher: (f: Int => Int, a: Int, b: Int)Int
  
  sumHigher((a: Int) => a, 1, 10)                 //> res4: Int = 55
  sumHigher(a => a*a, 1, 10)                      //> res5: Int = 385
  sumHigher(cubeOf, 1, 10)                        //> res6: Int = 3025
  
  // Tail recursion sum wiht higher order function
  
  def sumHigherTail(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc else loop(a+1, (f(a) + acc))
  }
  loop(a, 0)
  }                                               //> sumHigherTail: (f: Int => Int, a: Int, b: Int)Int
  
  sumHigherTail(a => a * a, 1, 10)                //> res7: Int = 385
  
 val tolerance = 0.0001                           //> tolerance  : Double = 1.0E-4
 
 def isCloseEnough(x: Double, y: Double) = {
   abs((x-y)/x)/x < tolerance
 }                                                //> isCloseEnough: (x: Double, y: Double)Boolean
 
 def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double= {
   val next = f(guess)
   if (isCloseEnough(guess, next)) next else
   iterate(next)
  }
  iterate(firstGuess)
 }                                                //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
 fixedPoint(x => 1 + x/2)(14)                     //> res8: Double = 2.0003662109375
 
}