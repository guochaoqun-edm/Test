package gcq.hw;

public class Java8Tester {
    public static void main(String args[]) {
        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
//        num = 5;
    }
    public interface Converter<T1, T2> {
        void convert(int i);
    }


}
