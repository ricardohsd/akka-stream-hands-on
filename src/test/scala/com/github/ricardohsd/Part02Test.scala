package com.github.ricardohsd

import akka.stream.scaladsl.{Concat, Merge, Source}
import org.scalatest.{FunSuite, Matchers}

class Part02Test extends FunSuite with Matchers {
  val stream = new Part02()

  test("expectFooBar") {
    stream.expectFooBar(Source(List("foo", "bar")))
  }

  test("expectException") {
    stream.expectException(
      Source.failed(CustomException("Failed"))
    )
  }
}
