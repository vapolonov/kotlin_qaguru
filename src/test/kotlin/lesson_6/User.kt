package lesson_6

data class User (
  val fid: Long,
  val login: String,
  val fullName: String,
  val email: String? = null,
  val phone: String? = null
)