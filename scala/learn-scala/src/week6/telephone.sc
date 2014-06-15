package week6

import scala.io.Source

object telephone {
  /* read a file of words */
  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
                                                  //> in  : scala.io.BufferedSource = non-empty iterator
  
  /* create a list and filter all words where *all* their characters are not letters (like dashes) */
  val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))
                                                  //> words  : List[String] = List()
  
  /* define the map of numbers to letters */
  val nmem = Map( '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
                                                  //> nmem  : scala.collection.immutable.Map[Char,String] = Map(8 -> TUV, 4 -> GHI
                                                  //| , 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
  
  /* invert the map the get a map of letters to digits */
  val charCode: Map[Char, Char] = for ((digit, str) <- nmem; ltr <- str) yield ltr -> digit
                                                  //> charCode  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J -
                                                  //| > 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 5,
                                                  //|  B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, Z -
                                                  //| > 9, S -> 7)
  
  /* define a function that returns the numbers of a given word */
  def wordCode(word: String): String = word.toUpperCase map charCode
                                                  //> wordCode: (word: String)String
  
  /* group all words of our long list with the same number */
  val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq()
                                                  //> wordsForNum  : Map[String,Seq[String]] = Map()
  
  /* function that receives a number and finds the words that match it */
  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length // iterate over the number
        word <- wordsForNum(number take split) // get the word before the spilt
        rest <- encode(number drop split) //get the words after the split
      } yield word :: rest // join the results
    }.toSet // pass a set to the for              //> encode: (number: String)Set[List[String]]
 
  /* better print of the results */
  def translate(number: String): Set[String] = encode(number) map (_ mkString " ")
                                                  //> translate: (number: String)Set[String]
 
  /* test the translate and print results*/
  translate("7225247386") foreach println
  
}