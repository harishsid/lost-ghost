import scala.annotation.tailrec
import math.abs

object week2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(219); 
   /**
   * GCD - greatest common denominator using Eclids algorithm
   */
  
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
    };System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(164); 
  
  /**
   * Factorial example F(n) = N * N- 1 .... * 1
   * Linear recurssion.
   */
  def factorial(n: Int): Int = {
    if (n==0) 1 else n * factorial(n-1)
  };System.out.println("""factorial: (n: Int)Int""");$skip(280); 
  
  
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
  };System.out.println("""factorialTail: (n: Int)Int""");$skip(22); val res$0 = 
  
  factorialTail(2);System.out.println("""res0: Int = """ + $show(res$0));$skip(130); 
  
  /** Sum of a to b linear recursive way */
  
  def sumOf(a: Int, b: Int): Int = {
   if (a > b) 0 else a + sumOf(a+1, b)
  };System.out.println("""sumOf: (a: Int, b: Int)Int""");$skip(17); val res$1 = 
  
  sumOf(3, 5);System.out.println("""res1: Int = """ + $show(res$1));$skip(40); 
  
  def cubeOf(a: Int): Int = a * a* a;System.out.println("""cubeOf: (a: Int)Int""");$skip(101); 
  
  def sumOfCubes(a: Int, b: Int): Int = {
  	if (a > b) 0 else cubeOf(a) + sumOfCubes(a+1, b)
  };System.out.println("""sumOfCubes: (a: Int, b: Int)Int""");$skip(19); val res$2 = 
  sumOfCubes(1, 2);System.out.println("""res2: Int = """ + $show(res$2));$skip(116); 
  
  def sumOfFactorial(a: Int, b: Int): Int = {
  	if (a > b) 0 else factorialTail(a) + sumOfFactorial(a+1, b)
  };System.out.println("""sumOfFactorial: (a: Int, b: Int)Int""");$skip(23); val res$3 = 
  sumOfFactorial(1, 2);System.out.println("""res3: Int = """ + $show(res$3));$skip(142); 
  
  // Higher Order function
  
  def sumHigher(f: Int => Int, a: Int, b: Int): Int = {
   if (a > b) 0 else f(a) + sumHigher(f, a+1, b)
  };System.out.println("""sumHigher: (f: Int => Int, a: Int, b: Int)Int""");$skip(37); val res$4 = 
  
  sumHigher((a: Int) => a, 1, 10);System.out.println("""res4: Int = """ + $show(res$4));$skip(29); val res$5 = 
  sumHigher(a => a*a, 1, 10);System.out.println("""res5: Int = """ + $show(res$5));$skip(27); val res$6 = 
  sumHigher(cubeOf, 1, 10);System.out.println("""res6: Int = """ + $show(res$6));$skip(224); 
  
  // Tail recursion sum wiht higher order function
  
  def sumHigherTail(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc else loop(a+1, (f(a) + acc))
  }
  loop(a, 0)
  };System.out.println("""sumHigherTail: (f: Int => Int, a: Int, b: Int)Int""");$skip(38); val res$7 = 
  
  sumHigherTail(a => a * a, 1, 10);System.out.println("""res7: Int = """ + $show(res$7));$skip(27); 
  
 val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(80); 
 
 def isCloseEnough(x: Double, y: Double) = {
   abs((x-y)/x)/x < tolerance
 };System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(217); 
 
 def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double= {
   val next = f(guess)
   if (isCloseEnough(guess, next)) next else
   iterate(next)
  }
  iterate(firstGuess)
 };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(30); val res$8 = 
 fixedPoint(x => 1 + x/2)(14);System.out.println("""res8: Double = """ + $show(res$8))}
 
}
