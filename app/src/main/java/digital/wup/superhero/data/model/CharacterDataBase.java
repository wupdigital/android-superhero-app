package digital.wup.superhero.data.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Character.class}, version = 1)
public abstract class CharacterDataBase extends RoomDatabase {
    public abstract CharacterDao characterDao();
}
