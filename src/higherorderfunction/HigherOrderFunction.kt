package higherorderfunction

/**
 * 고차 함수
 * 함수를 매개변수로 받는 함수
 * 함수를 반환하는 함수
 */
class HigherOrderFunction {

    //함수를 매개변수로 받거나
    fun higherOrderFunction1(func: () -> Unit): Unit {
        func()
    }

    //함수를 반환하거나
    fun higherOrderFunction2(): () -> Unit {
        return { println("hello World") }
    }

    fun higherOrder(func: (Int, Int) -> Int, x: Int, y: Int): Int = func(x, y)

    val twiceSum: (Int, Int) -> Int = { x, y -> (x + y) * 2 }

    /**
     * list 의 값들을 두 배로 하고 10보다 큰 수만을 걸러내기
     */
//    val ints = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
//    val result = ints.map { x -> x * x }
//                    .filter { x -> x > 10 };


    //Kotiln 에서는 value -> value처럼 매개 변수로 받는 값이 하나인 경우 it로 생략이 가능
    val ints = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    val result = ints.map { it * 2 }
        .filter { it > 10 };


}