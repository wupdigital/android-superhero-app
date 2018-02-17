package digital.wup.superhero.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import digital.wup.superhero.data.CharactersDataStore;
import digital.wup.superhero.data.CharactersLocalDataSource;
import digital.wup.superhero.data.CharactersRemoteDataStore;
import digital.wup.superhero.data.CharactersRepository;
import digital.wup.superhero.domain.UseCaseHandler;
import digital.wup.superhero.domain.UseCaseScheduler;
import digital.wup.superhero.domain.UseCaseThreadPoolScheduler;
import digital.wup.superhero.domain.usecase.GetCharacterUseCase;
import digital.wup.superhero.domain.usecase.GetCharactersUseCase;
import digital.wup.superhero.presentation.ui.characters.CharacatersPresenterImpl;
import digital.wup.superhero.presentation.ui.characters.CharactersContract;
import digital.wup.superhero.presentation.ui.details.DetailsContract;
import digital.wup.superhero.presentation.ui.details.DetailsPresenterImpl;

@Module
public class SuperheroModule {

    private final Context applicationContext;

    public SuperheroModule(Context context) {
        applicationContext = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return applicationContext;
    }

    @Singleton
    @Provides
    public CharactersLocalDataSource providCharactersLocalDataSource(Context context) {
        return new CharactersLocalDataSource(context);
    }

    @Singleton
    @Provides
    public CharactersRemoteDataStore providCharactersRemoteDataStore() {
        return new CharactersRemoteDataStore();
    }

    @Singleton
    @Provides
    public CharactersDataStore providCharactersDataStore(CharactersRemoteDataStore remoteDataStore, CharactersLocalDataSource localDataSource) {
        return new CharactersRepository(remoteDataStore, localDataSource);
    }

    @Singleton
    @Provides
    public GetCharactersUseCase providGetCharactersUseCase(CharactersDataStore charactersDataStore) {
        return new GetCharactersUseCase(charactersDataStore);
    }

    @Singleton
    @Provides
    public UseCaseScheduler provideUseCaseScheduler() {
        return new UseCaseThreadPoolScheduler();
    }

    @Singleton
    @Provides
    public UseCaseHandler provideUseCaseHandler(UseCaseScheduler useCaseScheduler) {
        return new UseCaseHandler(useCaseScheduler);
    }

    @Singleton
    @Provides
    public CharactersContract.CharactersPresenter provideCharactersPresenter(GetCharactersUseCase useCase, UseCaseHandler useCaseHandler) {
        return new CharacatersPresenterImpl(useCase, useCaseHandler);
    }

    @Singleton
    @Provides
    public GetCharacterUseCase provideGetCharacterUseCase(CharactersDataStore dataStore) {
        return new GetCharacterUseCase(dataStore);
    }

    @Singleton
    @Provides
    public DetailsContract.DetailsPresenter provideDetailsPresenter(GetCharacterUseCase useCase, UseCaseHandler useCaseHandler) {
        return new DetailsPresenterImpl(useCase, useCaseHandler);
    }
}
