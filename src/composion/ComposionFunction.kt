package composion

import java.util.Collections.max

/**
 * 합성 함수란 함수를 매개변수로 받고 ,
 * 함수를 반환할 수 있는 고차 함수를 이용해서 두 개의 함수를 결합하는것
 */
class ComposionFunction {

    fun composed(a: Int) = addThree(twice(a));
    fun addThree(a: Int) = a + 3;
    fun twice(a: Int) = a * 2;


    // infix keyword 를 사용해 compose 를 일반화 하여 합성 함수를 사용하자
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { ginput: G -> this(g(ginput)) }
    }

    val addThree2 = { i: Int -> i + 3 };
    val twice2 = { i: Int -> i * 2 };
    val composedFunc = addThree2 compose twice2;

    //숫자 리스트를 받아서 최대값의 제곱을 구하는 함수 ( max 와 power 를 합성해야함 )
    val max = { list: List<Int> -> list.maxOrNull() ?: 0 }
    val power = { i: Int -> i * i }
    val maxPower = power compose max

    tailrec fun gcd(m: Int, n: Int): Int = when (n) {
        0 -> m
        else -> gcd(n, m % n)
    }

    tailrec fun recursionPower(x: Double, n: Int, acc: Double = 1.0): Double = when (n) {
        0 -> acc
        else -> recursionPower(x, n - 1, x * acc)
    }

    /**
     * 한개의 함수와 두 개의 리스트를 받아 두 개의 리스트 값을 입력받은 함수에 적용하고 합쳐진 리스트를 반환 하는 함수
     */
    fun <T> List<T>.head() = first();
    fun <T> List<T>.tail() = drop(1);

    tailrec fun <P1, P2, R> zipWith(
        func: (P1, P2) -> R,
        list1: List<P1>,
        list2: List<P2>,
        acc: List<R> = listOf()
    ): List<R> = when {
        list1.isEmpty() || list2.isEmpty() -> acc
        else -> {
            val zipList = acc + listOf(func(list1.head(), list2.head()))
            zipWith(func, list1.tail(), list2.tail(), zipList)
        }
    }

    // 코드를 작성할 때 자주 사용되는 패턴을 추상화하기 위해서 고차 함수를 사용한다.


}