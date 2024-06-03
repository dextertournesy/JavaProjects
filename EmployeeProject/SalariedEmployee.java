public class SalariedEmployee extends Employee{
    private double salary;

    public SalariedEmployee()
    {
        this("No name", new Date(), 0.0);
    }


    public SalariedEmployee(String name, Date hireDate, double salary)
    {
        super(name, hireDate);
        setSalary(salary);
    }

    public SalariedEmployee(SalariedEmployee otherEmployee)
    {
        super(otherEmployee);
        this.salary = otherEmployee.salary;
    }

    public void setSalary(double salary)
    {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be equal to 0.");
            System.exit(0);
        }
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString()
    {
        return super.toString() + " with salary of $" + getSalary();
    }


    public boolean equals(SalariedEmployee otherEmployee) {
        return (super.equals(otherEmployee) &&
                salary == otherEmployee.getSalary());
    }
}
