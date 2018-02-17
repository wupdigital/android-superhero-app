package digital.wup.superhero.presentation;


import digital.wup.superhero.data.model.Character;

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
    }
}
