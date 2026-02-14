package lesson_4

import org.junit.jupiter.api.Test

class ScopeFunctionApplyTest {

  /**
   * apply используется для настройки или инициализации объекта.
   * Он выполняет блок кода для объекта и возвращает сам объект.
   * Контекстный объект: this
   * Возвращаемое значение: Сам объект (this).
   */
  @Test
  fun `scope function apply`() {

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
      // this здесь - это 'adminUser'
      username == "admin_user"
      email == "admin@example.com"
    }

    // 'adminUser' теперь настроен
    println("Имя: ${adminUser.username}, Email: ${adminUser.email}")
  }
}