package avdotchenkov.docker.seminar3;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee{
    protected static double hourlyPayment = 12;

    public Freelancer(String surName, String name, double hourlyPayment) {
        super(name, surName);
        this.hourlyPayment = hourlyPayment;
    }
    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }




    public double calculateSalary() {
        return hourlyPayment;
    }
    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                28.8 * 8 * hourlyPayment);
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f" +
                        " (руб" +
                        ".)",
                surName, name, hourlyPayment);
    }
}


