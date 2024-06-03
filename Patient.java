public class Patient extends Person{
    private Doctor aDoctor;

    public Patient()
    {
        super();
        aDoctor = new Doctor();
    }

   public Patient(String name, Doctor aDoctor)
    {
        super(name);
        this.aDoctor = new Doctor(aDoctor);
    }

    public Patient(Person aPerson, Doctor aDoctor)
    {
        super(aPerson);
        this.aDoctor = aDoctor;
    }



    public void setName(String name)
    {
        super.setName(name);
    }

    public String getName()
    {
      return super.getName();
    }

    public void setDoctor(Doctor aDoctor)
    {
        this.aDoctor = aDoctor;
    }
    public Doctor getDoctor()
    {
        return aDoctor;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Primary doctor is: " + aDoctor.getName();
    }

    public boolean equals(Patient aPatient)
    {
        return (getName().equals(aPatient.getName())
                && aDoctor == (aPatient.aDoctor));
    }
}
