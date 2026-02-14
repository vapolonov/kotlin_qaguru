package lesson_4

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScopeFunctionAlsoTest {

  /**
   * also используется для выполнения дополнительных действий с объектом,
   * таких как логирование или отладка. Он, как и apply, возвращает сам объект.
   * Контекстный объект: it (можно переименовать)
   * Возвращаемое значение: Сам объект (this).
   */

  @Test
  @DisplayName("Создание пользователя с выводом данных в консоль")
  fun `also logs created user`() {
    val user = User(
      id = 5,
      username = "user_name",
      password = "Pass123!"
    )

    val updatedUser = user.also {
      println("Исходный user: ID: ${user.id} имя: ${user.username} пароль: ${user.password} email: ${user.email}")
      // Исходный user: ID: 5 имя: user_name пароль: Pass123! email: Undefined
      user.email = "test@test.com"
      println("user c почтой: ID: ${user.id} имя: ${user.username} пароль: ${user.password} email: ${user.email}")
      // user c почтой: ID: 5 имя: user_name пароль: Pass123! email: test@test.com
    }

    println("Финальный user: $updatedUser")
    // Финальный user: User(id=5, username=user_name, password=Pass123!, email=test@test.com, age=null, isActive=true, roles=[], phone=null)
  }

  @Test
  fun `scope function also`() {
    val numberList = mutableListOf(1, 2, 3)
    val updatedList = numberList.also {
      println("Исходный список: $it") // it -> [1, 2, 3]
      it.add(4)
      println("Список после добавления элемента: $it") // it -> [1, 2, 3, 4]
    }
    println("Финальный список: $updatedList") // Выведет: Финальный список: [1, 2, 3, 4]
  }
}