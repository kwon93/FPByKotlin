package firstClass.fp

/**
 * OOP 와 달리 인터페이스와 구현클래스 없이 추상화가 이뤄짐.
 * 입출력 타입만 동일하다면 별도의 클래스 추가 없이 계산 기능을 덧붙일 수 있다.
 */
class FpCalculator {
    fun calculate(calculator: (Int, Int) -> Int, num1: Int, num2: Int): Int = calculator(num1, num2);
}