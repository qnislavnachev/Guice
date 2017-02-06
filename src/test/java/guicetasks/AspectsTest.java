package guicetasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guicetasks.core.AddressBook;
import guicetasks.core.Coffee;
import guicetasks.core.Maggie;
import guicetasks.core.Person;
import guicetasks.modules.PersonModule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AspectsTest {
    @Test
    public void registerPersonWithNotNullId() throws Exception {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Injector injector = Guice.createInjector(new PersonModule(Maggie.class, Coffee.class));
        AddressBook addressBook = injector.getInstance(AddressBook.class);
        Person person = new FakePerson(123, "name");

        addressBook.registerUsers();

        assertThat(out.toString(), containsString("Registration was successful !"));
        System.setOut(systemOut);
    }

    @Test(expected = NullPointerException.class)
    public void registerUserWithNullId() throws Exception {
        Injector injector = Guice.createInjector(new PersonModule(Maggie.class, Coffee.class));
        AddressBook addressBook = injector.getInstance(AddressBook.class);
        Person person = new FakePerson(null, null);

        addressBook.registerUsers();
    }
}
