package higherorderfunction

/**
 * 부분 함수란 모든 가능한 입력 중 , 일부 입력에대한 결과만 정의한 함수
 */
class PartiallyFunction {

    //입력값을 두배로 만드는 함수
    val twice: (x: Int) -> Int = { it * 2 }

    //partialTwice 는 twice 함수의 부분집합 ( 부분 함수 )
    fun partialTwice(x: Int): Int = when {
        x < 100 -> x * 2
        else -> throw IllegalArgumentException()
    }

    fun sayNumber(x: Int): String = when {
        x == 1 || x == 2 || x == 3 -> x.toString()
        else -> throw IllegalArgumentException("범위 내 입력이 아닌데용");
    }


}