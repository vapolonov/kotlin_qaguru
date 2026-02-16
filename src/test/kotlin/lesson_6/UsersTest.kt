package lesson_6

import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UsersTest {

  @Test
  fun `User should be equal defaultUser`() {

    val taxpayer = User(
      fid = 1001L,
      login = "ivanov",
      fullName = "Ivan Ivanov",
      email = "ivan@example.com",
      phone = "+79991234567"
    )

    taxpayer shouldBeEqual Users.defaultUser
  }

  @Test
  fun `User match defaultUser fields`() {

    val testUser = Users.defaultUser.copy()

    testUser.login shouldBe Users.defaultUser.login
    testUser.email shouldBe Users.defaultUser.email
  }

  @Test
  fun `User from Enum IVAN should be equal expected User`() {

    val userFromEnum = UserEnum.ADMIN.user

    val expectedUser = User(
      fid = 1L,
      login = "admin",
      fullName = "Administrator",
    )

    userFromEnum shouldBe expectedUser
  }

  @Test
  fun `User copy should be equal original`() {

    val copyUser = Users.defaultUser.copy()
    copyUser shouldBe Users.defaultUser
  }

  @Test
  fun `User copy with modified field`() {

    val modifiedStudent = Users.defaultUser.copy(phone = "+7(910)987-77-55")

    modifiedStudent.phone shouldBe "+7(910)987-77-55"
    modifiedStudent.fullName shouldBe "Ivan Ivanov"
  }
}