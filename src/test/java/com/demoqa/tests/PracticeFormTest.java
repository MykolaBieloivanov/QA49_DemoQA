package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.pages.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addNewStudentWithCsv")
    public void createStudentAccount(String name, String lastName, String email, String phone) {
        new PracticeFormPage(driver)
                .enterPersonalData(name, lastName, email, phone)
                .selectGender("male")
                .enterDate("19 Jun 1999")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("C:/Tools")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }

    @Test
    public void createStudentAccountWithSelectDate() {
        new PracticeFormPage(driver)
                .enterPersonalData("Biba", "Boba", "biba777@gmail.com", "1234567890")
                .selectGender("male")
                .selectDate("August", "1998", "19")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("C:/Tools/33.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
