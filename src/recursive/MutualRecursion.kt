package recursive

import firstClass.kotlin.Box

/**
 * 함수 A가 함수 B를 호출하고 함수 B가 함수 A를 호출하는것.
 *
 */
class MutualRecursion {

    fun even(n: Int): Boolean = when (n) {
        0 -> true
        else -> odd(n - 1)
    }

    fun odd(n: Int): Boolean = when (n) {
        0 -> false
        else -> even(n - 1)
    }
}