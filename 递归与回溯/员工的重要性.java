public class 员工的重要性 {
    static   class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates){
            this.id = id; this.importance = importance; this.subordinates = subordinates;
        }
    };


    static  class Solution {
        public int getImportance(List<Employee> employees, int id) {
            return helper(employees, id);
        }

        private int helper(List<Employee> employees, int id){
            int sum = 0;
            // 假设员工的id是按照
            Employee cur = get(employees, id);
            sum += cur.importance;
            for (int sub : cur.subordinates){
                sum += helper(employees, sub);
            }
            return sum;
        }

        private Employee get(List<Employee> employees, int id){
            for (Employee employee:employees)
                if(employee.id == id) return employee;
            return null;
        }
    }
}