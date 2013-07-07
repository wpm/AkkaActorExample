package com.github.wpm.AkkaActorExample

import akka.actor.{Props, ActorSystem, Actor}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._

class Calculator extends Actor {

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

    implicit val timeout = Timeout(10.seconds)

    import scala.concurrent.ExecutionContext.Implicits.global
    val resultFuture = for (twoPlusFour <- (calculator ? Add(2, 4)).mapTo[Int];
                            sixMinusThree <- (calculator ? Subtract(6, 3)).mapTo[Int];
                            product <- (calculator ? Multiply(twoPlusFour, sixMinusThree)).mapTo[Int])
    yield product
    val result = Await.result(resultFuture, 10.seconds)
    println(result)

    system.shutdown()
  }
}
