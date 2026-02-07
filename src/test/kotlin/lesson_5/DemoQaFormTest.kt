package lesson_5

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.open
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import lesson_5.Helpers.Companion.getCurrentDate
import lesson_5.Helpers.Companion.toLabelValueMap
import lesson_5.Helpers.Companion.validatePhoneNumber
import lesson_5.pages.PracticeFormPage
import net.datafaker.Faker
import org.junit.jupiter.api.Test
import java.util.*

class DemoQaFormTest {

  val faker = Faker(Locale.of("ru-RU"))

  @Test
  fun `practice form should submitted with required fields only`() {
    val formPage = PracticeFormPage()
    val demoUser = DemoUser(
      firstName = faker.name().firstName(),
      lastName = faker.name().lastName(),
      mobile = "9101234567",
      birthDate = getCurrentDate()
    )

    open("https://demoqa.com/automation-practice-form")
    with(formPage) {
      fillFirstName(demoUser.firstName)
      fillLastName(demoUser.lastName)
      selectGender()
      fillMobile(demoUser.mobile)
      submit()
    }

    val resultTable = `$$`(".table tr").toLabelValueMap()

    assertSoftly {
      resultTable["Student Name"] shouldBe "${demoUser.firstName} ${demoUser.lastName}"
      resultTable["Gender"] shouldBe demoUser.gender
      resultTable["Mobile"] shouldBe demoUser.mobile
      resultTable["Date of Birth"] shouldBe demoUser.birthDate
    }
  }

  @Test
  fun `validate user phone number`() {
     val demoUser = DemoUser(
      firstName = faker.name().firstName(),
      lastName = faker.name().lastName(),
      mobile = "7910123456",
    )

    demoUser.mobile.validatePhoneNumber() shouldBe true
  }
}