package recursive

/**
 * 코틀린은 순수 함수형 언어는 아니지만 sequence 를 활용해 무한한 자료구조를 만들 수 있다.
 */
class SequenceEx {

    fun List<Int>.head() = first();
    fun List<Int>.tail() = drop(1);

    fun repeat(n: Int): Sequence<Int> = generateSequence(n) {
        it
    }


    /**
     * 두 개의 리스트를 입력으로 받아 하나의 리스트로 조합하는 함수
     * [1,3,5] , [2,4] 를 입력받으면 [(1,2), (3,4)] 를 반환 ( 두 개의 리스트중 길이가 짧은쪽을 기준으로 반환 )
     */

    fun zip(list1: List<Int>, list2: List<Int>): List<Pair<Int, Int>> = when {
        list1.isEmpty() || list2.isEmpty() -> listOf()
        else -> listOf(Pair(list1.head(), list2.head())) + zip(list1.tail(), list2.tail())
    }

    //꼬리재귀로 refactoring
    tailrec fun tailZip(list1: List<Int>, list2: List<Int>, acc: List<Pair<Int, Int>>): List<Pair<Int, Int>> = when {
        list1.isEmpty() || list2.isEmpty() -> listOf()
        else -> {
            val accList = acc + listOf(Pair(list1.head(), list2.head()))
            tailZip(list1.tail(), list2.tail(), accList)
        }
    }

}