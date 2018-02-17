package digital.wup.superhero.presentation.ui.characters;


import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;
import digital.wup.superhero.domain.UseCaseCallback;
import digital.wup.superhero.domain.UseCaseHandler;
import digital.wup.superhero.domain.usecase.GetCharactersRequest;
import digital.wup.superhero.domain.usecase.GetCharactersResponse;
import digital.wup.superhero.domain.usecase.GetCharactersUseCase;

public class CharacatersPresenterImpl implements CharactersContract.CharactersPresenter {
    private GetCharactersUseCase useCase;
    private UseCaseHandler handler;
    private CharactersContract.CharactersView view;

    public CharacatersPresenterImpl(GetCharactersUseCase useCase, UseCaseHandler handler) {
        this.useCase = useCase;
        this.handler = handler;
    }

    @Override
    public void takeView(CharactersContract.CharactersView view) {
        this.view = view;
    }

    @Override
    public Character[] characters() {
        return new Character[0];
    }

    @Override
    public int charactersCount() {
        return 0;
    }

    @Override
    public void loadCharacters() {
        final GetCharactersRequest request = new GetCharactersRequest();
        request.setPage(new Page(100, 10));

        handler.execute(useCase, request, new UseCaseCallback<GetCharactersResponse>() {
            @Override
            public void onSuccess(GetCharactersResponse response) {
                if (response.getCharacters() != null && response.getCharacters().length > 0)
                    view.showCharacters(response.getCharacters());
            }

            @Override
            public void onError(Error error) {
                view.showNoCharacters();
            }
        });
    }

    @Override
    public void loadMoreCharacters() {

    }
}
