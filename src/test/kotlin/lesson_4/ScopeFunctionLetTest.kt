package lesson_4

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScopeFunctionLetTest {

  /**
   * let чаще всего используется для выполнения блока кода для не-null объектов и
   * для введения нового локального имени переменной.
   * Контекстный объект: it (можно переименовать)
   * Возвращаемое значение: Результат лямбда-выражения (последняя строка блока).
   */
  @Test
  @DisplayName("Функция let")
  fun `scope function let`() {
    val user = User(
      id = 1L,
      password = "test",
      username = "petya",
      email = null
    )

    val result = user.username.let {
      println("Имя: $it") // it -> "petya"
      it.length // Возвращаемое значение
    }

    println(result) // Выведет: 5
  }
}