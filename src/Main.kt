import firstClass.SimpleCalculator
import firstClass.fp.FpCalculator
import firstClass.oop.Minus
import firstClass.oop.OopCalculator
import firstClass.oop.Plus
import lazy.Lazy
import javax.swing.UIDefaults.LazyValue

fun main() {
    println("---- OOP ----");
    val plusCalculator = OopCalculator(Plus());
    println(plusCalculator.calculate(1,2));
    val minusCalculator = OopCalculator(Minus());
    println(minusCalculator.calculate(3,2));



    println("---- FP ----");
    val fpCalculator = FpCalculator()
    println(fpCalculator.calculate({n1,n2 -> n1 + n2}, 2 ,3));
    println(fpCalculator.calculate({n1,n2 -> n1 - n2}, 10 ,3));

    val lazy = Lazy()

    println(lazy.lazyValue);
    println(lazy.lazyValue);

    val infiniteValue = generateSequence(0) { it + 5  }
    infiniteValue.take(5).forEach { println("$it") }


}