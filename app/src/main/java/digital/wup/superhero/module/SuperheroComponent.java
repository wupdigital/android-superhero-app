package digital.wup.superhero.module;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import digital.wup.superhero.SuperheroApp;

@Singleton
@Component(modules = {SuperheroModule.class, SuperherActivityModule.class, AndroidInjectionModule.class})
public interface SuperheroComponent {
    void inject(SuperheroApp application);
}
