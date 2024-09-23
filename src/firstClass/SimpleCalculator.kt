package firstClass

class SimpleCalculator {
    fun calculate(operator:Char, num1: Int, num2: Int): Int = when (operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        else -> throw IllegalArgumentException();
    }

}