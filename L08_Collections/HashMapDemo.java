import java.util.*;  
  
class HashMapDemo {  
  public static void main(String args[]) {  
  
    // Create a hash map. 
    HashMap<String, Double> hm = new HashMap<String, Double>();  
      
    // Put elements to the map  
    hm.put("John Doe", new Double(3434.34));  
    hm.put("Tom Smith", new Double(123.22));  
    hm.put("Jane Baker", new Double(1378.00));  
    hm.put("Tod Hall", new Double(99.22));  
    hm.put("Ralph Smith", new Double(-19.08));  
  
    // Get a set of the entries. 
    Set<Map.Entry<String, Double>> set = hm.entrySet();  
 
    // Display the set. 
    for(Map.Entry<String, Double> me : set) { 
      System.out.print(me.getKey() + ": ");  
      System.out.println(me.getValue());  
    }  
   
    // Display the set and calculate sum. 
    long i = 0;
    Iterator<Map.Entry<Integer, Integer>> it = hm.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<Integer, Integer> pair = it.next();
        i += pair.getKey() + pair.getValue();
      System.out.print(pair.getKey() + ": ");  
      System.out.println(pair.getValue()); 
    }

    // java 8 way:
    final long[] i = {0};
    hm.forEach((k, v) -> i[0] += k + v);
    hm.forEach(System.out::println);

    System.out.println();  
    
     //Java Stream API
    final long[] i = {0};
    hm.entrySet().stream().forEach(e -> i[0] += e.getKey() + e.getValue());
    hm.entrySet().stream().forEach(x ->{System.out::println(x.getKey() + x.getValue() )});
  
    // Deposit 1000 into John Doe's account. 
    double balance = hm.get("John Doe");  
    hm.put("John Doe", balance + 1000);  
 
    System.out.println("John Doe's new balance: " +  
      hm.get("John Doe"));  
  }  
}

