package recursive

class Recursion {

    /**
     * 재귀가 무한 루프에 빠지지 않으려면 재귀에서 빠져나오는 종료조건 (edge condition) 을 적어도 한 개 이상은 줘야한다.
     * 재귀는 반복할수록 종료 조건에 가까워져야 한다.
     * 1. 종료조건 정의
     * 2. 함수의 입력을 분할하여 어떤 부분에서 재귀 호출을 할건지 결정
     * 3. 함수의 입력값이 종료조건에 수렴하도록 재귀 호출을 입력값을 결정
     *
     * 종료 조건은 일반적으로 항등값이다. ( 0이나 1처럼 원본값에 곱하거나 더해도 동일한 값 )
     */
    fun helloFunc(n: Int) {
        when {
            n < 0 -> return
            else -> {
                println("hello");
                helloFunc(n - 1);
            }
        }
    }

    fun func(n: Int): Int = when {
        n < 0 -> 0
        else -> n + func(n - 1)
    }

    fun List<Int>.head() = first();
    fun List<Int>.tail() = drop(1);


    // [ 1, 3, 2, 8, 4 ]
    fun maximum(items: List<Int>): Int = when {
        items.isEmpty() -> error("empty List!")
        1 == items.size -> items[0]
        else -> {
            val head = items.head()
            val tail = items.tail()
            val maxVal = maximum(tail)
            if (head > maxVal) head else maxVal
        }
    }

    fun String.head() = first();
    fun String.tail() = drop(1);

    /**
     * ABCD -> DCBA
     * 1. reverse(BCD) + A
     * 2. reverse(CD) + B
     * 3. reverse(D) + C
     * 4. reverse("") + D  *drop(1) 시에 1개있으면 빈문자 반환 {edge-condition}
     * 역순으로 결과 조합 ( stack에 함수가 쌓이기 떄문에 )
     * 1. reverse("") + D = D
     * 2. D + C = DC
     * 3. DC + B = DCB
     * 4. DCB + A = DCBA
     */
    fun reverse(str: String): String = when {
        str.isEmpty() -> ""
        else -> reverse(str.tail()) + str.head();
    }


    /**
     * 10 진수 숫자를 입력받아서 2진수 문자열로 변환하는 함수
     *
     */
    fun tobinary(n: Int): String = when {
        n == 0 -> "0"
        n == 1 -> "1"
        else -> tobinary(n / 2) + (n / 2).toString()
    }


    /**
     * 리스트에서 입력받은 숫자만큼만 가져오는 함수
     * take(3 , [1,2,3,4,5]); -> [1,2,3]
     * 1. [1] + take(2, [2,3,4,5]);
     * 2. [1,2] + take(1,[3,4,5]);
     * 3. [1,2,3] + take(0, [4,5]);
     * 4. []
     */
    fun take(n: Int, list: List<Int>): List<Int> = when {
        n <= 0 -> listOf()
        list.isEmpty() -> listOf()
        else -> listOf(list.head()) + take(n - 1, list.tail())
    }

    /**
     * 입력값 n 이 리스트에 존재하는지 확인하는 함수를 재귀로 작성해보기
     *
     * tail 이 값을 종료조건에 가까워지도록 축약해주는 조건이 된다.
     */
    fun elem(num: Int, list: List<Int>): Boolean = when {
        list.isEmpty() -> false
        list.head() == num -> true
        else -> elem(num, list.tail())
    }
}
