package typesystem


/**
 * 함수형 언어에서는 객체뿐아니라 표현식도 타입을 가진다.
 *
 * 대수적 타입: 다른 타입들을 모아서 형성되는 합성 타입 -> 기존 타입들을 결합하여 새로운 타입을 정의
 */
class TypeSystem {


    /**
     * 곱타입 (AND) open class
     * String 과 Float 타입을 AND 로 결합
     * 컴파일단계에서 어떤것이 더 상속될지 모르기때문에 패턴 매칭시 예외 처리가 필수
     * 함수에 부수적인 효과가 생긴다.
     */
//    open class Shape(name: String, x: Float, y: Float)
//    class Circle(val name: String, val x: Float, val y: Float, val radius: Float) : Shape(name, x, y)
//    class Square(val name: String, val x: Float, val y: Float, val length: Float) : Shape(name, x, y)

    /**
     * 합타입 (OR) sealed class
     * 컴파일단계에서 상속되는 타입들이 정해져있기에 패턴 매칭시 안전하게 코드 작성 가능
     * 함수에 부수적인 효과가 없고 참조 투명한 함수를 설계 할 수 있다.
     *
     * - 더 쉽게 타입을 결합하고 확장 할 수 있음
     * - 생성자 패턴 매칭을 통해 간결한 코드 작성이 가능
     * - 철저한 타입 체크로 더 안전한 코드를 작성 할 수 있음
     */
    sealed class Shape
    data class Circle(var name: String, val x: Float, val y: Float, val radius: Float) : Shape();
    data class Square(val name: String, val x: Float, val y: Float, val length: Float) : Shape();


}