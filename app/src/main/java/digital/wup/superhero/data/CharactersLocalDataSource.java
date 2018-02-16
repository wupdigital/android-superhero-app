package digital.wup.superhero.data;


import android.arch.persistence.room.Room;
import android.content.Context;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.CharacterDataBase;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;

public class CharactersLocalDataSource implements CharactersDataStore {
    private CharacterDataBase dataBase;

    public CharactersLocalDataSource(Context context) {
        dataBase = Room.databaseBuilder(context.getApplicationContext(), CharacterDataBase.class, "superhero-db").build();
    }

    @Override
    public void loadCharacters(Page page, LoadCharactersCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }

    @Override
    public void loadCharacter(final String id, final LoadCharactersCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Character character = dataBase.characterDao().loadCharacter(id);
                if (character != null) callback.onSuccess(new Character[]{character});
                else
                    callback.onError(new Error(Error.EMPTY, "Room retrieved nothing from database"));
            }
        });
    }

    @Override
    public void saveCharacters(final Character[] characters, final SaveCharactersCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Long[] success = dataBase.characterDao().saveCharacters(characters);
                if (success != null && success.length > 0) callback.onSuccess();
                else callback.onError(new Error(Error.EMPTY, "Saving characters has failed"));
            }
        });

    }
}
