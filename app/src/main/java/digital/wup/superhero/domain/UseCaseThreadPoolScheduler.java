package digital.wup.superhero.domain;


import android.os.AsyncTask;
import android.os.Handler;
import android.renderscript.RenderScript;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import digital.wup.superhero.data.model.Error;

public class UseCaseThreadPoolScheduler implements UseCaseScheduler {

    private final Handler mHandler = new Handler();

    public static final int POOL_SIZE = 2;

    public static final int MAX_POOL_SIZE = 4;

    public static final int TIMEOUT = 30;

    ThreadPoolExecutor mThreadPoolExecutor;

    public UseCaseThreadPoolScheduler() {
        mThreadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIMEOUT,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(POOL_SIZE));
    }

    @Override
    public void execute(final Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    @Override
    public <Rs extends Response> void notifyResponse(final Rs response, final UseCaseCallback<Rs> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response);
            }
        });
    }

    @Override
    public <Rs extends Response> void onError(final Error error, final UseCaseCallback<Rs> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(error);
            }
        });
    }
}
