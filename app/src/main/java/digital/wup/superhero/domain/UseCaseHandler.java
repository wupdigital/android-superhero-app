package digital.wup.superhero.domain;

import digital.wup.superhero.data.model.Error;

public class UseCaseHandler {
    private UseCaseScheduler useCaseScheduler;

    public UseCaseHandler(UseCaseScheduler useCaseScheduler) {
        this.useCaseScheduler = useCaseScheduler;
    }

    public <Rq extends Request, Rs extends Response> void execute(final UseCase<Rq, Rs> useCase, Rq request, UseCaseCallback<Rs> callback) {
        useCase.setRequest(request);
        useCase.setUseCaseCallback(callback);
        useCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    public <Rs extends Response> void notifyResponse(Rs response, UseCaseCallback<Rs> useCaseCallback) {
        useCaseScheduler.notifyResponse(response, useCaseCallback);
    }

    public <Rs extends Response> void notifyError(Error error, UseCaseCallback<Rs> useCaseCallback) {
        useCaseScheduler.onError(error, useCaseCallback);
    }
}
