package lesson_2

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Feature("Form test")
@Story("Radio Button test")
@Tag("RADIO")
class RadioButtonTest {

  val radioYes = `$`("#yesRadio")
  val radioNo = `$`("#noRadio")
  val radioImpressive = `$`("#impressiveRadio")
  val radioText = `$`(".mt-3")

  @Test
  @DisplayName("Check radio buttons")
  fun radioButtonShouldNotBeSelectableInInitialState() {
    open("https://demoqa.com/radio-button")
    val formTitle = `$`("h1").text()
    formTitle shouldBe "Radio Button"
    radioYes.isSelected shouldBe false
    radioImpressive.isSelected shouldBe false
    radioNo.isEnabled shouldBe false
  }

  @Test
  @DisplayName("Check Yes radio button")
  fun radioButtonYesShouldBeSelectable() {
    open("https://demoqa.com/radio-button")
    `$`("[for='yesRadio']").click()
    radioYes.isSelected shouldBe true
    radioText.text shouldBe "You have selected Yes"
  }

  @Test
  @DisplayName("Check Impressive radio button")
  fun radioButtonImpressiveShouldBeSelectable() {
    open("https://demoqa.com/radio-button")
    `$`("[for='impressiveRadio']").click()
    radioImpressive.isSelected shouldBe true
    radioYes.isSelected shouldBe false
    radioText.text shouldBe "You have selected Impressive"
  }
}