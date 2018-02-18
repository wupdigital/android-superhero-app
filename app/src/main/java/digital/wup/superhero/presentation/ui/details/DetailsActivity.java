package digital.wup.superhero.presentation.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import digital.wup.superhero.R;
import digital.wup.superhero.data.model.Character;
import digital.wup.superhero.presentation.Navigation;
import timber.log.Timber;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.DetailsView {

    @Inject
    DetailsContract.DetailsPresenter presenter;
    @Inject
    Picasso picasso;

    private TextView nameTextView;
    private ImageView thumbnailImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameTextView = findViewById(R.id.name);
        thumbnailImageView = findViewById(R.id.thumbnail);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Navigation.EXTRA);

        presenter.takeView(this);
        presenter.loadCharacter(bundle.getString(Navigation.CHARACTER_ID));
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showCharacter(Character characters) {
        nameTextView.setText(characters.getName());

        picasso.load(characters.getThumbnail().getPath() + "." + characters.getThumbnail().getExtension()).into(thumbnailImageView);
    }

    @Override
    public void showLoadingCharacterError(String message) {

    }

    @Override
    public void showNoCharacter() {

    }
}
