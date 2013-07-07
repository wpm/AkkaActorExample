package com.github.wpm.AkkaToy

import akka.actor.{Props, ActorSystem, Actor, ActorLogging}
import akka.pattern.ask
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.util.Timeout

class Calculator extends Actor with ActorLogging {

  import Calculator._

  def receive = {
    case Add(x, y) => sender ! x + y
    case Subtract(x, y) => sender ! x - y
    case Multiply(x, y) => sender ! x * y
    case Divide(x, y) => sender ! x / y
  }
}

object Calculator {

  case class Add(x: Int, y: Int)

  case class Subtract(x: Int, y: Int)

  case class Multiply(x: Int, y: Int)

  case class Divide(x: Int, y: Int)

  def main(args: Array[String]) {
    val system = ActorSystem("Math")
    val calculator = system.actorOf(Props[Calculator], "Calculator")

    implicit val timeout = Timeout(10 seconds)
    val result = Await.result(calculator ? Add(2, 4), 10 seconds)
    println(result)

    system.shutdown()
  }
}
