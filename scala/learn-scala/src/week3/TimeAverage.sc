package week3

object TimeAverage {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val l1 = LapTime("20:20:80")                    //> l1  : week3.LapTime = 20:20:80
  val l2 = LapTime("40:40:80")                    //> l2  : week3.LapTime = 40:40:80
  val l3 = l1 <> l2                               //> l3  : week3.LapTime = 30:30:80
  val a = 'c'                                     //> a  : Char = c
  

}

// Class enclosing Lap time and define function to perform add and average functionality
class LapTime(val min: BigInt, val sec: BigInt, val mil: BigInt) {

  // method adds two lap time and roll over each units to next level if exceed max value
  private def +(time: LapTime): LapTime = {
    val mili = (mil + time.mil) /% LapTime.MIL_FOR_SEC
    val s = (sec + time.sec + mili._1) /% LapTime.SEC_FOR_MIN
    val m = (min + time.min + s._1)
    LapTime(m, s._2, mili._2)
  }

  // method to average with lap time passed, it adds both time and time average it by 2
  def ave(time: LapTime): LapTime = {
    val total = this + time // add time
    val m = total.min /% LapTime.AVE_UNIT // add mintue and average
    val s = (total.sec + m._2 * LapTime.SEC_FOR_MIN) /% LapTime.AVE_UNIT // add seconds and reminder from mintue average
    val mili = (total.mil + s._2 * LapTime.MIL_FOR_SEC) / LapTime.AVE_UNIT // add mili and reminder from seconds average
    LapTime(m._1, s._1, mili)
  }

  def <>(time: LapTime): LapTime = {
    val m = (min + time.min) /% LapTime.AVE_UNIT // add mintue and average
    val s = (sec + time.sec + m._2 * LapTime.SEC_FOR_MIN) /% LapTime.AVE_UNIT // add seconds and reminder from mintue average
    val mili = (mil + time.mil + s._2 * LapTime.MIL_FOR_SEC) / LapTime.AVE_UNIT // add mili and reminder from seconds average
    LapTime(m._1, s._1, mili)
  }
  override def toString = min + ":" + sec + ":" + mil

}

// companion object to define constants and apply methods for object consturction
object LapTime {
  final val MIL_FOR_SEC = 100
  final val SEC_FOR_MIN = 60
  final val AVE_UNIT = 2

  def apply(time: String): LapTime = {
    val tokens = time.split(":")
    LapTime(BigInt(tokens(0)), BigInt(tokens(1)), BigInt(tokens(2)))

  }

  def apply(min: BigInt, sec: BigInt, mil: BigInt): LapTime = {
    new LapTime(min, sec, mil)
  }

}