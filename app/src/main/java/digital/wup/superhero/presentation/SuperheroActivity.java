package digital.wup.superhero.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import digital.wup.superhero.R;
import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.presentation.CharactersContract;

public class SuperheroActivity extends AppCompatActivity implements CharactersContract.CharactersView {

    @Inject
    CharactersContract.CharactersPresenter presenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.takeView(this);
        presenter.loadCharacters();
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showMoreLoadingIndicator() {

    }

    @Override
    public void hideMoreLoadingIndicator() {

    }

    @Override
    public void showCharacters(Character[] characters) {
        recyclerView.setAdapter(new CharacterAdapter(characters));
    }

    @Override
    public void showLoadingCharactersError(String message) {

    }

    @Override
    public void showNoCharacters() {

    }
}
