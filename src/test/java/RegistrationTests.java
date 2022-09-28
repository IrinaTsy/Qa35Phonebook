import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    //irs@gmail.com
    //Ii456789$

    @BeforeMethod
    public void precondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void RegSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmail.com").withPassword("Vv456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void RegUnsuccessWrongEmailFormat() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "gmail.com").withPassword("Vv456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    // @Test     IS THIS A BUG? С таким Email система выдает сообщение, что User already exists
    // public void RegUnsuccessWrongEmailFormatWithoutName(){
    //   User user = new User().withEmail("@gmail.com").withPassword("Ii456789$");
    //  app.getHelperUser().openLogRegForm();
    //  app.getHelperUser().fillLogRegForm(user);
    //  app.getHelperUser().submitReg();
    //  app.getHelperUser().Wait();
    //  Assert.assertTrue(app.getHelperUser().isAlertPresent());
    //  Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    //  Assert.assertFalse(app.getHelperUser().isLogged());
    // }

   // @Test   IS THIS A BAG? С таким Email получается зарегистрироваться
   // public void RegUnsuccessWrongEmailFormatWithoutGmail() {
      //  User user = new User().withEmail("qrs@.com").withPassword("Ii456789$");
      //  app.getHelperUser().openLogRegForm();
      //  app.getHelperUser().fillLogRegForm(user);
      //  app.getHelperUser().submitReg();
      //  app.getHelperUser().Wait();
      //  Assert.assertTrue(app.getHelperUser().isAlertPresent());
      //  Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
      //  Assert.assertFalse(app.getHelperUser().isLogged());
    //}

    @Test
    public void RegUnsuccessWrongEmailFormatWithoutDot() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmailcom").withPassword("Vv456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void RegUnsuccessWrongEmailFormatWithoutCom() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmail.").withPassword("Vv456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }


    @Test
    public void RegUnsuccessWrongPassFormat() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmail.com").withPassword("Vv456789");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void RegUnsuccessWrongPassFormatWithoutUpperCase() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmail.com").withPassword("vv456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void RegUnsuccessWrongPassFormatWithoutNumbers() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmail.com").withPassword("Vv$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void RegUnsuccessWrongPassFormatWithoutLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("vrs" + i + "@gmail.com").withPassword("456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void RegUnsuccessUserAlreadyExist() {
        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();
        app.getHelperUser().Wait();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isUserExist());
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

}
