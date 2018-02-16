package digital.wup.superhero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import digital.wup.superhero.data.CharactersDataStore;
import digital.wup.superhero.data.CharactersLocalDataSource;
import digital.wup.superhero.data.CharactersRemoteDataStore;
import digital.wup.superhero.data.CharactersRepository;
import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.data.model.Error;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharactersRemoteDataStore remoteDataStore = new CharactersRemoteDataStore();
        CharactersLocalDataSource localDataSource = new CharactersLocalDataSource(this);

        CharactersRepository repository = new CharactersRepository(remoteDataStore, localDataSource);
        repository.loadCharacters(null, new CharactersDataStore.LoadCharactersCallback() {
            @Override
            public void onSuccess(Character[] characters) {
                Timber.d(characters[0].toString());
            }

            @Override
            public void onError(Error error) {

            }
        });
    }
}
