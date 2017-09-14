package com.github.ricardohsd

import akka.NotUsed
import akka.stream.scaladsl.{Concat, Merge, Source}

class Part03Merge {
  // TODO Merge "foo" and "bar" with "baz" and return a Source
  def mergeSources(): Source[String, NotUsed] = {
    Source.combine(Source(List("foo", "bar")), Source.single("baz"))(Merge(_))
  }

  // TODO Concat "foo" and "bar" with "baz" and return a Source
  def concatSources(): Source[String, NotUsed] = {
    Source.combine(Source(List("foo", "bar")), Source.single("baz"))(Concat(_))
  }
}
