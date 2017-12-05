import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage implements EmployeesMethods{

    private List<Employee> employeeList;

    public EmployeeStorage(){
        employeeList = new ArrayList<>();
    }

    @Override
    public Employee toAdd(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @Override
    public void toRemove(Employee employee) {
        int index = employeeList.indexOf(employee);
        if (index != -1) employeeList.remove(index);
    }

    @Override
    public Employee toChange(Employee employee, Employee newEmployee) {
        int index = employeeList.indexOf(employee);
        employeeList.set(index,newEmployee);
        return newEmployee;
    }

    @Override
    public Employee toFindEmployee(String surname) {
        for(Employee employee : employeeList){
            if (employee.getSurname().equalsIgnoreCase(surname)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        return list;
    }
}
