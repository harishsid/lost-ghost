package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  //println(forall(a => a % 4 == 0, b => b % 2 ==0))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s4 = singletonSet(4)
  val s5 = union(s1, union(s2, union(s3,s4)))
  val s = map(s5, b => b*b)
  printSet(s)
}
