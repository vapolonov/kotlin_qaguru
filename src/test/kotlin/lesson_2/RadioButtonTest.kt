package lesson_2

import com.codeborne.selenide.Selenide
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


@Feature("Form test")
@Story("Radio Button test")
class RadioButtonTest {

  val radioYes = Selenide.`$`("#yesRadio")
  val radioNo = Selenide.`$`("#noRadio")
  val radioImpressive = Selenide.`$`("#impressiveRadio")
  val radioText = Selenide.`$`(".mt-3")

  @Test
  @DisplayName("Check radio buttons")
  fun radioButtonShouldBeSelectable() {
    Selenide.open("https://demoqa.com/radio-button")
    val formTitle = Selenide.`$`("h1").text()
    formTitle shouldBe "Radio Button"

    radioYes.isSelected shouldBe false
    radioImpressive.isSelected shouldBe false
    radioNo.isEnabled shouldBe false

    Selenide.`$`("[for='yesRadio']").click()
    radioYes.isSelected shouldBe true
    radioText.text shouldBe "You have selected Yes"

    Selenide.`$`("[for='impressiveRadio']").click()
    radioImpressive.isSelected shouldBe true
    radioYes.isSelected shouldBe false
    radioText.text shouldBe "You have selected Impressive"
  }
}