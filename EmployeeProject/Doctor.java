public class Doctor extends SalariedEmployee{

    private String name;
    private String specialty;
    private double visitFee;

public Doctor()
{
    super();
    this.name = "No name";
    this.specialty = "No specialty";
    this.visitFee = 0.0;
}

public Doctor(String name,Date hireDate, double salary, String specialty, double visitFee)
{
    super(name,hireDate, salary);
    if (name == null || specialty == null || visitFee < 0)
    {
        System.out.println("Error creating doctor record");
        System.exit(0);
    }
    setSpecialty(specialty);
    setVisitFee(visitFee);
}

public Doctor(Doctor aDoctor)
{
    if (aDoctor == null)
    {
        System.out.println("Error creating doctor record");
        System.exit(0);
    }
    this.name = aDoctor.name;
    this.specialty = aDoctor.specialty;
    this.visitFee = aDoctor.visitFee;
}

public String getName()
    {
        return name;
    }
public void setName(String name) {
        this.name = name;
    }


    public String getSpecialty()
{
    return specialty;
}
public void setSpecialty(String specialty)
{
    this.specialty = specialty;
}

public double getVisitFee()
{
    return visitFee;
}
public void setVisitFee(double visitFee)
{
    this.visitFee = visitFee;
}

    @Override
    public String toString()
    {
        return super.toString() +
        "\nThe specialty is " + specialty + " and visit fee is $" + visitFee;
    }

    public boolean equals(Doctor aDoctor) {
        return (specialty.equals(aDoctor.specialty)
        && visitFee == (aDoctor.visitFee));
    }
}
