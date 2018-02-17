package digital.wup.superhero.presentation.ui.characters;


import android.os.Bundle;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.presentation.Presenter;
import digital.wup.superhero.presentation.View;

public interface CharactersContract {
    interface CharactersPresenter extends Presenter {
        void takeView(CharactersView view);

        Character[] characters();

        int charactersCount();

        void loadCharacters();

        void loadMoreCharacters();
    }

    interface CharactersView extends View {
        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showMoreLoadingIndicator();

        void hideMoreLoadingIndicator();

        void showCharacters(Character[] characters);

        void showLoadingCharactersError(String message);

        void showNoCharacters();

        void navigateToDetails(Bundle bundle);
    }
}
