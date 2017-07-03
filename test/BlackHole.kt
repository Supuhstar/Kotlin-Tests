/**
 * @author Kyli Rouge
 * @since 2017-07-03 003.
 */
object BlackHole {
    val consumer: MutableSet<Any?> = mutableSetOf()
    fun consume(item: Any?) {
        consumer.add(item)
    }
}