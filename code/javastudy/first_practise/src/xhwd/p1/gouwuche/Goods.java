package xhwd.p1.gouwuche;

public class Goods {
    private int id;
    private String name;
    private double price;
    private int number;

    public Goods() {

    }

    public Goods(int id, String name, double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
