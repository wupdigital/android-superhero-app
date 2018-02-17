package digital.wup.superhero.data;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.CharacterDataContainer;
import digital.wup.superhero.data.model.CharacterDataWrapper;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;
import digital.wup.superhero.data.network.CharacterService;
import digital.wup.superhero.data.network.NetworkInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class CharactersRemoteDataStore implements CharactersDataStore {
    private CharacterService service;

    public CharactersRemoteDataStore() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new NetworkInterceptor())
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .callbackExecutor(Executors.newSingleThreadExecutor())
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
                    callback.onError(new Error(Error.EMPTY, "response body empty"));
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                callback.onError(new Error(Error.EMPTY, "failed to load characters"));
                Timber.e(t);
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
                else
                    callback.onError(new Error(Error.EMPTY, "response body empty"));
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
