package springpuzzles.rollback.domain;

/**
 * @author: ecamacho
 * javahispano 2010
 */
public class Account {

    String id;

    Double savings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }
}
