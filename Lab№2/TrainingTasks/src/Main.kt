fun main() {
    while (true) {
        println("\n=== МЕНЮ ===")
        println("1. Перевірити, чи число парне")
        println("9. Вивести таблицю множення")
        println("16. Зчитати n чисел і вивести у зворотному порядку")
        println("22. Привітання з іменем (Null safety)")
        println("26. Ділення на нуль (try-catch)")
        println("0. Вихід")
        print("Оберіть пункт меню: ")

        when (readLine()?.toIntOrNull()) {
            1 -> checkEven()
            9 -> showMultiplicationTable()
            16 -> reverseArrayInput()
            22 -> greetUser()
            26 -> safeDivide()
            0 -> {
                println("Завершення програми.")
                return
            }
            else -> println("Невірний вибір!")
        }
    }
}

// 1. Перевірити, чи число парне
fun checkEven() {
    print("Введіть число: ")
    val number = readLine()?.toIntOrNull()
    if (number == null) {
        println("Некоректне число!")
    } else {
        val result = if (number % 2 == 0) "парне" else "непарне"
        println("Число $number є $result.")
    }
}

// 9. Таблиця множення
fun showMultiplicationTable() {
    print("Введіть число: ")
    val number = readLine()?.toIntOrNull()
    if (number == null) {
        println("Некоректне число!")
    } else {
        for (i in 1..10) {
            println("$number × $i = ${number * i}")
        }
    }
}

// 16. Зчитати n чисел і вивести у зворотному порядку
fun reverseArrayInput() {
    print("Введіть кількість чисел: ")
    val n = readLine()?.toIntOrNull() ?: return println("Некоректне число!")

    val list = mutableListOf<Int>()
    for (i in 1..n) {
        print("Число №$i: ")
        val value = readLine()?.toIntOrNull() ?: 0
        list.add(value)
    }

    println("У зворотному порядку:")
    for (i in list.reversed()) {
        print("$i ")
    }
    println()
}

// 22. Null safety — привітання з іменем
fun greetUser() {
    print("Введіть ім’я (може бути порожнім): ")
    val name = readLine()
    val displayName = if (name.isNullOrBlank()) "Anonymous" else name
    println("Привіт, $displayName!")
}

// 26. Обробка ділення на нуль
fun safeDivide() {
    print("Введіть чисельник: ")
    val a = readLine()?.toIntOrNull() ?: return println("Некоректне число!")

    print("Введіть знаменник: ")
    val b = readLine()?.toIntOrNull() ?: return println("Некоректне число!")

    try {
        val result = a / b
        println("Результат: $result")
    } catch (e: ArithmeticException) {
        println("Помилка: ділення на нуль")
    }
}