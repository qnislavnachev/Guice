package guicetasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guicetasks.core.AddressBook;
import guicetasks.core.Coffee;
import guicetasks.core.Maggie;
import guicetasks.modules.PersonModule;
import guicetasks.modules.SecondPersonModule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AddressBookRegisterTest {
    @Test
    public void registerListOfUsers() throws Exception {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Injector injector = Guice.createInjector(new PersonModule(Maggie.class, Coffee.class), new SecondPersonModule());
        AddressBook addressBook = injector.getInstance(AddressBook.class);
        addressBook.registerUsers();

        assertThat(out.toString(), containsString("Maggie was registered successful"));
        assertThat(out.toString(), containsString("John was registered successful"));
        assertThat(out.toString(), containsString("Jennie was registered successful"));

        System.setOut(systemOut);
    }
}
