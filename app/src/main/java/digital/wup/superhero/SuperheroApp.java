package digital.wup.superhero;


import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import digital.wup.superhero.module.DaggerSuperheroComponent;
import digital.wup.superhero.module.SuperheroModule;
import timber.log.Timber;

public class SuperheroApp extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerSuperheroComponent.builder()
                .superheroModule(new SuperheroModule(this))
                .build()
                .inject(this);
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
