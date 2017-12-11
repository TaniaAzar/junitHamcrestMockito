import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MockitoEmployeeTest {

    private Employee employees;
    EmployeesStorage storage = null;
    TempEmployee tempEmployee;

    @Before
    public void testSetEmployee(){
        employees = new Employee("Vasia","Ivanov",300);
        storage = mock(EmployeesStorage.class);
        tempEmployee = new TempEmployee(storage);
        System.out.println("Before");
    }

    @After
    public void testNullEmployee(){
        employees = null;
        System.out.println("After");
    }

    @Test
    public void testToAddEmployee(){
        storage.toAdd(employees);
        tempEmployee.toAdd(new Employee("Vasia","Ivanov",300));

        //проверяем вызов метода
        verify(storage).toAdd(new Employee("Vasia","Ivanov",300));
        //был ли вызван хотя бы один раз
        verify(storage, atLeastOnce()).toAdd(new Employee("Vasia", "Ivanov",300));
        //был вызван ни разу
        verify(storage,never()).toAdd(new Employee("Katia","Ivanova",300));
    }

    @Test
    public void testToRemoveEmployee(){
        tempEmployee.toRemove(new Employee("Vasia","Ivanov",300));
        storage.toRemove(new Employee("Vasia","Ivanov",300));

        when(tempEmployee.toRemove(new Employee("Vasia","Ivanov",300))).thenReturn(null);

        verify(storage).toRemove(new Employee("Vasia","Ivanov",300));
        verify(storage,atLeastOnce()).toRemove(new Employee("Vasia","Ivanov",300));
        verify(storage,never()).toRemove(new Employee("Ekaterina","Ivanova",300));
    }

    @Test
    public void testToChangeEmployee(){
        Employee expected = new Employee("Vasia","Ivanov",300);
        Employee actual = new Employee("Ekaterina","Ivanova",300);
        System.out.println(expected.toString());
        System.out.println(actual.toString());

        tempEmployee.toChange(expected,actual);
        storage.toChange(expected,actual);

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void testToFindEmployee(){

    }

}
