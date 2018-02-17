package digital.wup.superhero.domain.usecase;


import digital.wup.superhero.data.CharactersDataStore;
import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.domain.UseCase;

public class GetCharactersUseCase extends UseCase<GetCharactersRequest, GetCharactersResponse> {
    private CharactersDataStore charactersDataStore;

    public GetCharactersUseCase(CharactersDataStore charactersDataStore) {
        this.charactersDataStore = charactersDataStore;
    }

    @Override
    protected void executeUseCase(GetCharactersRequest request) {
        charactersDataStore.loadCharacters(request.getPage(), new CharactersDataStore.LoadCharactersCallback() {
            @Override
            public void onSuccess(Character[] characters) {
                GetCharactersResponse response = new GetCharactersResponse();
                response.setCharacters(characters);

                useCaseCallback.onSuccess(response);
            }

            @Override
            public void onError(Error error) {
                useCaseCallback.onError(error);
            }
        });
    }
}
