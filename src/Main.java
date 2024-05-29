import java.util.ArrayList;

abstract class Employee{


private String name;
private int id;


    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


  public abstract double calculateSalary();

}




class FullTimeEmployee extends Employee{

    private double monthlySalary;


    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}


class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private  double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }


    @Override
    public double calculateSalary() {
        return hoursWorked*hourlyRate;
    }
}




class PayrollSystem{

    private ArrayList<Employee> employeeList;


    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){

        employeeList.add(employee);
    }

    public void removeEmployee(int id){

        Employee employeeToRemove = null;

        for(Employee employee: employeeList){

            if(employee.getId()==id){
                employeeToRemove = employee;
                 break;
            }

        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }



    public void displayEmployee(){
  for(Employee employee:employeeList){

      System.out.println(employee);
  }

    }
}
public class Main {

    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("vikas", 1,70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("max", 2,36);


        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial employee details");
        payrollSystem.displayEmployee();
        System.out.println("Removing a employee");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining employee details");
        payrollSystem.displayEmployee();
    }
}
