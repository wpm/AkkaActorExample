Scala Actor Examples with Unit Tests
====================================

This project contains examples of how to create and unit test [Akka](http://akka.io) actors.
It consists of two simple actors:

1. A `Calculator` which does simple stateless arithmetic.
2. An `Accumulator` which accumulates values passed to it in a mutable set.

The `CalculatorSpec` unit tests show how to test actors.
The `Calculator` companion object also contains a `main` function that is an example of how to use for-comprehension on futures.

The `AccumulatorSpec` unit tests show how to write unit tests which access an actor's internals.
