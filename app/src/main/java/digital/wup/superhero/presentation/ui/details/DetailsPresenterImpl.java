package digital.wup.superhero.presentation.ui.details;


import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.domain.UseCaseCallback;
import digital.wup.superhero.domain.UseCaseHandler;
import digital.wup.superhero.domain.usecase.GetCharacterRequest;
import digital.wup.superhero.domain.usecase.GetCharacterResponse;
import digital.wup.superhero.domain.usecase.GetCharacterUseCase;

public class DetailsPresenterImpl implements DetailsContract.DetailsPresenter {
    private GetCharacterUseCase useCase;
    private DetailsContract.DetailsView view;
    private UseCaseHandler handler;

    public DetailsPresenterImpl(GetCharacterUseCase useCase, UseCaseHandler handler) {
        this.useCase = useCase;
        this.handler = handler;
    }

    @Override
    public void takeView(DetailsContract.DetailsView view) {
        this.view = view;
    }

    @Override
    public void loadCharacter(String id) {
        GetCharacterRequest request = new GetCharacterRequest();
        request.setCharacterId(id);

        handler.execute(useCase, request, new UseCaseCallback<GetCharacterResponse>() {
            @Override
            public void onSuccess(GetCharacterResponse response) {
                view.showCharacter(response.getCharacter());
            }

            @Override
            public void onError(Error error) {
                view.showLoadingCharacterError(error.getMessage());
            }
        });
    }
}
