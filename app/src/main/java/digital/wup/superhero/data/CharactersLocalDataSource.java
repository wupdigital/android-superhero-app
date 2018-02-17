package digital.wup.superhero.data;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.CharacterDataBase;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;
import timber.log.Timber;

public class CharactersLocalDataSource implements CharactersDataStore {
    private CharacterDataBase dataBase;

    public CharactersLocalDataSource(Context context) {
        dataBase = Room.databaseBuilder(context.getApplicationContext(), CharacterDataBase.class, "superhero-db").build();
    }

    @Override
    public void loadCharacters(Page page, final LoadCharactersCallback callback) {
        Timber.d("CharactersLocalDataSource - loadCharacters");
        Character[] characters = dataBase.characterDao().loadCharacters();
        if (characters != null && characters.length != 0) {
            callback.onSuccess(characters);
        } else {
            callback.onError(new Error());
        }
    }

    @Override
    public void loadCharacter(final String id, final LoadCharactersCallback callback) {
        Character character = dataBase.characterDao().loadCharacter(id);
        if (character != null) callback.onSuccess(new Character[]{character});
        else
            callback.onError(new Error(Error.EMPTY, "Room retrieved nothing from database"));

    }

    @Override
    public void saveCharacters(final Character[] characters, final SaveCharactersCallback callback) {
        Timber.d("CharactersLocalDataSource - saveCharacters");
        Long[] success = dataBase.characterDao().saveCharacters(characters);
        if (success != null && success.length > 0) callback.onSuccess();
        else callback.onError(new Error(Error.EMPTY, "Saving characters has failed"));
    }

}
