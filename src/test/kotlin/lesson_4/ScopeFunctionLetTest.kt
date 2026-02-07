package lesson_4

import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.ints.shouldNotBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScopeFunctionLetTest {

  @Test
  @DisplayName("Создание и проверка пользователя при помощи scope функции RUN")
  fun functionLetShouldValidateEmailIfPresent() {
    val user = User(
      id = 1L,
      password = "test",
      username = "petya",
      email = null
    )

    user.email?.let {
      it.shouldNotBeBlank()
      it.shouldBe("Undefined")
    }

    user.let { user ->
      user.isActive.shouldBeTrue()
      user.username shouldBe "petya"
      user.password shouldBe "test"
      user.age?.shouldNotBeLessThan(1)
    }
  }
}