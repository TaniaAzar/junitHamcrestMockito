import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoEmployeeTest {

    @Test
    public void testToAddEmployee(){
        EmployeesStorage storage = null;
        storage = mock(EmployeesStorage.class);
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Roman","Petrov", 450));

        when(storage.getAll()).thenReturn(list);

        storage.toAdd(new Employee("Vasia","Ivanov",300));
        storage.toAdd(new Employee("Roman","Petrov", 450));

        TempEmployee tempEmployee = new TempEmployee(storage);
        Employee expected = new Employee("Olga","Reort",444);
        Employee actual = tempEmployee.toAdd(new Employee("Olga","Reort",444));

        Assert.assertEquals(expected,actual);
        //проверяем вызов метода
        verify(storage).toAdd(new Employee("Vasia","Ivanov",300));
        //был ли вызван хотя бы один раз
        verify(storage, atLeastOnce()).toAdd(new Employee("Vasia", "Ivanov",300));
        //был вызван ни разу
        verify(storage,never()).toAdd(new Employee("Katia","Ivanova",300));
    }

    @Test
    public void testToRemoveEmployee(){
        EmployeesStorage storage = null;
        storage = mock(EmployeesStorage.class);
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Petia","Petrov", 650));
        list.add(new Employee("Vasia","Ivanov",300));

        when(storage.getAll()).thenReturn(list);

        storage.toRemove(new Employee("Petia","Petrov", 650));
        TempEmployee tempEmployee = new TempEmployee(storage);;
        tempEmployee.toRemove(new Employee("Vasia","Ivanov",300));

        //проверяем вызов метода для удаления
        when(tempEmployee.toRemove(new Employee("Vasia","Ivanov",300))).thenReturn(null);
        //проверяем вызов метода
        verify(storage).toRemove(new Employee("Petia","Petrov", 650));
        verify(storage,atLeastOnce()).toRemove(new Employee("Petia","Petrov", 650));
        verify(storage,never()).toRemove(new Employee("Ekaterina","Ivanova",300));
    }

    @Test
    public void testToChangeEmployee(){
        EmployeesStorage storage = null;
        storage = mock(EmployeesStorage.class);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Ekaterina","Ivanova",300));
        list.add(new Employee("Vasia","Ivanov",300));

        when(storage.getAll()).thenReturn(list);

        Employee expected = new Employee("Ekaterina","Ivanova",300);
        Employee actual = new Employee("Petia","Petrov", 650);
        storage.toChange(expected,actual);

        TempEmployee tempEmployee = new TempEmployee(storage);
        //меняем один объект на другой
        tempEmployee.toChange(expected,actual);

        //проверяем вызов метода
        verify(storage).toChange(expected,actual);
        Assert.assertNotEquals(expected,actual);
        verify(storage,atLeast(1)).toChange(expected,actual);
        verify(storage,never()).toChange(new Employee("Rita","Rogova",20),actual);
    }

    @Test
    public void testToFindEmployee(){
        EmployeesStorage storage = null;
        storage = mock(EmployeesStorage.class);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Ekaterina","Ivanova",300));
        list.add(new Employee("Vasia","Ivanov",500));

        when(storage.getAll()).thenReturn(list);
        for (Employee e : storage.getAll()){
            System.out.println(e);
        }

        storage.toFindEmployee("Vasia");
        TempEmployee tempEmployee = new TempEmployee(storage);
        tempEmployee.toFindEmployee("Vasia");
        for (Employee e : list){
            System.out.println(e);
        }

        when(storage.toFindEmployee("Vasia")).thenReturn(new Employee("Vasia","Ivanov",500));
        verify(storage).toFindEmployee("Vasia");
        verify(storage,never()).toFindEmployee("Sergei");
        verify(storage,atLeastOnce()).toFindEmployee("Vasia");
    }

}
