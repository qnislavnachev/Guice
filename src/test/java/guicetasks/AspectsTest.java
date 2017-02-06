package guicetasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guicetasks.core.Car;
import guicetasks.modules.BmwProvider;
import guicetasks.modules.LazyCarModule;
import guicetasks.modules.OpelProvider;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AspectsTest {

    @Test
    public void callMethodThatReturnOpel() throws Exception {
        Injector injector = Guice.createInjector(new LazyCarModule(OpelProvider.class));
        Car car = injector.getInstance(Car.class);

        assertThat(car.getCarName(), is("This is Opel"));
    }

    @Test(expected = IllegalStateException.class)
    public void callMethodThatDoesntReturnOpel() throws Exception {
        Injector injector = Guice.createInjector(new LazyCarModule(BmwProvider.class));
        Car car = injector.getInstance(Car.class);
        car.getCarName();
    }
}
