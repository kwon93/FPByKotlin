package functor

import collection.FunList

/**
 * Maybe 는 어떤값이 있을수도 없수도있는 컨테이너형 타입
 * 자바의 옵셔널과 같다.
 */
sealed class Maybe<out A> : Functor<A> {

    abstract override fun toString(): String

    abstract override fun <B> fmap(f: (A) -> B): Maybe<B>
}