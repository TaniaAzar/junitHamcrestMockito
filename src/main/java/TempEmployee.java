import java.util.ArrayList;
import java.util.List;

public class TempEmployee {

    private EmployeesStorage storage;

    public TempEmployee(EmployeesStorage storage){
        this.storage = storage;
    }

    public Employee toAdd(Employee employee) {
        List<Employee> list = storage.getAll();
        list.add(employee);
        return employee;
    }

    public Employee toRemove(Employee employee) {
        List<Employee> list = storage.getAll();
        for (int i = 0; i < list.size(); i++) {
            list.remove(employee);
        }
        return null;
    }

    public Employee toChange(Employee employee, Employee newEmployee) {
        List<Employee> list = storage.getAll();
        for (int i = 0; i < list.size(); i++) {
            list.set(list.indexOf(employee),newEmployee);
        }
        return employee;
    }

    public Employee toFindEmployee(String surname) {
        List<Employee> list = storage.getAll();
        for (int i = 0; i < list.size(); i++) {

        }
        return null;
    }
}
