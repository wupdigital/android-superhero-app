package digital.wup.superhero.data;


import java.io.IOException;
import java.util.concurrent.Executors;

import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.CharacterDataWrapper;
import digital.wup.superhero.data.model.Error;
import digital.wup.superhero.data.model.Page;
import digital.wup.superhero.data.network.CharacterService;
import digital.wup.superhero.data.network.NetworkInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
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
                .build();

        service = retrofit.create(CharacterService.class);
    }

    @Override
    public void loadCharacters(Page page, final LoadCharactersCallback callback) {
        try {
            Response<CharacterDataWrapper> response = service.loadCharacters(page.getLimit(), page.getOffset()).execute();

            if (response.body() != null) {
                callback.onSuccess(response.body().getData().getResults());
            } else {
                callback.onError(new Error(Error.EMPTY, "response body empty"));
            }
        } catch (HttpException | IOException e) {
            Timber.e(e);
            callback.onError(new Error(Error.EMPTY, "failed to load characters"));
        }
    }

    @Override
    public void loadCharacter(String id, final LoadCharactersCallback callback) {
        try {
             Response<CharacterDataWrapper> response = service.loadCharacter(id).execute();
            if (response.body() != null) {
                callback.onSuccess(response.body().getData().getResults());
            }
            else {
                callback.onError(new Error(Error.EMPTY, "response body empty"));
            }
        } catch (HttpException | IOException e) {
            Timber.e(e);
            callback.onError(new Error());
        }
    }

    @Override
    public void saveCharacters(Character[] characters, SaveCharactersCallback callback) {
        throw new UnsupportedOperationException("Method not implemented!");
    }
}
