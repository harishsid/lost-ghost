package com.eqt.akka

import akka.actor.ActorSystem
import akka.actor.Props

object Main extends App {
  
  val system = ActorSystem("MySystem")
  val greeter = system.actorOf(Props[GreetingActor], name = "greeter")
  greeter ! Greeting("Charlie Parker")

}