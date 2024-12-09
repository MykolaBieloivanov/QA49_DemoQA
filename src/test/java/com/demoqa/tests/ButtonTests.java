package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTests extends TestBase{


    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons().hideIframes();
    }


    @Test
    public void doubleClickTest(){
        new ButtonsPage(driver).doubleClick();
    }

    @Test
    public void rightClick(){
        new ButtonsPage(driver).rightClick();

    }
}
