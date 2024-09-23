package lazy

class Lazy {
    val lazyValue: String by lazy {
        println("시간이 오래 걸리는 작업");
        "hello"
    }

}