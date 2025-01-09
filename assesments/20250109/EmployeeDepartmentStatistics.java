import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeDepartmentStatistics {


        public Map<String, DepartmentStats> analyzeDepartments(List<Employee> employees) {
            return employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment)) // Grouping employees by department
                    .entrySet().stream()
                    .filter(entry -> entry.getValue().size() > 2) // Filtering departments with more than 2 employees
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, // Added department name as key
                            entry -> {
                                List<Employee> deptEmployees = entry.getValue();
                                double averageSalary = deptEmployees.stream()
                                        .collect(Collectors.averagingDouble(Employee::getSalary)); // Calculating the average salary
                                long employeeCount = deptEmployees.size(); // Count employees
                                Set<String> uniqueSkills = deptEmployees.stream()
                                        .flatMap(employee -> employee.getSkills().stream()) // Flattened the skills into a single stream
                                        .collect(Collectors.toSet()); // Collecting unique skills
                                return new DepartmentStats(averageSalary, employeeCount, uniqueSkills); // Created DepartmentStats object
                            }
                    ));
        }

        public static void main(String[] args) {
            EmployeeDepartmentStatistics processor = new EmployeeDepartmentStatistics();
            List<Employee> employees = Arrays.asList(
                    new Employee("John", "IT", 75000, Arrays.asList("Java", "SQL")),
                    new Employee("Alice", "IT", 82000, Arrays.asList("Python", "Java")),
                    new Employee("Bob", "HR", 65000, Arrays.asList("Communication")),
                    new Employee("Charlie", "IT", 78000, Arrays.asList("Java", "AWS"))
            );

            Map<String, DepartmentStats> result = processor.analyzeDepartments(employees);
            result.forEach((department, stats) -> {
                System.out.println("Department: " + department);
                System.out.println("  Average Salary: " + stats.getAverageSalary());
                System.out.println("  Employee Count: " + stats.getEmployeeCount());
                System.out.println("  Unique Skills: " + stats.getUniqueSkills());
            });
        }
    }

    class Employee {
        private String name;
        private String department;
        private double salary;
        private List<String> skills;

        public Employee(String name, String department, double salary, List<String> skills) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.skills = skills;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public List<String> getSkills() {
            return skills;
        }
    }

    class DepartmentStats {
        private double averageSalary;
        private long employeeCount;
        private Set<String> uniqueSkills;

        public DepartmentStats(double averageSalary, long employeeCount, Set<String> uniqueSkills) {
            this.averageSalary = averageSalary;
            this.employeeCount = employeeCount;
            this.uniqueSkills = uniqueSkills;
        }

        public double getAverageSalary() {
            return averageSalary;
        }

        public long getEmployeeCount() {
            return employeeCount;
        }

        public Set<String> getUniqueSkills() {
            return uniqueSkills;
        }
    }

