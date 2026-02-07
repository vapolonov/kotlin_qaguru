package lesson_5

data class DemoUser(
  val firstName: String,
  val lastName: String,
  val email: String? = null,
  val gender: String? = "Male",
  val mobile: String,
  val birthDate: String? = null,
  val subjects: List<String>? = emptyList(),
  val hobbies: List<String>? = emptyList(),
  val address: String? = "Undefined",
  val state: String? = "Undefined",
  val city: String? = "Undefined"
)