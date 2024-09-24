package firstClass.kotlin

import java.lang.Integer.parseInt

class Basic {

    val list: List<Int> = listOf(1,2,3,4);

    fun test(x: Int) {
        when (x) {
            1 -> print("x == 1")
            2, 3 -> print("x == 2 or 3")
            parseInt("4") -> print("x = 4")
            else -> print("else number")
        }

//        list.add(1) 컴파일 오류 발생 List 는 불변 구조이기 때문에
        val newList = list.plus(1); //기존 배열에 추가된 값이 있는 새로운 배열을 반환한다.
    }

    fun sum(numbers: List<Int>): Int = when {
        numbers.isEmpty() -> 0
        else -> numbers.first() + sum(numbers.drop(1))
    }
}