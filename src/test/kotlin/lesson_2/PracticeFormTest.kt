package lesson_2

import com.codeborne.selenide.Selenide
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Practice form test")
@Story("Form test")
@Tag("SMOKE")
@Tags(Tag("SMOKE"), Tag("SINGLE"))
class PracticeFormTest {

  @Test
  @DisplayName("Check form title")
  fun formShouldHaveTitle() {
    Selenide.open("https://demoqa.com/automation-practice-form")
    val formTitle = Selenide.`$`("h1").text()
    formTitle shouldBe "Practice Form"
  }
}