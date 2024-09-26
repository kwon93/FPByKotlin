package firstClass.kotlin

/**
 * 변성
 * Box[S] 와 Box[T] 는 상속관계가 없다. -> 무공변
 * Box[S] 가 Box[T] 의 하위타입이다. -> 공변
 * Box[T] 가 Box[S] 의 하위타입이다. -> 반공변
 */
interface Box<T>
open class Language
open class JVM : Language()
class Kotlin : JVM()

val languageBox = object : Box<Language> {}
val jvmBox = object : Box<JVM> {}
val kotlinBox = object : Box<Kotlin> {}




class Variance {
}