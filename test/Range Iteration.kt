
import org.bh.tools.base.util.*
import org.bh.tools.base.util.TimeTrialMeasurementMode.*
import org.junit.Test
import java.util.*


val rangeSize = 10_000_000
val trialsPerTest = 50L
val measurementMode = TimeTrialMeasurementMode.total


class RangeIterationTests {

    @Test
    fun main() {
        BlackHole.consume("nothing; Ready to consume more")

        println("\nFinding the $measurementMode of $trialsPerTest trials of iterations over ranges of 1..$rangeSize:")

        val forEachLoopDuration = measureTimeInterval(trials = trialsPerTest, mode = measurementMode) {
            rangeForEachLoop()
        }

        println("\tloop:           $forEachLoopDuration seconds")

        val forEachMethodDuration = measureTimeInterval(trials = trialsPerTest, mode = measurementMode) {
            rangeForEachMethod()
        }

        println("\tmethod:         $forEachMethodDuration seconds")

        val forEachLoopWithStep1Duration = measureTimeInterval(trials = trialsPerTest, mode = measurementMode) {
            rangeForEachLoopWithStep1()
        }

        println("\tloop with step: $forEachLoopWithStep1Duration seconds")
    }


    fun rangeForEachLoop() {
        for (it in 1..rangeSize) {
            BlackHole.consume(it)
        }
    }

    fun rangeForEachMethod() {
        (1..rangeSize).forEach {
            BlackHole.consume(it)
        }
    }

    fun rangeForEachLoopWithStep1() {
        for (it in 1..rangeSize step 1) {
            BlackHole.consume(it)
        }
    }
}
