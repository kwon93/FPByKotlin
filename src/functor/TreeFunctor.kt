package functor

/**
 * Tree 는 비어있거나 어떤 값과 두 개의 자식 트리를 가진다.
 * 새로운 트리를 만들 수 있다.  ( TreeOf )
 * 트리를 화면에 출력할 수 있다. ( toString)
 * 트리의 모든 노드의 값을 변환 함수에 적용한 트리를 만들 수 있다 ( fmap )
 *
 */
sealed class TreeFunctor<out A> : Functor<A> {

    abstract override fun toString(): String

    abstract override fun <B> fmap(f: (A) -> B): TreeFunctor<B>

    object EmptyTree : TreeFunctor<kotlin.Nothing>() {
        override fun toString(): String = "EmptyTree"
        override fun <B> fmap(f: (Nothing) -> B): TreeFunctor<B> = EmptyTree
    }

    data class Node<out A>(val value: A, val leftTree: TreeFunctor<A>, val rightTree: TreeFunctor<A>) :
        TreeFunctor<A>() {
        override fun toString(): String {
            return "(N $value $leftTree $rightTree)"
        }

        override fun <B> fmap(f: (A) -> B): TreeFunctor<B> {
            return Node(f(value), leftTree.fmap(f), rightTree.fmap(f));
        }
    }

    fun <T> treeOf(
        value: T,
        leftTree: TreeFunctor<T> = EmptyTree,
        rightTree: TreeFunctor<T> = EmptyTree
    ): TreeFunctor<T> =
        Node(value, leftTree, rightTree);

    /**
     *          1
     *      2       5
     *   3    4   6    7
     * val tree = treeOf(1,
     *                  treeOf(2,
     *                          treeOf(3), treeOf(4)),
     *                  treeOf(5,
     *                          treeOf(6), treeOf(7)));
     */
}
