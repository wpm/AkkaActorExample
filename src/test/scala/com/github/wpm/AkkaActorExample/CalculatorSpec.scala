package com.github.wpm.AkkaActorExample

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, TestKit, ImplicitSender}
import org.scalatest.{BeforeAndAfterAll, FlatSpec}
import com.github.wpm.AkkaActorExample.Calculator._

class CalculatorSpec extends TestKit(ActorSystem("Example")) with ImplicitSender with FlatSpec with BeforeAndAfterAll {

  behavior of "Calculator"

  def calculator = TestActorRef[Calculator]

  it should "Add 2 + 3 = 5" in {
    calculator ! Add(2, 3)
    expectMsg(5)
  }

  it should "Subtract 10 - 7 = 3" in {
    calculator ! Subtract(10, 7)
    expectMsg(3)
  }

  it should "Multiply 6 * 8 = 48" in {
    calculator ! Multiply(6, 8)
    expectMsg(48)
  }

  it should "Divide 12 / 2 = 6" in {
    calculator ! Divide(12, 2)
    expectMsg(6)
  }

  override protected def afterAll() { system.shutdown() }
}
