import java.util.List;

public class EmployeeImportance {

static class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
    static class Solution {
        public int getImportance(List<Employee> employees, int id) {
            if(employees ==null || employees.size() == 0){
                return 0;
            }

            Employee e = getEmployee(employees,id);
            return getValue(employees,e.id);

        }

        public int getValue(List<Employee> employees, int id){
            Employee employee = getEmployee(employees,id);
            if(employee.subordinates ==null){
                return employee.importance;
            }
            int sum = employee.importance;
            for(int i: employee.subordinates){
                sum += getValue(employees,i);
            }

            return sum;
        }

        public Employee getEmployee(List<Employee> employees, int id){
            int low = 0, high =employees.size()-1;

            while(low != high){
                if(employees.get(low).id != id){
                    low ++;
                }else{
                    return employees.get(low);
                }

                if(employees.get(high).id != id){
                    high --;
                }else{
                    return employees.get(high);
                }
            }

            return employees.get(low);
        }
    }
}
