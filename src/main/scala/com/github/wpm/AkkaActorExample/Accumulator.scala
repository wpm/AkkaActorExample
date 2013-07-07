package com.github.wpm.AkkaActorExample

import akka.actor.Actor

class Accumulator extends Actor {

  import Accumulator._

  var set = Set.empty[Int]

  def receive = {
    case Add(x) => set += x
    case Get => sender ! set
  }
}

object Accumulator {

  case class Add(x: Int)

  case object Get

}
