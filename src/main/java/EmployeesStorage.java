import java.util.ArrayList;
import java.util.List;

public interface EmployeesStorage {

    void toAdd(Employee employee);
    Employee toRemove(Employee employee);
    void toChange(Employee employee, Employee newEmployee);
    Employee toFindEmployee(String surname);

    List<Employee> getAll();
}
