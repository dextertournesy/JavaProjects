public class Employee {

    private String name;
    private Date hireDate;

    public Employee()
    {
        name = "No name";
        hireDate = new Date();
    }
    public Employee(String name, Date hireDate)
    {
        if (name == null|| hireDate == null)
        {
            System.out.println("Error creating a new Employee");
            System.exit(0);
        }
        setName(name);
        this.name = name;
        this.hireDate = new Date(hireDate);
    }

    public Employee(Employee otherEmployee)
    {
        if (otherEmployee == null)
        {
            System.out.println("Error creating employee.");
            System.exit(0);
        }
        this.name = otherEmployee.name;
        this.hireDate = new Date(otherEmployee.hireDate);
    }

    public void setName(String name)
    {
        if (name== null)
        {
            System.out.println("Error updating employee name");
        }
        this.name = name;
    }
    public void setHireDate(Date hireDate)
    {
        if (hireDate == null)
        {
            System.out.println("Error updating hire date");
            System.exit(0);
        }
        this.hireDate = new Date(hireDate);
    }

    public String getName() {
        return name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "The doctor " + name +
                " was hired on " + hireDate;
    }

    public boolean equals(Employee otherEmployee)
    {
        return (name.equals(otherEmployee.name) && hireDate.equals(otherEmployee.hireDate));
    }
}
