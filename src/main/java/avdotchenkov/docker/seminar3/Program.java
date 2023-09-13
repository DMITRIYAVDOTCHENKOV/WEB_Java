package avdotchenkov.docker.seminar3;


import java.util.List;

public class Program {

    public static void main(String[] args) {
        System.out.println("Фрилансеры: ");
      List<Employee> freelancers = Freelancer.getEmployees(5);
        for (Employee freelancer : freelancers) {
            System.out.println(freelancer);
        }
        System.out.println();
        System.out.println("А теперь посмотрим сколько зарабатывают рабочие : ");
        List<Employee> workers = Worker.getEmployees(5);
        for (Employee worker : workers) {
            System.out.println(worker);
        }





//        List<Employee> employees = Worker.getEmployees(15);
//
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }
//
//        Collections.sort(employees, new EmployeeNameComparator());
//        System.out.println();
//
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }

    }

}
