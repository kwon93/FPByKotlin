package currying

import kotlin.math.max

/**
 * Currying 이란 여러개의 매개변수를 받는 함수를 분리하여, 단일 매개변수를 받는 부분 적용 함수의 체인으로 만드는 기법
 * 커링의 장점
 * 1. 다양하게 함수의 재사용이 가능하다.
 * 2. 마지막 매개변수가 입력될때까지 함수의 실행을 늦출 수 있다.
 */
class Currying {

    //3개의 매개변수를 받는 함수
    fun multiThree(a: Int, b: Int, c: Int): Int = a * b + c;

    //부분적용 함수를 반환하는 multiThree 함수
    fun multiThree(a: Int) = { b: Int -> { c: Int -> a * b * c } }

    //두 매개변수를 받아서 큰값을 반환하는 함수
    fun greatest(a: Int) = { b: Int -> max(a, b) }

    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R =
        { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } };

}