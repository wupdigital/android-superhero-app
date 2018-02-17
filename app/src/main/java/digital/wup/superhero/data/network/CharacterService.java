package digital.wup.superhero.data.network;


import digital.wup.superhero.data.model.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterService {
    @GET("/v1/public/characters")
    Call<CharacterDataWrapper> loadCharacters(@Query("limit") int limit, @Query("offset") int offset);

    @GET("/v1/public/characters/{characterId}")
    Call<CharacterDataWrapper> loadCharacter(@Path("characterId") String id);
}