package guicetasks.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import guicetasks.core.AddressBook;
import guicetasks.core.Jennie;
import guicetasks.core.John;
import guicetasks.core.Person;

public class SecondPersonModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<Integer, Person> people = getInstanceOfAllPersons();
        bind(AddressBook.class).toInstance(new AddressBook());
    }

    private MapBinder<Integer, Person> getInstanceOfAllPersons () {
        MapBinder<Integer, Person> persons = MapBinder.newMapBinder(binder(), Integer.class, Person.class);
        persons.addBinding(2).to(John.class).in(Scopes.SINGLETON);
        persons.addBinding(3).to(Jennie.class).in(Scopes.SINGLETON);
        return persons;
    }
}
