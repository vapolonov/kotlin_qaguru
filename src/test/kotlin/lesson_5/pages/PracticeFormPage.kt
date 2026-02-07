package lesson_4.pages

import com.codeborne.selenide.Selenide.element

class PracticeFormPage {

  fun fillFirstName(firstName: String) {
    element("#firstName").value = firstName
  }

  fun fillLastName(lastName: String) {
    element("#lastName").value = lastName
  }

  fun selectGender() {
    element("[for='gender-radio-1']").click()
  }

  fun fillMobile(number: String) {
    element("#userNumber").value = number
  }

  fun submit() {
    element("#submit").scrollIntoCenter().click()
  }
}