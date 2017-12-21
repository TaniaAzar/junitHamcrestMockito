import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HamcrestEmployeeTest{

    private ArrayList<Employee> employees;

    @Before
    public void testBefore(){
        employees = new ArrayList<>();
    }

    @After
    public void testAfter(){
        employees = null;
    }

    @Test
    public void testEqualsEmployee(){
        Employee expected = new Employee("Sergei","Ivanov",444);
        Employee actual = new Employee("Sergei","Ivanov",444);
        assertThat(expected,equalTo(actual));
    }

    @Test
    public void testSameInstanceEmployee(){
        Employee actual = new Employee("Sergei","Ivanov",444);
        assertThat(actual,notNullValue());
    }

    @Test
    public void testHasItemsEmployee(){
        employees.add(new Employee("Rai", "Reawa", 500));
        employees.add(new Employee("Sveta", "Reawa", 440));
        Employee actual = new Employee("Sveta", "Reawa", 440);
        assertThat(employees, hasItems(actual));
    }


    @Test
    public void testSizeEmployee(){
        employees.add(new Employee("Rai", "Reawa", 500));
        employees.add(new Employee("Sveta", "Reawa", 440));
        assertThat(employees, hasSize(2));
    }

    @Test
    public void testNotEqualsEmployee(){
        employees.add(new Employee("Rai", "Reawa", 500));
        employees.add(new Employee("Sveta", "Reawa", 440));
        Employee actual = new Employee("Sergei","Ivanov",444);
        assertThat(employees, not(equalTo(actual)));
    }

    @Test
    public void testAnyOfEmployee(){
        employees.add(new Employee("Rai", "Reawa", 500));
        employees.add(new Employee("Sveta", "Reawa", 440));
        Employee actual = new Employee("Rai", "Reawa", 500);
        assertThat(employees, anyOf(notNullValue(),equalTo(actual)));
    }

    @Test
    public void testWriteSpaceEmployee(){
        employees.add(new Employee("Rai", "Reawa", 500));
        String surname = "REAWA";
        String surnameTwo = "R eawa";
        String employeeSurname = "";
        for (Employee employee : employees){
             employeeSurname = employee.getSurname();
        }
        assertThat(employeeSurname, equalToIgnoringCase(surname));
    }
}
