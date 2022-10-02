import models.Contacts;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class AddNewContact extends TestBase{

    @BeforeMethod
    public void precondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void addContactSuccess(){
        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("Petrova")
                .phone("647895")
                .email("aa@mail.com")
                .address("Asdod,Israil")
                .description("hhhhhhhh")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();
        Assert.assertTrue(app.helperContacts().elmPresent());
    }

    @Test
    public void addContactSuccess2(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Alex")
                .lastName("Nikonov")
                .phone("698712")
                .email("aa@mail.com")
                .address("Asdod,Israil")
                .description("friend")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
       // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation+1);
    }

    @Test
    public void addContactUnsuccessFormIsEmpty(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("")
                .lastName("")
                .phone("")
                .email("")
                .address("")
                .description("")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test
    public void addContactUnsuccessFieldNameIsEmpty(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("")
                .lastName("Petrova")
                .phone("555555")
                .email("aa@mail.com")
                .address("Asdod,Israil")
                .description("friend")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test
    public void addContactUnsuccessFieldLastNameIsEmpty(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("")
                .phone("555555")
                .email("aa@mail.com")
                .address("Asdod,Israil")
                .description("friend")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test
    public void addContactUnsuccessFieldPhoneIsEmpty(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("Petrova")
                .phone("")
                .email("aa@mail.com")
                .address("Asdod,Israil")
                .description("friend")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test(enabled = false,description = "BUG, registered user can create contact with phone lettered")
    public void addContactUnsuccessFieldPhoneWithLetters(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("Petrova")
                .phone("phone")
                .email("aa@mail.com")
                .address("Asdod,Israil")
                .description("friend")
                .build();


        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test
    public void addContactUnsuccessFieldEmailIsEmpty(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("Petrova")
                .phone("5555555")
                .email("")
                .address("Asdod,Israil")
                .description("friend")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
       // app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test
    public void addContactUnsuccessFieldAddressIsEmpty(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("Petrova")
                .phone("5555555")
                .email("aa@gmail.com")
                .address("")
                .description("friend")
                .build();

        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
        //app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);
    }

    @Test
    public void addContactUnsuccessContactAlreadyExists(){

        int contactCountBeforeCreation = app.helperContacts().getCountContacts();

        Contacts contacts = Contacts.builder()
                .name("Olya")
                .lastName("Petrova")
                .phone("647895")
                .email("")
                .address("Asdod,Israil")
                .description("hhhhhhhh")
                .build();


        User user = new User().withEmail("irs@gmail.com").withPassword("Ii456789$");
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLog();
        // app.getHelperUser().pause(5000);
        app.helperContacts().openAddContactsForm();
        app.helperContacts().fillContactsForm(contacts);
        app.helperContacts().buttonSave();

        int contactCountAfterCreation = app.helperContacts().getCountContacts();

        Assert.assertEquals(contactCountAfterCreation,contactCountBeforeCreation);

    }



}