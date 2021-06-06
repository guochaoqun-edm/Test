package gcq.hw;

import java.util.Arrays;
import java.util.List;

public class CarN {
    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }
 
    //Supplier��jdk1.8�Ľӿڣ������lamdaһ��ʹ����
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
        //���������ã������﷨��Class::new�����߸�һ���Class< T >::newʵ�����£�
         CarN car  = CarN.create(CarN::new);
         CarN car1 = CarN.create(CarN::new);
         CarN car2 = CarN.create(CarN::new);
         CarN car3 = new CarN();
        List<CarN> cars = Arrays.asList(car,car1,car2,car3);
        System.out.println("===================����������========================");
        //��̬�������ã������﷨��Class::static_method��ʵ�����£�
        cars.forEach(CarN::collide);
        System.out.println("===================��̬��������========================");
        //�ض�����������ķ������ã������﷨��Class::methodʵ�����£�
        cars.forEach(CarN::repair);
        System.out.println("==============�ض�����������ķ�������================");
        //�ض�����ķ������ã������﷨��instance::methodʵ�����£�
        final CarN police = CarN.create(CarN::new);
        cars.forEach(police::follow);
        System.out.println("===================�ض�����ķ�������===================");
 
    }


}
