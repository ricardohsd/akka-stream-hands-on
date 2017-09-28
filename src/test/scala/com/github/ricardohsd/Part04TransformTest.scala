package com.github.ricardohsd

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import akka.stream.testkit.scaladsl.TestSink
import org.scalatest.{FunSuite, Matchers}

class Part04TransformTest extends FunSuite with Matchers {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  val stream = new Part04Transform()

  test("capitalizeNames") {
    Source(Users.all)
      .via(stream.capitalizeNames)
      .runWith(TestSink.probe[User])
      .requestNext(User("BRUCE"))
      .requestNext(User("CLARK"))
      .requestNext(User("DIANA"))
      .requestNext(User("DENISE"))
      .expectComplete()
  }

  test("filterNames") {
    Source(Users.all)
      .via(stream.filterNames)
      .runWith(TestSink.probe[User])
      .requestNext(User("diana"))
      .requestNext(User("denise"))
      .expectComplete()
  }
}
