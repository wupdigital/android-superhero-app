package digital.wup.superhero.domain.usecase;


import digital.wup.superhero.data.CharactersDataStore;
import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.domain.UseCase;

public class GetCharacterUseCase extends UseCase<GetCharacterRequest, GetCharacterResponse> {
    private CharactersDataStore charactersDataStore;

    public GetCharacterUseCase(CharactersDataStore charactersDataStore) {
        this.charactersDataStore = charactersDataStore;
    }

    @Override
    protected void executeUseCase(GetCharacterRequest request) {
        charactersDataStore.loadCharacter(request.getCharacterId(), new CharactersDataStore.LoadCharactersCallback() {
            @Override
            public void onSuccess(Character[] characters) {
                GetCharacterResponse response = new GetCharacterResponse(characters[0]);
                useCaseCallback.onSuccess(response);
            }

            @Override
            public void onError(Error error) {
                useCaseCallback.onError(error);
            }
        });
    }
}
