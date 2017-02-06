package guicetasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guicetasks.core.John;
import guicetasks.core.Maggie;
import guicetasks.core.Person;
import guicetasks.core.Tea;
import guicetasks.modules.PersonModule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class SingletonsTest {
    @Test
    public void lazySingletonShouldCreateInstanceOnMethodCalled() throws Exception {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Injector injector = Guice.createInjector(new PersonModule(Maggie.class, Tea.class));
        Person maggie = injector.getInstance(Person.class);

        assertThat(out.toString(), containsString("Maggie is up"));
        System.setOut(systemOut);
    }

    @Test
    public void eagerSingletonShouldCreateInstanceOnModuleLoaded() throws Exception {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Injector injector = Guice.createInjector(new PersonModule(John.class, Tea.class));

        assertThat(out.toString(), containsString("Instance of Tea was Created"));
        System.setOut(systemOut);
    }
}
