package lesson_4

data class User (
  val id: Long,
  val username: String,
  val password: String,
  val email: String? = "Undefined",
  val age: Int? = null,
  val isActive: Boolean = true,
  val roles: List<String> = emptyList(),
  val phone: String? = null
) {}
