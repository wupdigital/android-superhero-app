package digital.wup.superhero.module;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import digital.wup.superhero.presentation.SuperheroActivity;

@Subcomponent
public interface SuperheroActivitySubcomponent extends AndroidInjector<SuperheroActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<SuperheroActivity> {
    }
}
