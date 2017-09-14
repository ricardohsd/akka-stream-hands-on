package com.github.ricardohsd

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import akka.stream.testkit.scaladsl.TestSink

class Part02 {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  // TODO use testkit to check it emits "foo" and "bar" values then completes
  def expectFooBar(source: Source[String, NotUsed]) = {
    ???
  }

  // TODO use testkit to check it emits an exception
  def expectException(source: Source[String, NotUsed]) = {
    ???
  }
}
