import java.util.List;
import java.util.ArrayList;
import java.util.Arrays.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.*;

class Book{
  List<String> authors;
  String title;
  int year;

  public Book(String s, int year, List<String> authors){
    title = s;
    this.year =year;
    this.authors = authors; 
  }

  public List<String> getAuthors(){
     return authors;
   }
}


class Department {
    String name, code;
    List<Employee> employees;

    Department(String name, String  code, List<Employee> employees){
       this.name = name;
       this.code = code;
       this.employees = employees;
   }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}

class Employee {
    String name;
    Long salary;

    Employee( String name, int salary){
       this.name = name;
       this.salary = (long) salary;
    }     

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }
}

class Departments{

/**
 * Calculates the number of employees with salary >= threshold (only for 111- departments)
 *
 * @param departments are list of departments
 * @param threshold is lower edge of salary
 *
 * @return the number of employees
 */
public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
   // list of names
 final List<Employee> authors = departments.stream()
        .filter(x->x.getCode().startsWith("111-"))
        .flatMap(x -> x.getEmployees().stream())
        .filter(y->y.getSalary()>=threshold)
        .collect(Collectors.toList());

  for(Employee x: authors){
      System.out.println(x.getName());
  }
      
      return departments.stream()
        .filter(x->x.getCode().startsWith("111-"))
        .flatMap(x -> x.getEmployees().stream())
        .filter(y->y.getSalary()>=threshold)
        .count();

}

  public static void main(String[] args){

// the collection of java books
final List<Book> javaBooks = Stream.of(new Book("Java EE 7 Essentials", 2013, Arrays.asList("Arun Gupta")),
  new Book("Algorithms", 2011, Arrays.asList("Robert Sedgewick", "Kevin Wayne")),
new Book("Clean code", 2014, Arrays.asList("Robert Martin"))).collect(Collectors.toList());

// list of authors
final List<String> authors = javaBooks.stream().flatMap(book -> book.getAuthors().stream()).distinct().collect(Collectors.toList());

  for(String x: authors){
      System.out.println(x);
  }

ArrayList <Department> arDep = new ArrayList<>();

 arDep.add(new Department("Town", "111-242",  new ArrayList<Employee>()));
 arDep.add(new Department("Village", "111-2422",  new ArrayList<Employee>()));
 arDep.add(new Department("Fake", "5111-242",  new ArrayList<Employee>()));
 arDep.add(new Department("Authority", "111",  new ArrayList<Employee>()));

arDep.get(0).getEmployees().add(new Employee("Fedor", 15000));
arDep.get(0).getEmployees().add(new Employee("Lev", 22000));
arDep.get(0).getEmployees().add(new Employee("Oksana", 35000));
arDep.get(1).getEmployees().add(new Employee("Ursula", 25000));
arDep.get(1).getEmployees().add(new Employee("Bayan", 33000));
arDep.get(1).getEmployees().add(new Employee("Fedorina", 32000));
arDep.get(2).getEmployees().add(new Employee("Vasiliy", 29000));
arDep.get(2).getEmployees().add(new Employee("Gennady", 28000));
arDep.get(2).getEmployees().add(new Employee("Sergey", 29000));
arDep.get(3).getEmployees().add(new Employee("Vladimir", 249000));
arDep.get(3).getEmployees().add(new Employee("Michael", 128000));
arDep.get(3).getEmployees().add(new Employee("Valentina", 329000));
System.out.println(calcNumberOfEmployees(arDep, 33000));

}

}
