import firstClass.SimpleCalculator
import firstClass.fp.FpCalculator
import firstClass.oop.Minus
import firstClass.oop.OopCalculator
import firstClass.oop.Plus
import lazy.Lazy
import recursive.Fibo
import javax.swing.UIDefaults.LazyValue

fun main() {
    val fibo = Fibo();

    val a = fibo.fiboRecursion(3);
    println(a);

}