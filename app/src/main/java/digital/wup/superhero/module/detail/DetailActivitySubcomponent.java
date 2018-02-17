package digital.wup.superhero.module.detail;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import digital.wup.superhero.presentation.ui.details.DetailsActivity;

@Subcomponent
public interface DetailActivitySubcomponent extends AndroidInjector<DetailsActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<DetailsActivity> {
    }
}
