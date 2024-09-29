package recursive

/**
 * 멱집합을 구하는 함수
 * 어떤 집합의 모든 부분 집합의 집합을 구하는 함수
 */
class PoserSet {
    fun <T> Set<T>.head() = first();
    fun <T> Set<T>.tail() = drop(1).toSet();

    fun <T> powerset(s: Set<T>): Set<Set<T>> = when {
        s.isEmpty() -> setOf(setOf())
        else -> {
            val head = s.head()
            val restSet = powerset(s.tail())
            restSet + restSet.map { setOf(head) + it }.toSet()
        }
    }

    tailrec fun <T> tailPowerSet(s: Set<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
        s.isEmpty() -> setOf(setOf())
        else -> tailPowerSet(s.tail(), acc + acc.map { it + s.head() })
    }
}