package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.AutoCompletePAge;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutoComplete().hideIframes();

    }


    @Test
    public void autoCompleteTest(){
        new AutoCompletePAge(driver).autoComplete();
    }
}
