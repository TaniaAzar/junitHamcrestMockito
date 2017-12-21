import java.util.*;

public class EmployeeApp {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Vasisa","Ivanov",300));
        list.add(new Employee("Tania","Azarova",500));

        for (Employee employee : list){
            System.out.println(employee);
        }


    }
}
