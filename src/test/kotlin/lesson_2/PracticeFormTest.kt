package lesson_2

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Practice form test")
@Story("Form test")
@Tags(Tag("FORM"), Tag("SMOKE"))
class PracticeFormTest {

  @Test
  @DisplayName("Check form title")
  fun formShouldHaveTitle() {
    open("https://demoqa.com/automation-practice-form")
    val formTitle = `$`("h1").text()
    formTitle shouldBe "Practice Form"
  }
}