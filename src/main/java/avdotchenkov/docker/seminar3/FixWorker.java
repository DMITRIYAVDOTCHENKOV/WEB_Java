package avdotchenkov.docker.seminar3;

public class FixWorker extends Employee{
    private double Fixsalary;

    public FixWorker(String surNames, String name, double Fixsalary) {
        super(surNames,name);
        this.Fixsalary = Fixsalary;
    }


    @Override
    public double calculateSalary() {
        return Fixsalary;
    }
}
