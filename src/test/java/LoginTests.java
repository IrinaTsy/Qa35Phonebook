import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void loginSuccessModel() {

        //User user = new User();
        //user.setEmail("noa");
        //user.setPassword("Nnoa");

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isLogged());

    }


    @Test
    public void loginNegativeWrongEmailFormat() {

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("noagmail.com", "Nnoa12345$");
        app.getHelperUser().submitLog();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());

    }


}


