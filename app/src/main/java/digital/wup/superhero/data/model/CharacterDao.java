package digital.wup.superhero.data.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface CharacterDao {

    @Query("SELECT * FROM character")
    Character[] loadCharacters();

    @Query("SELECT * FROM character WHERE ID IN (:id)")
    Character loadCharacter(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] saveCharacters(Character[] characters);
}
