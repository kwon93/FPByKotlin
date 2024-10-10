package functor

/**
 * 매개변수가 두개 혹은 그 이상인 타입의 Functor
 * left 또는 right 타입만 허용하는 대수적 타입
 * 함수 호출이 성공하면 right에 담고 실패하면 실패한 이유에 대한 정보를 left에 표시
 *
 * left 또는 right 고 모두 컨테이너형 타입으로 값을 표현
 * left 와 right 가 포함하는 값의 타입은 다를 수 있다.
 * Either 의 right 값을 변경하고 변경된 값을 가진 Either 를 얻을 수 있다. ( fmap )
 */
sealed class Either<out L, out R> : Functor<R> {

    // f함수는 R에만 적용되고 L은 변경되지 않는다.
    abstract override fun <R2> fmap(f: (R) -> R2): Either<L, R2>

    data class Left<out L>(val value: L) : Either<L, Nothing>() {
        override fun <R2> fmap(f: (Nothing) -> R2): Either<L, R2> = this
    }

    data class Right<out R>(val value: R) : Either<Nothing, R>() {
        override fun <R2> fmap(f: (R) -> R2): Either<Nothing, R2> = Right(f(value))
    }

    fun divideTenByN(n: Int): Either<String, Int> = try {
        Right(10 / n)
    } catch (e: ArithmeticException) {
        Left("divide by zero")
    }

}