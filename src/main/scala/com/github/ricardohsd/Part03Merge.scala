package com.github.ricardohsd

import akka.NotUsed
import akka.stream.scaladsl.{Concat, Merge, Source}

class Part03Merge {
  // TODO Create a Source with "foo" and "bar", merge it with Sourcec "baz" and return a Source
  def mergeSources(): Source[String, NotUsed] = {
    ???
  }

  // TODO Create a Source with "foo" and "bar", concat it with Source "baz" and return a Source
  def concatSources(): Source[String, NotUsed] = {
    ???
  }
}
