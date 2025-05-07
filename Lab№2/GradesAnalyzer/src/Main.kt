class InvalidGradeException(message: String) : Exception(message)

fun main() {
    print("Введіть кількість студентів: ")
    val n = readln().toInt()
    val names = Array<String?>(n) { null }
    val grades = IntArray(n)

    for (i in 0 until n) {
        print("Введіть ім'я студента №${i + 1} (може бути пустим): ")
        val inputName = readlnOrNull()
        names[i] = inputName ?: "Unknown"

        print("Введіть оцінку студента №${i + 1} (0-100): ")
        try {
            val grade = readln().toInt()
            if (grade !in 0..100) throw InvalidGradeException("Оцінка $grade недійсна!")
            grades[i] = grade
        } catch (e: InvalidGradeException) {
            println("Помилка: ${e.message}. Встановлено оцінку 0.")
            grades[i] = 0
        } catch (e: Exception) {
            println("Помилка вводу. Встановлено оцінку 0.")
            grades[i] = 0
        }
    }

    println("\n--- Результати ---")
    for (i in 0 until n) {
        val name = names[i] ?: "Unknown"
        println("Студент: ${if (name.isNotBlank()) name else "Unknown"}, Оцінка: ${grades[i]}")
    }

    val avg = grades.average()
    val max = grades.maxOrNull() ?: 0
    val min = grades.minOrNull() ?: 0
    val topStudents = names.zip(grades.toList()).filter { it.second >= 90 }


    println("\nСередня оцінка: $avg")
    println("Найвища оцінка: $max")
    println("Найнижча оцінка: $min")
    println("Відмінники:")
    for ((name, grade) in topStudents) {
        println("- ${name ?: "Unknown"} ($grade)")
    }

    val comment = when {
        avg >= 90 -> "Високий рівень"
        avg in 70.0..89.9 -> "Середній рівень"
        else -> "Низький рівень"
    }

    println("Коментар: $comment")
}