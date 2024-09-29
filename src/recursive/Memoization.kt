package recursive

/**
 * Memoization 이란
 * 어떤 반복된 연산을 수행할 때 이전에 계산했던 값을 캐싱해서 중복된 연산을 제거해나가는 방식
 */
class Memoization {

    var memo = Array(100) { -1 }

    //외부 요소인 memo의 상태를 변경하기해 순수함수라 볼 수 없다.
    fun fiboMemoization(n: Int): Int = when {
        n == 0 -> 0
        n == 1 -> 1
        memo[n] != -1 -> memo[n]
        else -> {
            memo[n] = fiboMemoization(n - 2) + fiboMemoization(n - 1)
            memo[n]
        }
    }

    fun fiboFp(n: Int): Int = fiboFp(n, 0, 1);

    /**
     * 꼬리 재귀란?
     * 어떤 함수가 직간접적으로 자기 자신을 호출하면서도 그 호출이 마지막 연산인 경우를 말한다.
     * 마지막 호출에서 재귀 함수만 호출되어야 한다 ( ex. n + fiboFp(n -1 , second, first + second ) 와 같은 함수는 꼬리 재귀라 볼 수 없다 )
     */
    tailrec fun fiboFp(n: Int, first: Int, second: Int): Int = when (n) {
        0 -> first
        1 -> second
        else -> fiboFp(n - 1, second, first + second)
    }

}