package lesson_4

import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ScopeFunctionWithTest {

  @Test
  fun `test user profile with function With`() {
    val user = User(
      id = 12345,
      username = "username",
      password = "password123",
      email = "user@example.com",
      age = 30,
      roles = listOf("user"),
      phone = "+79100000000"
    )

    with(user) {
      id.shouldBe(12345)
      email.shouldBe("user@example.com")
      age?.shouldBeGreaterThanOrEqual(0)
      isActive.shouldBeTrue()
      roles.shouldHaveSize(1)
      phone?.length?.shouldBeEqual((12))
    }
  }
}