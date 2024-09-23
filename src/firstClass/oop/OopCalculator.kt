package firstClass.oop

class OopCalculator(private val calculator: Calculator) {
    fun calculate(num1: Int, num2: Int): Int = calculator.calculate(num1, num2);
}