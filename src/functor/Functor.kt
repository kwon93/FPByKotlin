package functor

interface Functor<out A> {
    //입력받은 f 함수를 사용해 A를 B값으로 변환한 후 펑터에 담아 Functor<B> 를 반환한다.
    fun <B> fmap(f: (A) -> B): Functor<B>
}