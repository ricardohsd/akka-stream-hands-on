package com.github.ricardohsd

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.testkit.scaladsl.TestSink
import org.scalatest.{FunSuite, Matchers}

class Part01SourceTest extends FunSuite with Matchers {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  val stream = new Part01()

  test("emptySource") {
    stream.emptySource()
      .runWith(TestSink.probe)
      .expectSubscriptionAndComplete()
  }

  test("fromValues") {
    stream.fromValues()
      .runWith(TestSink.probe[String])
      .requestNext("foo")
      .requestNext("bar")
      .expectComplete()
  }

  test("fooSource") {
    stream.fooSource()
      .runWith(TestSink.probe[String])
      .requestNext("foo")
      .expectComplete()
  }

  test("errorSource") {
    stream.errorSource()
      .runWith(TestSink.probe)
      .expectSubscriptionAndError(CustomException("Failed source"))
  }

  test("counter") {
    stream.counter()
      .runWith(TestSink.probe[Int])
      .request(10)
      .expectNext(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
      .expectComplete()
  }
}
