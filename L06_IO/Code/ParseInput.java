import java.util.Scanner;

import java.io.*;
import java.util.stream.Collectors;

class ParseInput{
     
    static String inputString1(InputStream inputStream){
     try(Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {            
        String result = s.hasNext() ? s.next() : "";
        return result;
    }
     catch(Exception e){
      return "";
     }

   }

   static String inputString2(InputStream inputStream){
    String result =""; 
     try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
       result = br.lines().collect(Collectors.joining("\n"));
     }
     catch(IOException e){
      return "";
     }
     return result;
   }

    static String inputString3(InputStream inputStream){
     String result;
     try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        result = br.lines().parallel().collect(Collectors.joining("\n"));
     }
     catch(IOException e){
      return "";
     }
     return result;
   }
   
   static String inputString4(InputStream inputStream){
    final int bufferSize = 1024;
    final char[] buffer = new char[bufferSize];
    final StringBuilder out = new StringBuilder();
    try(Reader in = new InputStreamReader(inputStream, "UTF-8")) {
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                 break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }
    catch(IOException e){
      return "";
    }

   }
 

   static String inputString5(InputStream inputStream){
    try(ByteArrayOutputStream result = new ByteArrayOutputStream()) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
    catch(IOException e){
      return "";
    }
  
   }

   public static void main(String[] args){
       PrintStream pr = System.out;

       String r1 = inputString5(System.in);
       pr.println(r1); 

   }


/*

    Используя IOUtils.toString из библиотеки Apache Commons. Один из самых коротких однострочников.

    String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);


    Используя CharStreams из библиотеки guava. Тоже довольно короткий код.

    try(InputStreamReader reader = new InputStreamReader(inputStream, Charsets.UTF_8)) {
        String result = CharStreams.toString(reader);
    }


    Используя StringWriter и IOUtils.copy из Apache Commons

    try(StringWriter writer = new StringWriter()) {
        IOUtils.copy(inputStream, writer, "UTF-8");
        return writer.toString();
    }

*/

}

