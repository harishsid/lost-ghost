package asts

sealed trait Order {
  
  def orderId: Int
  def pmInitials: String

}

case class EquityOrder(val orderId: Int, val pmInitials: String) extends Order

case class HightIncomeOrder(val orderId: Int, val pmInitials: String, val someSepcialHIAttribute: String) extends Order


package object caseclasses {
  
  def processOrder(order: Order) = order match {
    case EquityOrder(oId, pmInit) => println(s"$pmInit submitted $oId")
    case HightIncomeOrder(oId, pmInit, special) => println(s"$pmInit submitted $oId")
  }
  
}