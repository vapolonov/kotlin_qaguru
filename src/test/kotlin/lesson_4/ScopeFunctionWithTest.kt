package lesson_4

import org.junit.jupiter.api.Test

class ScopeFunctionWithTest {

  /**
   * with НЕ является функцией-расширением, как остальные.
   * Он принимает объект в качестве аргумента.
   * with рекомендуется для вызова нескольких методов одного и того же объекта без возвращения результата.
   * Контекстный объект: this
   * Возвращаемое значение: Результат лямбда-выражения.
   */
  @Test
  fun `with function`() {
    val numbers = mutableListOf("one", "two", "three")

    val resultString = with(numbers) {
      // this здесь - это 'numbers'
      add("four")
      add("five")
      "Список содержит $size элементов." // Возвращаемое значение
    }

    println(resultString) // Выведет: "Список содержит 5 элементов."
    println(numbers) // Выведет: [one, two, three, four, five]
  }
}