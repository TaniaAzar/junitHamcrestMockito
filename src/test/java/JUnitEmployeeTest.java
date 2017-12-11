import org.junit.*;

import java.awt.*;
import static org.mockito.Mockito.*;


public class JUnitEmployeeTest {

    private Employee employees;

    @Before
    public void testSetEmployee(){
        employees = new Employee();
        System.out.println("Before");
    }

    @After
    public void testNullEmployee(){
        employees = null;
        System.out.println("After");
    }

    @Test
    public void testAssertNotNullEmployee(){
        Employee expected = new Employee("Vacia","Ivanov",444);
        Employee actual = new Employee("Vacia","Ivanov",444);

        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);
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
    public void TestEmployeeConstructor(){
        final String name = "Vasia";
        final String surname = "Ivanov";
        final int salary = 400;

        employees = new Employee("Vasia","Ivanov",400);
        Assert.assertEquals(employees.getName(),name);
        Assert.assertEquals(employees.getSurname(),surname);
        Assert.assertEquals(employees.getSalary(),salary);
    }

}
