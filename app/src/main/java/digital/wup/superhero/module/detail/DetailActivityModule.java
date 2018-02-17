package digital.wup.superhero.module.detail;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import digital.wup.superhero.presentation.ui.details.DetailsActivity;

@Module(subcomponents = DetailActivitySubcomponent.class)
public abstract class DetailActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(DetailsActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindDetailsActivityInjectorFactory(DetailActivitySubcomponent.Builder builder);
}
