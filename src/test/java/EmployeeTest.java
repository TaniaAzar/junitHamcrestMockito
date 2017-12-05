import org.junit.*;

import java.awt.*;


public class EmployeeTest {

    private Employee employee;

    @Before
    public void testSetEmployee(){
        employee = new Employee();
        System.out.println("Before");
    }

    @After
    public void testNullEmployee(){
        employee = null;
        System.out.println("After");
    }

    @Test
    public void testAssertEmployee(){
        Employee expected = new Employee("Vacia","Ivanov",444);
        Employee actual = new Employee("Vacia","Ivanov",444);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestEmployeeNotSame(){
        Employee expected = new Employee("Vacia","Ivanov",444);
        Employee actual = new Employee("Katia","Petrova",344);

        Assert.assertNotSame(expected,actual);
    }


    @Test
    public void testToAddEmployee(){
        EmployeeStorage storage = new EmployeeStorage();
        employee = new Employee("Sonia","Astrea",556);
        storage.toAdd(employee);

        Assert.assertNotNull(storage);
    }

    @Test
    public void testToRemoveEmployee(){
        EmployeeStorage storage = new EmployeeStorage();
        employee = new Employee("Sonia", "Aseeetrea",450);
        storage.toAdd(employee);
        storage.toRemove(employee);

        System.out.println(storage.toString());
        Assert.assertNotNull(storage);
    }



//    @Test
//    public void testAddEmployee(){
//
//        EmployeeApp storage = null;
//        storage = mock(EmployeeApp.class);
//
//        ArrayList<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("GJHGh","cdac",400));
//        employees.add(new Employee("jhjs", "cdfcsd", 111));
//    }
}
