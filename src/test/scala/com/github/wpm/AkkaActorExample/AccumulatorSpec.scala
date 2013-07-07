package com.github.wpm.AkkaActorExample

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, FlatSpec}
import com.github.wpm.AkkaActorExample.Accumulator._

class AccumulatorSpec extends TestKit(ActorSystem("Example")) with ImplicitSender with FlatSpec with BeforeAndAfterAll {

  behavior of "Accumulator"

  def accumulatorFixture = TestActorRef[Accumulator]

  it should "accumulate new items" in {
    val actor = accumulatorFixture.underlyingActor
    actor.receive(Add(2))
    actor.receive(Add(3))
    actor.receive(Add(5))
    expectResult(actor.set)(Set(2, 3, 5))
  }

  it should "return accumulated items" in {
    var accumulator = accumulatorFixture
    val actor = accumulator.underlyingActor
    actor.set = Set(2, 3, 5)
    accumulator ! Get
    expectMsg(Set(2, 3, 5))
  }

  it should "initially be empty" in {
    accumulatorFixture ! Get
    expectMsg(Set.empty[Int])
  }

  override protected def afterAll() { system.shutdown() }
}
