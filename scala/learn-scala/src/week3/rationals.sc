package week3

object rationals {
  val r1 = new Rational(1,2)                      //> r1  : week3.Rational = 1/2
  val r2 = new Rational(3,4)                      //> r2  : week3.Rational = 3/4
  r1.add(r2)                                      //> res0: week3.Rational = 10/8
  r1 + r2                                         //> res1: week3.Rational = 10/8
  r2.substract(r1)                                //> res2: week3.Rational = 2/8
  r2 - r1                                         //> res3: week3.Rational = 2/8
  r2.sub(r1)                                      //> res4: week3.Rational = 2/8
  r2.multi(r1)                                    //> res5: week3.Rational = 3/8
  r2.divide(r1)                                   //> res6: week3.Rational = 6/4
  r2.div(r1)                                      //> res7: week3.Rational = 6/4
  99.toChar                                       //> res8: Char = c
}

class Rational(x: Int, y: Int) {
	def numer = x
	def denom = y
	
	
	
	def neg: Rational = new Rational(-numer, denom)
	
	// Unary operator to replace neg
	
	def unary_- : Rational = new Rational(-numer, denom)
	
	def add(that: Rational) = {
	   new Rational(
	   numer * that.denom + that.numer * denom,
	   denom*that.denom)
	}
	
	def + (that: Rational) = {
	   new Rational(
	   numer * that.denom + that.numer * denom,
	   denom*that.denom)
	}
	
	def substract(that: Rational) = {
		new Rational(
	   numer * that.denom - that.numer * denom,
	   denom*that.denom)
	}
	
	def - (that: Rational) = this + -that
	
	def < (that: Rational) = numer * that.denom < that.numer * denom
	
	def max(that: Rational) = if (this < that) that else this
	
	
	
	def sub(that: Rational) = add(that.neg) // DRY - Don't repeate u r self principle
	
	def multi(that: Rational) = {
		new Rational(
	   numer *  that.numer,
	   denom*that.denom)
	}
	
	def divide(that: Rational) = {
		new Rational(
	   numer *  that.denom,
	   denom*that.numer)
	}
	
	def reverse: Rational = new Rational(denom, numer)
	
	def div(that: Rational) = multi(that.reverse)
	
	override def toString = numer + "/" + denom
}