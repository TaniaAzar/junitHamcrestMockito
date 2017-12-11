import java.util.*;

public class EmployeeApp {

    public static void main(String[] args) {

//        Map<Integer,Employee> map = new HashMap<Integer, Employee>();
//        map.put(1,new Employee("Vaca","Ivanov",300));
//        map.put(2,new Employee("Tania","Azarova",500));
//        map.put(3,new Employee("Lena","Petrova",600));
//
//        for (Map.Entry<Integer,Employee> item : map.entrySet()){
//            System.out.println(item.toString());
//        }
//        //набор ключей
//        Set<Integer> keys = map.keySet();
//        System.out.println(keys);
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Vaca","Ivanov",300));
        list.add(new Employee("Tania","Azarova",500));


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }



    }
}
