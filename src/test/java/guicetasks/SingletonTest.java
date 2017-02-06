package guicetasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guicetasks.core.Car;
import guicetasks.core.Mercedes;
import guicetasks.modules.EagerCarModule;
import guicetasks.modules.LazyCarModule;
import guicetasks.modules.MercedesProvider;
import guicetasks.modules.OpelProvider;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class SingletonTest {

    @Test
    public void LazyCarModuleCreateInstanceOnMethodCalled() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Injector injector = Guice.createInjector(new LazyCarModule(OpelProvider.class));
        Car car = injector.getInstance(Car.class);

        assertThat(out.toString(), containsString("Instance was created"));
        System.setOut(System.out);
    }


    @Test
    public void EagerCarModuleCreateInstanceOnClassLoaded() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Injector injector = Guice.createInjector(new EagerCarModule(OpelProvider.class));

        assertThat(out.toString(), containsString("Instance was created"));
        System.setOut(System.out);
    }
}
