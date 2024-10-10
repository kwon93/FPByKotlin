package functor

/**
 * Functor 란 ?
 * Mapping 할 수 있는 것 이라는 행위를 선언한 타입 클래스
 *
 * List 같은 컨테이너형 타입의 값을 꺼내서 입력받은 함수를 적용한 후,
 * 함수의 결과값을 컨테이너형 타입에 넣어서 반환하는 행위를 선언한 타입 클래스를 의미
 *
 * Functor 자체는 추상화된 타입클래스이기 때문에 구체적인 타입까지 정의하지않는다.
 * ( List<Int> X / List<T> O )
 *
 * Functor 의 법칙
 * 1. 항등 함수의 Functor 를 통해서 mapping 하면 반환되는 Functor 의 원래의 Functor 와 같다.
 * 2. 두 함수를 합성한 함수의 mapping 은 각 함수를 mapping 한 결과를 합성한 것과 같다.
 *
 */

class FunctorIs {

    /**
     * Functor 제 1법칙
     * fmap(identify()) == identify()
     * fmap 을 호출할 때 항등함수 id 를 입력으로 넣은 결과는 반드시 항등 함수를 호출한 결과와 동일해야한다.
     */
    fun <T> identify(x: T): T = x

    /**
     * Functor 제 2 법칙
     * fmap(f compose g) == fmap(f) compose fmap(g)
     * 함수 f 와 g 를 먼저 합성하고 fmap 합수의 입력으로 넣어 얻은 결과값은
     * 함수 f를 fmap에 넣어서 얻은 함수와 g를 fmap에 넣어서 얻은 함수를 합성한 결과와 같아야한다.
     */
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }
}
