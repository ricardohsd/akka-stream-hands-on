package com.github.ricardohsd

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.testkit.scaladsl.TestSink
import org.scalatest.{FunSuite, Matchers}

class Part03MergeTest extends FunSuite with Matchers {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  val stream = new Part03Merge()

  test("mergeSources") {
    stream.mergeSources()
      .runWith(TestSink.probe[String])
      .request(3)
      .expectNext("foo", "baz", "bar")
      .expectComplete()
  }

  test("concatSources") {
    stream.concatSources()
      .runWith(TestSink.probe[String])
      .request(3)
      .expectNext("foo", "bar", "baz")
      .expectComplete()
  }
}
