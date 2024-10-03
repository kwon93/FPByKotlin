package collection

import collection.FunList.Nil.reverse

/**
 * 함수형 콜렉션은 원본 데이터를 변경하지 않고 가공된 데이터를 매번 새로 생성하여 반환하는 특징
 * 이 때 생성비용을 최소화하지 않으면 비효율적인 연산이 되기에 항상 생성 비용을 최소화 해야한다.
 * 이를 위해 Lazy Evaluation 과 Caching 을 사용한다.
 */
sealed class FunList<out T> {
    object Nil : FunList<Nothing>();
    data class Cons<out T>(val head: T, val tail: FunList<T>) : FunList<T>();

    val list: FunList<Int> = Cons(1, Cons(2, Nil));

    // 불변성을 유지하면서 생성 비용을 최소화
    fun <T> FunList<T>.addHead(head: T): FunList<T> = FunList.Cons(head, this);

    // List의 마지막 값이 될 때까지 재귀
    fun <T> FunList<T>.appendTail(value: T, acc: FunList<T> = Nil): FunList<T> = when (this) {
        FunList.Nil -> Cons(value, acc).reverse();
        is FunList.Cons -> tail.appendTail(value, acc.addHead(head))
    }

    tailrec fun <T> FunList<T>.reverse(acc: FunList<T> = FunList.Nil): FunList<T> = when (this) {
        FunList.Nil -> acc
        is FunList.Cons -> tail.reverse(acc.addHead(head))
    }

    fun <T> FunList<T>.getTail(): FunList<T> = when (this) {
        FunList.Nil -> throw NoSuchElementException()
        is FunList.Cons -> tail
    }

    fun <T> FunList<T>.getHead(): T = when (this) {
        FunList.Nil -> throw NoSuchElementException()
        is FunList.Cons -> head
    }

    /**
     * 함수형 프로그래밍으로 데이터를 걸러낼 때의 장점
     * 1. 코드가 간결해져서 가독성이 좋다
     * 2. 결과값을 저장하기 위해서 별도의 리스트를 생성할 필요가 없다.
     * 3. 비지니스 로직에 집중할 수 있다.
     * 4. 버그가 발생할 확률이 적다.
     * 5. 테스트가 용이하다.
     * 6. 유지보수가 용이하다.
     */
    tailrec fun <T> FunList<T>.filter(acc: FunList<T> = FunList.Nil, p: (T) -> Boolean): FunList<T> = when (this) {
        FunList.Nil -> acc.reverse()
        is FunList.Cons -> if (p(head)) {
            tail.filter(acc.addHead(head), p)
        } else {
            tail.filter(acc, p)
        }
    }

    tailrec fun <T, R> FunList<T>.map(acc: FunList<R> = FunList.Nil, f: (T) -> R): FunList<R> = when (this) {
        FunList.Nil -> acc.reverse();
        is FunList.Cons -> tail.map(acc.addHead(f(head)), f);
    }

    tailrec fun <T, R> FunList<T>.foldLeft(acc: R, f: (R, T) -> R): R = when (this) {
        FunList.Nil -> acc
        is FunList.Cons -> tail.foldLeft(f(acc, head), f);
    }

    fun <T, R> FunList<T>.mapByFoldLeft(f: (T) -> R): FunList<R> = this.foldLeft(FunList.Nil) { acc: FunList<R>, x ->
        acc.appendTail(f(x))
    }

    // foldRight 은 꼬리 재귀가 아니다, 또한 acc를 구하기 위한 f함수를 나중에 평가한다.
    fun <T, R> FunList<T>.foldRight(acc: R, f: (T, R) -> R): R = when (this) {
        FunList.Nil -> acc
        is FunList.Cons -> f(head, tail.foldRight(acc, f))
    }


}