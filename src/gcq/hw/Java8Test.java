package gcq.hw;

public class Java8Test {
	
    public static void main(String args[]) {
    	Java8Test tester = new Java8Test();
    	
    	MathOperation addition = (int a,int b)->a+b;
    	
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = ( int a, int  b) -> a / b;

        
//        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));

        
//        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        
//        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        
//        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        
          GreetingService greetService1 = message ->  System.out.println("Hello " + message);

          GreetingService greetService2 = (message) ->  System.out.println("Hello " + message);


          greetService1.sayMessage("Runoob");
          greetService2.sayMessage("Google");


    }

    
    interface MathOperation{
    	int operation(int a,int b);
    }
    
    private int operate(int a,int b,MathOperation mathOperation) {
    	return mathOperation.operation(a, b);
    }
    
    interface GreetingService{
    	void sayMessage(String message);
    }
}
