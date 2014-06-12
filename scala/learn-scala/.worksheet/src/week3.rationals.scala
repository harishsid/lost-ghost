package week3

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  val r1 = new Rational(1,2);System.out.println("""r1  : week3.Rational = """ + $show(r1 ));$skip(29); 
  val r2 = new Rational(3,4);System.out.println("""r2  : week3.Rational = """ + $show(r2 ));$skip(13); val res$0 = 
  r1.add(r2);System.out.println("""res0: week3.Rational = """ + $show(res$0));$skip(10); val res$1 = 
  r1 + r2;System.out.println("""res1: week3.Rational = """ + $show(res$1));$skip(19); val res$2 = 
  r2.substract(r1);System.out.println("""res2: week3.Rational = """ + $show(res$2));$skip(10); val res$3 = 
  r2 - r1;System.out.println("""res3: week3.Rational = """ + $show(res$3));$skip(13); val res$4 = 
  r2.sub(r1);System.out.println("""res4: week3.Rational = """ + $show(res$4));$skip(15); val res$5 = 
  r2.multi(r1);System.out.println("""res5: week3.Rational = """ + $show(res$5));$skip(16); val res$6 = 
  r2.divide(r1);System.out.println("""res6: week3.Rational = """ + $show(res$6));$skip(13); val res$7 = 
  r2.div(r1);System.out.println("""res7: week3.Rational = """ + $show(res$7));$skip(12); val res$8 = 
  99.toChar;System.out.println("""res8: Char = """ + $show(res$8))}
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
