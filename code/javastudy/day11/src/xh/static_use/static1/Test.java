package xh.static_use.static1;

public class Test {

    public static void main(String[] args) {
        Employee e1=new Employee("赵三",33,"销售");
        Employee e2=new Employee("李四",45,"进购");
        e1.showIfos();
        e2.showIfos();


        int maxage = Employee.compareByAge(e1.getAge(), e2.getAge());
        System.out.println(maxage);
    }
}
