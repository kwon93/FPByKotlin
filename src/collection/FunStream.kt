package collection

/**
 * 성능향상을 위해
 * 게으른 평가가 가능한 funStream
 */
sealed class FunStream<out T> {
    object Nil : FunStream<Nothing>();
    //매개변수를 람다로 받아 생성 시점에서 평가되지않는다. 실제로 그 값이 필요할 때 평가되어 lazy evaluation 이 가능해진다.
    data class Cons<out T>(val head: () -> T, val tail: () -> FunStream<T>) : FunStream<T>();

    fun <T> FunStream<T>.getHead(): T = when (this) {
        FunStream.Nil -> throw NoSuchElementException()
        is FunStream.Cons -> head()
    }

    fun <T> FunStream<T>.getTail(): FunStream<T> = when (this) {
        FunStream.Nil -> throw NoSuchElementException()
        is FunStream.Cons -> tail()
    }

    //FunStream 으로 무한대값 만들기
    fun <T> generateFunStream(seed: T, generate: (T) -> T): FunStream<T> =
        FunStream.Cons({ seed }, { generateFunStream(generate(seed), generate) });

}