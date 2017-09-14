package com.github.ricardohsd

import akka.NotUsed
import akka.stream.scaladsl.Source

case class CustomException(message: String) extends RuntimeException(message)

class Part01 {
  // TODO Return an empty source
  def emptySource(): Source[Nothing, NotUsed] = {
    Source.empty
  }

  // TODO Return a Source that contains "foo" and "bar"
  def fromValues(): Source[String, NotUsed] = {
    Source(List("foo", "bar"))
  }

  // TODO Return a Source that contains a "foo" value. Do not use a List/Collection.
  def fooSource(): Source[String, NotUsed] = {
    Source.single("foo")
  }

  // TODO Return a Source that emits an IllegalStateException
  def errorSource(): Source[Nothing, NotUsed] = {
    Source.failed(CustomException("Failed source"))
  }

  // TODO Create a Source that emit increase value from 0 to 9
  def counter(): Source[Int, NotUsed] = {
    Source(Stream.from(0)).take(10)
  }
}
