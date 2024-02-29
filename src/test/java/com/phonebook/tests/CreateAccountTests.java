package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void createExistedAccountNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("esiminch@gm.com")
                .setPassword("Esiminch1234$"));
        app.getUser().clickOnRegistrationButton();
        //assert Sign Out button is present
        Assert.assertTrue(app.getUser().isAlertAppears());
    }

}