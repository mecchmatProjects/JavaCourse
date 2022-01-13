import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

class LogEntry{
   Date created;
   String login;
   String url;
   LogEntry(){}
   LogEntry( Date created,String login, String url){
     this.created = created;
     this.login = login;
     this.url = url;
   } 

   String getUrl(){
     return url;
   }

   String getLogin(){
     return login;
   }

   Date getCreated(){
     return created;
   }
   

}


public class TestLogEntry {

    static Map<String, Long> clickCount(List<LogEntry> logs){
        Map<String, Long> clickCount =
                logs.stream()
                 .collect( 
                  Collectors.groupingBy( l-> l.getUrl(), Collectors.counting())
                 ); 
 //Collectors.toMap(LogEntry::getUrl, c -> Long.valueOf(1), (a, b) -> a + 1)


        return clickCount;
    }

    public static void main(String[] args) {
        List<LogEntry> logs = new Vector<>();
        logs.add(new LogEntry(new Date(), "Khrusha", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Khrusha", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Karkusha", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stepik.org"));
        logs.add(new LogEntry(new Date(), "Khrusha", "github.com"));
        logs.add(new LogEntry(new Date(), "Karkusha", "github.com"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
        logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
        for(Map.Entry <String, Long> entry: clickCount(logs).entrySet()){
            System.out.println(entry.toString());
        }
    }
}
/*
MUST BE OUTPUT:

stackoverflow.com=3
github.com=2
stepik.org=4*/
