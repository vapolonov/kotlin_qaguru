package lesson_4

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.Test

class ScopeFunctionApplyTest {

  @Test
  fun `create test user with apply function`() {
    // проверка при создании
    val adminUser = User(
      id = 1,
      username = "admin_user",
      password = "AdminPass123!",
      email = "admin@example.com",
      age = 35,
      isActive = true,
      roles = listOf("admin", "user"),
      phone = "+79101112233"
    ).apply {
      username shouldContain "admin"
      password.length shouldBeGreaterThanOrEqualTo 10
      email shouldContain "@"
      roles shouldContain "admin"
      phone shouldStartWith "+"
    }
  }
}