package digital.wup.superhero.data.network;


import java.io.IOException;
import java.util.Calendar;

import digital.wup.superhero.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {
    private static final String TS = "ts";
    private static final String API_KEY = "apikey";
    private static final String HASH = "hash";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        String ts = String.valueOf(Calendar.getInstance().getTime().getTime());
        String apikey = BuildConfig.PUB_API_KEY;
        String hashInput = ts + BuildConfig.PRIV_API_KEY + BuildConfig.PUB_API_KEY;

        HttpUrl httpUrl = originalRequest.url().newBuilder()
                .addQueryParameter(TS, ts)
                .addQueryParameter(API_KEY, apikey)
                .addQueryParameter(HASH, NetworkUtil.md5(hashInput)).build();

        Request.Builder builder = originalRequest.newBuilder().url(httpUrl);
        Request newRequest = builder.build();

        return chain.proceed(newRequest);
    }
}
