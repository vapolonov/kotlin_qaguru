package lesson_3

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.open
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Feature("Form test")
@Story("Tabs test")
@Tag("TABS")
class CollectionsTest {

  @Test
  @DisplayName("Check empty array")
  fun arrayShouldBeEmpty() {
    val numbers: Array<Int> = arrayOf()
    numbers.shouldBeEmpty()
  }

  @Test
  @DisplayName("Check not empty array")
  fun arrayShouldNotBeEmpty() {
    val numbers: Array<String> = arrayOf("first", "second", "third")
    numbers.shouldNotBeEmpty()
  }

  @Test
  @DisplayName("Check array elements")
  fun arrayShouldHaveFirstElement() {
    val numbers: Array<String> = arrayOf("Main", "Sneakers", "Clothes", "Reviews")
    numbers.first() shouldBe "Main"
    numbers.last() shouldBe "Reviews"
    numbers[1] shouldBe "Sneakers"
  }

  @Test
  @DisplayName("Check tabs")
  fun tabsShouldBeVisible() {
    open("https://demoqa.com/tabs")
    val pageTitle: String = `$`("h1").text()
    val tabsList: ElementsCollection = `$$`("nav a")

    pageTitle shouldBe "Tabs"
    tabsList.shouldNotBeEmpty()
    tabsList[0].text() shouldBe "What"
    tabsList.size() shouldBeEqual 4
    tabsList.size() shouldBeGreaterThan 0
    tabsList.texts() shouldContainExactly listOf("What", "Origin", "Use", "More")
  }
}