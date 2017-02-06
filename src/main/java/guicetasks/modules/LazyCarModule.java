package guicetasks.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MapBinder;
import guicetasks.aspects.CheckForOpel;
import guicetasks.aspects.OpelValidationInterceptor;
import guicetasks.core.*;

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;

public class LazyCarModule extends AbstractModule {
    private Class provider;

    public LazyCarModule(Class provider) {
        this.provider = provider;
    }

    @Override
    protected void configure() {
        MapBinder<Integer, Car> carMapBinder = getCarMapBinder();
        OpelValidationInterceptor interceptor = new OpelValidationInterceptor();
        bindInterceptor(any(), annotatedWith(CheckForOpel.class), interceptor);
        bind(Car.class).toProvider(provider).in(Scopes.SINGLETON);
    }

    private MapBinder<Integer, Car> getCarMapBinder() {
        MapBinder<Integer, Car> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, Car.class);
        mapBinder.addBinding(0).to(Bmw.class);
        mapBinder.addBinding(1).to(Opel.class);
        mapBinder.addBinding(2).to(Mercedes.class);
        return mapBinder;
    }
}
