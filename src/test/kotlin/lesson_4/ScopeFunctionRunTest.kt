package lesson_4

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScopeFunctionRunTest {

  @Test
  @DisplayName("Создание и проверка пользователя при помощи scope функции RUN")
  fun testUserCreationAndValidationWithRunFunction() {
    val user = run {
      User(
        id = 2,
        username = "test_user",
        password = "Pass123!",
        email = "testuser@example.com",
        age = 25,
        isActive = true,
        roles = listOf("admin", "test"),
        phone = "+79101234567"
      )
    }

    user.username shouldContain "test_"
    user.username.length shouldBeGreaterThanOrEqualTo 8

    user.password.length shouldBeGreaterThanOrEqualTo 8
    user.password shouldContain "!"

    user.email.shouldNotBeNull()
    user.email shouldContain "@example.com"

    user.age shouldBe 25

    user.roles shouldContain "test"
    user.roles.size shouldBe 2

    user.phone shouldBe "+79101234567"

    val isAdmin = user.run {
      isActive && roles.contains("admin")
    }
    isAdmin.shouldBeTrue()
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