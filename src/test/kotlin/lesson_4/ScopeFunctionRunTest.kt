package lesson_4

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScopeFunctionRunTest {

  /**
   * run похож на let, но обращается к контекстному объекту через this (как к члену класса).
   * Он полезен, когда лямбда содержит как вызовы методов объекта, так и вычисления.
   * Контекстный объект: this
   * Возвращаемое значение: Результат лямбда-выражения.
   */
  @Test
  @DisplayName("Создание и проверка пользователя при помощи scope функции RUN")
  fun `scope function run`() {
    val user = User(
        id = 2,
        username = "test_user",
        password = "Pass123!",
        email = "testuser@example.com",
        age = 25,
        isActive = true,
        roles = listOf("admin", "test"),
        phone = "+79101234567"
      )

    val userDescription = user.run {
      // this здесь - это 'user'
      println("Пользователь: $username, Возраст: $age")  // Пользователь: test_user, Возраст: 25
      "Возраст пользователя: $age" // Возвращаемое значение
    }

    println(userDescription) // Выведет: "Возраст пользователя: 25"
  }

  @Test
  @DisplayName("Создание и проверка пользователя при помощи scope функции RUN")
  fun testInvalidUserCreationAndValidationWithRunFunction() {
    run {
      val invalidUser = User(
        id = 999,
        username = "ab",
        password = "123",
        email = "invalid-email",
        age = -5,
        isActive = true,
        roles = emptyList(),
        phone = "invalid-phone"
      )

      assertSoftly {
        invalidUser.username.length shouldBeGreaterThanOrEqualTo 5
        invalidUser.password.length shouldBeGreaterThanOrEqualTo 8
        invalidUser.email shouldContain "@"
        invalidUser.age?.shouldBeGreaterThanOrEqualTo(0)
      }
    }
  }
}