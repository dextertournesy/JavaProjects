
public class Person {
    private String name;

    public Person()
    {
        this.name = "No name.";
    }
    public Person(String name)
    {
        if (name == null)
        {
            System.out.println("Person cannot be created.");
            System.exit(0);
        }
        this.name = name;
    }
    public Person(Person aPerson)
    {
        if (aPerson == null)
        {
            System.out.println("Person cannot be created.");
            System.exit(0);
        }
        this.name = aPerson.name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString() {
        return "The name is: " + getName() + ", ";
    }


    public boolean equals(Person aPerson)
    {
        return (name.equals(aPerson.name));
    }
}
