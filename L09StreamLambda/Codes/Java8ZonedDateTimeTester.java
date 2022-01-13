import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.Instant;

public class Java8ZonedDateTimeTester {
   public static void main(String args[]) {
      Java8ZonedDateTimeTester zonedDateTester = new Java8ZonedDateTimeTester();
      zonedDateTester.testZonedDateTime();
   }
        
   public void testZonedDateTime() {
      // Get the current date and time
      ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Europe/Paris]");
      System.out.println("date1: " + date1);

      LocalDateTime currentTime = LocalDateTime.now();          
      System.out.println("Local date: " + currentTime);
      Instant now = currentTime.atZone(ZoneId.of("Europe/London")).toInstant();
      
      ZoneId id = ZoneId.of("Asia/Tokyo");
      System.out.println("ZoneId: " + id);       
          
      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, id);
      System.out.println("Zoned date: " + zonedDateTime);

      ZoneId currentZone = ZoneId.systemDefault();
      System.out.println("CurrentZone: " + ZonedDateTime.ofInstant(now, currentZone));
   }
}
