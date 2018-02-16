package digital.wup.superhero.data;


import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;

public interface CharactersDataStore {
    void loadCharacters(Page page, LoadCharactersCallback callback);

    void loadCharacter(String id, LoadCharactersCallback callback);

    void saveCharacters(Character[] characters, SaveCharactersCallback callback);

    interface LoadCharactersCallback {
        void onSuccess(Character[] characters);

        void onError(Error error);
    }

    interface SaveCharactersCallback {
        void onSuccess();

        void onError(Error error);
    }
}
