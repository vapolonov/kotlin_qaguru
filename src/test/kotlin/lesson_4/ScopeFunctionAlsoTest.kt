package lesson_4

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScopeFunctionAlsoTest {

  @Test
  @DisplayName("Создание пользователя с выводом данных в консоль")
  fun `also logs created user`() {
    val user = User(
      id = 5,
      username = "user_name",
      password = "Pass123!"
    ).also {
      println("Created user: $it")
    }

    user.email.shouldBe("Undefined")
  }
}