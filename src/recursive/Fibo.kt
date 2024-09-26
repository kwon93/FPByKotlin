package recursive

/**
 * recursion의 문제점
 * 1. 동적 계획법에 비해 성능이 느리다.
 * 2. 스택 오버 플로우가 발생할 수 있다. 스택에 함수를 계속 담기때문에
 */
class Fibo {

    fun fiboRecursion(n: Int): Int = when (n) {
        0 -> 0
        1 -> 1
        else -> fiboRecursion(n - 1) + fiboRecursion(n - 2);
    }
}