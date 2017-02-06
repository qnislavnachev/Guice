package guicetasks.modules;

import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import guicetasks.aspects.Register;
import guicetasks.aspects.RegisterInterceptor;
import guicetasks.core.*;

import java.util.Map;
import java.util.Set;

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;

public class PersonModule extends AbstractModule {
    private Class<? extends Person> personClass;
    private Class<? extends HotDrinks> hotDrinksClass;

    public PersonModule(Class<? extends Person> personClass, Class<? extends HotDrinks> hotDrinksClass) {
        this.personClass = personClass;
        this.hotDrinksClass = hotDrinksClass;
    }

    @Override
    protected void configure() {
        MapBinder<Integer, Person> people = getInstanceOfAllPersons();
        bindInterceptor(any(), annotatedWith(Register.class), new RegisterInterceptor());

        bind(Integer.class).annotatedWith(Names.named("Maggie")).toInstance(111);
        bind(Integer.class).annotatedWith(Names.named("John")).toInstance(222);
        bind(Integer.class).annotatedWith(Names.named("Jennie")).toInstance(333);

        bind(HotDrinks.class).to(hotDrinksClass).asEagerSingleton();
        bind(Person.class).to(personClass).in(Scopes.SINGLETON);

        bind(Map.class).toProvider(StatisticsProvider.class);
    }

    private MapBinder<Integer, Person> getInstanceOfAllPersons() {
        MapBinder<Integer, Person> persons = MapBinder.newMapBinder(binder(), Integer.class, Person.class);
        persons.addBinding(1).to(Maggie.class).in(Scopes.SINGLETON);
        return persons;
    }

    @Provides
    public Set<String> get() {
        return Sets.newHashSet(new Maggie(11).getName(), new John(22).getName(), new Jennie(33).getName());
    }
}
