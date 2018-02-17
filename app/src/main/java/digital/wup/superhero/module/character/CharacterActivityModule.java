package digital.wup.superhero.module.character;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import digital.wup.superhero.presentation.ui.characters.CharactersActivity;

@Module(subcomponents = CharacterActivitySubcomponent.class)
public abstract class CharacterActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(CharactersActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindSuperheroActivityInjectorFactory(CharacterActivitySubcomponent.Builder builder);
}
