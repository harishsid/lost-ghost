package sampleworksheet

object HelloScalaworksheet {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val x=5                                         //> x  : Int = 5
  
  val y=6                                         //> y  : Int = 6
  
  var text1: String = "ABC"                       //> text1  : String = ABC
  
  var text2 = "DEF"                               //> text2  : String = DEF
  var myvar = 12                                  //> myvar  : Int = 12
  
  def addNumber(x: Int, y:Int) = x + y            //> addNumber: (x: Int, y: Int)Int
  
  addNumber(1, y)                                 //> res0: Int = 7
  
  class Calculator() {
  	def add(x: Int, y: Int) = x + y
  }
  
  class Book(val title: String, val author: String) {
     override def toString() = title
  
  }
  
  val b = new Book("Scala","Martin")              //> b  : sampleworksheet.HelloScalaworksheet.Book = Scala
  
  b.title                                         //> res1: String = Scala
  b.author                                        //> res2: String = Martin
  
}