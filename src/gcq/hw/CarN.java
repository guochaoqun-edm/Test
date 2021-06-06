package gcq.hw;

import java.util.Arrays;
import java.util.List;

public class CarN {
    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }
 
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static CarN create(final Supplier<CarN> supplier) {
        return supplier.get();
    }
 
    public static void collide(final CarN car) {
        System.out.println("Collided " + car.toString());
    }
 
    public void follow(final CarN another) {
        System.out.println("Following the " + another.toString());
    }
 
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
 
    public static void main(String[] args) {
        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
         CarN car  = CarN.create(CarN::new);
         CarN car1 = CarN.create(CarN::new);
         CarN car2 = CarN.create(CarN::new);
         CarN car3 = new CarN();
        List<CarN> cars = Arrays.asList(car,car1,car2,car3);
        System.out.println("===================构造器引用========================");
        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(CarN::collide);
        System.out.println("===================静态方法引用========================");
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(CarN::repair);
        System.out.println("==============特定类的任意对象的方法引用================");
        //特定对象的方法引用：它的语法是instance::method实例如下：
        final CarN police = CarN.create(CarN::new);
        cars.forEach(police::follow);
        System.out.println("===================特定对象的方法引用===================");
 
    }


}
