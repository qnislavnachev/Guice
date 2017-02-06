package guicetasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import guicetasks.core.Coffee;
import guicetasks.core.Maggie;
import guicetasks.modules.PersonModule;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NameSetTest {

    @Test
    public void returnGenericTypeSet() throws Exception {
        Injector injector = Guice.createInjector(new PersonModule(Maggie.class, Coffee.class));

        Set<String> nameSet = injector.getInstance(Key.get(new TypeLiteral<Set<String>>(){}));
        assertThat(nameSet.size(), is(3));
    }
}
