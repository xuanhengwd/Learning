package xh.app.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo3 {
    private static double sum1 = 0;
    private static double sum2 = 0;

    public static void main(String[] args) {

        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒",'男',30000 , 25000, null));
        one.add(new Employee("孙悟空",'男',25000 , 1000, "顶撞上司"));
        one.add(new Employee("沙僧",'男',20000 , 20000, null));
        one.add(new Employee("小白龙",'男',20000 , 25000, null));

        List<Employee> two = new ArrayList<>();
        two.add(new Employee("武松",'男',15000 , 9000, null));
        two.add(new Employee("李逵",'男',20000 , 10000, null));
        two.add(new Employee("西门庆",'男',50000 , 100000, "被打"));
        two.add(new Employee("潘金莲",'女',3500 , 1000, "被打"));
        two.add(new Employee("武大郎",'女',20000 , 0, "下毒"));

        //第一个部门最高工资的员工
        Topperformer t1 = one.stream().max((o1, o2) -> Double.compare(o1.getSalary() + o1.getBonus(), o2.getSalary() + o2.getBonus()))
                .map(e -> new Topperformer(e.getName(), e.getSalary() + e.getBonus())).get();
        System.out.println(t1);

        //第二个部门最高工资
        Topperformer t2 = two.stream().max((o1, o2) -> Double.compare(o1.getSalary() + o1.getBonus(), o2.getSalary() + o2.getBonus()))
                .map(e -> new Topperformer(e.getName(), e.getSalary() + e.getBonus())).get();
        System.out.println(t2);

        //部门1平均月收入
        one.stream().sorted((Comparator.comparingDouble(o -> o.getSalary() + o.getBonus())))
                .skip(1).limit(one.size()-2).forEach(e -> sum1+=(e.getSalary()+e.getBonus()));
        System.out.println("一部的平均工资是："+sum1/(one.size()-2));

        Stream<Employee> s1 = one.stream();
        Stream<Employee> s2 = two.stream();
        Stream<Employee> s3 = Stream.concat(s1, s2);
        s3.sorted((o1, o2) -> Double.compare(o1.getSalary()+o1.getBonus(),o2.getSalary()+o2.getBonus()))
                .skip(1).limit(one.size()+two.size()-2).forEach(e -> sum2+=(e.getBonus()+e.getSalary()));


        BigDecimal sum =BigDecimal.valueOf(sum2);
        BigDecimal count = BigDecimal.valueOf(one.size()+two.size()-2);
        BigDecimal res = sum.divide(count, 2, RoundingMode.HALF_UP);
        double v = res.doubleValue();
        System.out.println(v);

    }
}
