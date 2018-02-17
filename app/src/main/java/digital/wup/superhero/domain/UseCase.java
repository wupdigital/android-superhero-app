package digital.wup.superhero.domain;

public abstract class UseCase<Rq extends Request, Rs extends Response> {
    protected Rq request;
    protected UseCaseCallback<Rs> useCaseCallback;

    public final void run() {
        this.executeUseCase(request);
    }

    protected abstract void executeUseCase(Rq request);

    public Rq getRequest() {
        return request;
    }

    public void setRequest(Rq request) {
        this.request = request;
    }

    public UseCaseCallback<Rs> getUseCaseCallback() {
        return useCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<Rs> useCaseCallback) {
        this.useCaseCallback = useCaseCallback;
    }
}
