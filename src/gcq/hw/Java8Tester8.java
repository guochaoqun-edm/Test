package gcq.hw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Java8Tester8 {
	
    public static void main(String args[]) {
    	
    	Java8Tester8 java8tester8 = new Java8Tester8();

    	java8tester8.testLocalDateTime();
    	
    	
    	
    }
    
    public void testLocalDateTime() {
    	
    	
//    	LocalDateTime currentTime = LocalDateTime.now();
//    	
//    	System.out.println("当前时间: " + currentTime);
//
//    	
//    	LocalDate date1 = currentTime.toLocalDate();
//    	
//    	System.out.println("date1:  "+date1);
//    	
//    	Month month = currentTime.getMonth();
//    	int day = currentTime.getDayOfMonth();
//    	int seconds = currentTime.getSecond();
//    	
//        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);
//
//    	LocalDateTime date2 =currentTime.withDayOfMonth(10).withYear(2012);
//    	
//        System.out.println("date2: " + date2);
//        
//        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
//        System.out.println("date3: " + date3);
//        
//        LocalTime date4 = LocalTime.of(22, 15);
//        System.out.println("date4: " + date4);
//
//
//        LocalTime date5 = LocalTime.parse("20:15:30");
//
//        System.out.println("date5: " + date5);
    	
    	ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault();
        
        System.out.println("当期时区: " + currentZone);


    }
    

}
