package az.turing.inventory;

public class Armor {
    private Integer id;
    private String kind;
    private Integer blocke;
    private Integer price;

    public Armor(Integer id, String kind, Integer blocke, Integer price) {
        this.id = id;
        this.kind = kind;
        this.blocke = blocke;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getBlocke() {
        return blocke;
    }

    public void setBlocke(Integer blocke) {
        this.blocke = blocke;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", blocke=" + blocke +
                ", price=" + price +
                '}';
    }
}
