package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c <= 0 || r <= 0 || c >= r) 1 else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanceCount(counter: Int, chars: List[Char]): Int = {
      if (chars.isEmpty) counter else {
        if (chars.head.==('('))
          balanceCount(counter + 1, chars.tail)
        else if (chars.head.==(')')) {
          if (counter <= 0) counter - 1 else
            balanceCount(counter - 1, chars.tail)
        } else balanceCount(counter, chars.tail)
      }
    }
    balanceCount(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty) 0 else {
      val sortedCoins = coins.sortWith((a, b) => a < b)
      if (money - coins.head == 0) 1 else {
        countChange(money, sortedCoins.tail) + countChange(money - sortedCoins.head, sortedCoins)
      }
    }
  }
}
