
package week6

object maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val romanNUmerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNUmerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
  
  val capitalOfCountry = Map( "US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  
  capitalOfCountry.get("andorra")                 //> res0: Option[String] = None
  
  def showCapital(country: String) = capitalOfCountry.get(country) match {
  	case Some(capital) => capital
  	case None => "missing data"
  }                                               //> showCapital: (country: String)String
  
  showCapital("US")                               //> res1: String = Washington
  showCapital("Andorra")                          //> res2: String = missing data
  
  
  }