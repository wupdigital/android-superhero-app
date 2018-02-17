package digital.wup.superhero.module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import digital.wup.superhero.presentation.SuperheroActivity;

@Module(subcomponents = SuperheroActivitySubcomponent.class)
abstract class SuperherActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(SuperheroActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindSuperheroActivityInjectorFactory(SuperheroActivitySubcomponent.Builder builder);
}
