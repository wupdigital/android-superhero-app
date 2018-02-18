package digital.wup.superhero.data;


import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.CharacterDataWrapper;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;
import digital.wup.superhero.data.network.CharacterService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharactersRemoteDataStore implements CharactersDataStore {
    private CharacterService service;

    public CharactersRemoteDataStore(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        service = retrofit.create(CharacterService.class);
    }

    @Override
    public void loadCharacters(Page page, final LoadCharactersCallback callback) {
        service.loadCharacters(page.getLimit(), page.getOffset()).enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                if (response.body() != null)
                    callback.onSuccess(response.body().getData().getResults());
                else
                    callback.onError(new Error());
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                callback.onError(new Error());
            }
        });
    }

    @Override
    public void loadCharacter(String id, final LoadCharactersCallback callback) {
        service.loadCharacter(id).enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                if (response.body() != null)
                    callback.onSuccess(response.body().getData().getResults());
                else callback.onError(new Error());
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                callback.onError(new Error());
            }
        });
    }

    @Override
    public void saveCharacters(Character[] characters, SaveCharactersCallback callback) {
        throw new UnsupportedOperationException("Method not implemented!");
    }
}
