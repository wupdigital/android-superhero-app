package digital.wup.superhero.data;


import java.util.List;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;

public class CharactersRepository implements CharactersDataStore {
    private CharactersLocalDataSource localDataSource;
    private CharactersRemoteDataStore remoteDataStore;

    public CharactersRepository(CharactersRemoteDataStore remoteDataStore, CharactersLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataStore = remoteDataStore;
    }

    @Override
    public void loadCharacters(final Page page, final LoadCharactersCallback callback) {
        localDataSource.loadCharacters(page, new LoadCharactersCallback() {
            @Override
            public void onSuccess(List<Character> characters) {
                callback.onSuccess(characters);
            }

            @Override
            public void onError(Error error) {
                remoteDataStore.loadCharacters(page, new LoadCharactersCallback() {
                    @Override
                    public void onSuccess(List<Character> characters) {
                        localDataSource.saveCharacters(characters, null);
                        callback.onSuccess(characters);
                    }

                    @Override
                    public void onError(Error error) {
                        callback.onError(error);
                    }
                });
            }
        });
    }

    @Override
    public void loadCharacter(final String id, final LoadCharactersCallback callback) {
        localDataSource.loadCharacter(id, new LoadCharactersCallback() {
            @Override
            public void onSuccess(List<Character> characters) {
                callback.onSuccess(characters);
            }

            @Override
            public void onError(Error error) {
                remoteDataStore.loadCharacter(id, new LoadCharactersCallback() {
                    @Override
                    public void onSuccess(List<Character> characters) {
                        localDataSource.saveCharacters(characters, null);
                        callback.onSuccess(characters);
                    }

                    @Override
                    public void onError(Error error) {
                        callback.onError(error);
                    }
                });
            }
        });
    }

    @Override
    public void saveCharacters(List<Character> characters, SaveCharactersCallback callback) {
        throw new UnsupportedOperationException("Method not implemented!");
    }
}