package digital.wup.superhero.domain;

import digital.wup.superhero.data.model.Error;

public interface UseCaseScheduler {
    void execute(Runnable runnable);

    <Rs extends Response> void notifyResponse(Rs response, UseCaseCallback<Rs> callback);

    <Rs extends Response> void onError(Error error, UseCaseCallback<Rs> callback);
}
