package xh.app.stream;

public class Topperformer {
    private String name;
    private double money;

    public Topperformer() {
    }

    public Topperformer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topperformer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
