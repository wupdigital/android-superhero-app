package digital.wup.superhero.module;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import digital.wup.superhero.SuperheroApp;
import digital.wup.superhero.module.character.CharacterActivityModule;
import digital.wup.superhero.module.detail.DetailActivityModule;

@Singleton
@Component(modules = {SuperheroModule.class, CharacterActivityModule.class, DetailActivityModule.class, AndroidInjectionModule.class})
public interface SuperheroComponent {
    void inject(SuperheroApp application);
}
