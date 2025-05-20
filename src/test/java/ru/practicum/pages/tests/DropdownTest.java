package ru.practicum.pages.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.DropdownPage;

public class DropdownTest extends DriverFactory {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test // 1
    public void checkTextDropDown1() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropDown = new DropdownPage(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown1();
        objDropDown.checkTextAnswerDropDown1();
    }

    @Test // 2
    public void checkTextDropDown2() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown2();
        objDropdownPage.checkTextAnswerDropDown2();
    }

    @Test // 3
    public void checkTextDropDown3() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown3();
        objDropdownPage.checkTextAnswerDropDown3();
    }

    @Test // 4
    public void checkTextDropDown4() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown4();
        objDropdownPage.checkTextAnswerDropDown4();
    }

    @Test // 5
    public void checkTextDropDown5() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown5();
        objDropdownPage.checkTextAnswerDropDown5();
    }

    @Test // 6
    public void checkTextDropDown6() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown6();
        objDropdownPage.checkTextAnswerDropDown6();
    }

    @Test // 7
    public void checkTextDropDown7() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown7();
        objDropdownPage.checkTextAnswerDropDown7();
    }

    @Test // 8
    public void checkTextDropDown8() {
        WebDriver driver = driverFactory.getDriver();
        DropdownPage objDropdownPage = new DropdownPage(driver);
        objDropdownPage.scrollDown();
        objDropdownPage.clickButtonQuestionDropDown8();
        objDropdownPage.checkTextAnswerDropDown8();
    }
}

