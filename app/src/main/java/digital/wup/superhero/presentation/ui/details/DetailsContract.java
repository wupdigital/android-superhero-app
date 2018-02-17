package digital.wup.superhero.presentation.ui.details;


import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.presentation.Presenter;
import digital.wup.superhero.presentation.View;

public interface DetailsContract {
    interface DetailsPresenter extends Presenter {
        void takeView(DetailsContract.DetailsView view);

        void loadCharacter(String id);
    }

    interface DetailsView extends View {
        void showLoadingIndicator();

        void hideLoadingIndicator();

        void showCharacter(Character characters);

        void showLoadingCharacterError(String message);

        void showNoCharacter();
    }
}
