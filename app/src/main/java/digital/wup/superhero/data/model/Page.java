package digital.wup.superhero.data.model;


public class Page {
    private int limit;
    private int offset;

    public Page() {

    }

    public Page(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public Page withLimitAndOffset(int limit, int offset) {
        return new Page(limit, offset);
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }
}
