package digital.wup.superhero.data;


import java.util.List;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Page;

public class CharactersRemoteDataStore implements CharactersDataStore {
    @Override
    public void loadCharacters(Page page, LoadCharactersCallback callback) {

    }

    @Override
    public void loadCharacter(String id, LoadCharactersCallback callback) {

    }

    @Override
    public void saveCharacters(List<Character> characters, SaveCharactersCallback callback) {
        throw new UnsupportedOperationException("Method not implemented!");
    }
}
