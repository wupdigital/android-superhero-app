package digital.wup.superhero.domain.usecase;


import digital.wup.superhero.data.model.Page;
import digital.wup.superhero.domain.Request;

public class GetCharactersRequest implements Request {
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
