package io.wausoft.core

/*
 * The premise of this is simple; it allows you to chain subroutines without using a block
 * The idea comes from Haskell's Monads, where by language design you can't normally 
 * predict the order of statement execution due to the language being lazy, 
 * so instead an operator was added that allowed you to call statements sequencially
 *
 * Rather than writing something like this:
 * def printStuff(): Unit = {
 *   println("blah")
 *   println("bloo")
 * }
 *
 * You can write
 * def printStuff(): Unit = println("blah") then println("bloo")
 * or 
 * val x = y.init() then y.getName() // thanks to Lectori Salutem for this idea
 *
 * This saves an otherwise unnecessary code block, for an amount of code this small.
 */
 
object Then {
  implicit class RichAny(val left: Any) extends AnyVal {
    def then[A](right: => A): A = right
  }
}
