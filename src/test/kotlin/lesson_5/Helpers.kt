package lesson_5

import com.codeborne.selenide.ElementsCollection
import io.kotest.matchers.ints.shouldBeGreaterThan
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Helpers {

  companion object {

    fun getCurrentDate(): String {
      return LocalDate.now()
        .format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH))
    }

    fun ElementsCollection.toLabelValueMap(): Map<String, String> {
      size() shouldBeGreaterThan 0
      return filter { it.`$$`("td").size() >= 2 }
        .associate { row ->
          val cells = row.`$$`("td")
          cells[0].text to cells[1].text
        }
    }

    fun String.validatePhoneNumber(): Boolean {
      val regex = Regex("^[0-9]{10}\$")
      return regex.matches(this)
    }

  }
}