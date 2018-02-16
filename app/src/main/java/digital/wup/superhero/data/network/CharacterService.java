package digital.wup.superhero.data.network;


import digital.wup.superhero.data.model.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterService {
    @GET("/v1/public/characters")
    Call<CharacterDataWrapper> loadCharacters();
}
