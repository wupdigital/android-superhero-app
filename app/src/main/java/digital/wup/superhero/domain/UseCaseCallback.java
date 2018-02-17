package digital.wup.superhero.domain;

import digital.wup.superhero.data.model.Error;

public interface UseCaseCallback<Rs> {
    void onSuccess(Rs response);

    void onError(Error error);
}
