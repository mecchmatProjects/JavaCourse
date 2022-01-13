import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class Java8DateTester {
   public static void main(String args[]) {
      Java8DateTester dateTester = new Java8DateTester();
      dateTester.testLocalDateTime();
   }
        
   public void testLocalDateTime() {
      // поточний час - повна форма
      LocalDateTime currentTime = LocalDateTime.now();
      System.out.println("Current DateTime: " + currentTime);
      // поточний час - лише дата          
      LocalDate date1 = currentTime.toLocalDate();
      System.out.println("now date: " + date1);
       // отримання компонент дати - стандартний запис          
      Month month = currentTime.getMonth();
      int day = currentTime.getDayOfMonth();
      int seconds = currentTime.getSecond();
      System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);
       // зміна дати -10-2022        
      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2022);
      System.out.println("date2: " + date2);
                
      //31 december 2021
      LocalDate date3 = LocalDate.of(2021, Month.DECEMBER, 31);
      System.out.println("new year: " + date3);
                
      //Встановлення часу 23 hour 25 minutes
      LocalTime date4 = LocalTime.of(22, 15);
      System.out.println("час: " + date4);
                
      //Введення по рядку parse a string
      LocalTime date5 = LocalTime.parse("14:25:37");
      System.out.println("час: " + date5);
   }
} 
