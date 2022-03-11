package xh.static_use.static1;

public class Employee {
    private String name;
    private int age;
    private String dept;

    public static String company = "xxx公司";

    public Employee() {
    }

    public Employee(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public void showIfos() {
        System.out.println("name:" + this.name + " age:" + this.age + " dept:" + this.dept + " company:" + company);
    }

    public static int compareByAge(int age1, int age2) {
        return age1 > age2 ? age1 : age2;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }


}
