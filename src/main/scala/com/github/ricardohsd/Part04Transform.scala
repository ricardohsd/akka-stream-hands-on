package com.github.ricardohsd

case class User(name: String)

object Users {
  private val bruce = User("bruce")
  private val clark = User("clark")
  private val diana = User("diana")
  private val denise = User("denise")

  def all: List[User] = {
    List(bruce, clark, diana, denise)
  }
}

class Part04Transform {
  // TODO Capitalize the user's name. Check Flow api
  def capitalizeNames = ???

  // TODO Filter only users with name that starts with 'd'. Check Flow api
  def filterNames = ???
}
