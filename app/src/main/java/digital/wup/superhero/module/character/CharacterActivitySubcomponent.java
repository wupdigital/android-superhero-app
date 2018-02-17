package digital.wup.superhero.module.character;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import digital.wup.superhero.presentation.ui.characters.CharactersActivity;

@Subcomponent
public interface CharacterActivitySubcomponent extends AndroidInjector<CharactersActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<CharactersActivity> {
    }
}
