package lesson_6

enum class UserEnum(
  val fid: Long,
  val login: String,
  val fullName: String,
  val email: String?,
  val phone: String?
) {

  IVAN(
    fid = 1001L,
    login = "ivanov",
    fullName = "Ivan Ivanov",
    email = "ivan@example.com",
    phone = "+79991234567"
  ),

  PETR(
    fid = 1002L,
    login = "petrov",
    fullName = "Petr Petrov",
    email = "petr@example.com",
    phone = null
  ),

  ADMIN(
    fid = 1L,
    login = "admin",
    fullName = "Administrator",
    email = null,
    phone = null
  )

}