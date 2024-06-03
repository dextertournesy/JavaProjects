public class MainClass {
    public static double income;

    public static void main(String []args)
    {
        Doctor Bob = new Doctor("Bob",new Date("Monday",9,18,2022),
                299998.0,"Podiatrist",100.0);
        Patient Fred = new Patient("Fred",Bob);

        Doctor Susan = new Doctor("Susan",new Date("Monday",9,18,2022),
                347880.0,"Surgeon",105.0);
        Patient Sally = new Patient("Sally", Susan);

        Doctor Lilly = new Doctor("Lilly",new Date("Monday",9,18,2022),
                400000.0,"Kidney",107.0);
        Patient John = new Patient("John", Lilly);

        System.out.println(Bob);
        System.out.println(Susan);
        System.out.println(Lilly + "\n");

        System.out.println("*Patient's Information*");
        System.out.println(Fred);
        System.out.println(Sally);
        System.out.println(John + "\n");

        System.out.println("*Billing Information+");

        billingInformation(Fred);
        billingInformation(Sally);
        billingInformation(John);

        income(Fred);
        income(Sally);
        income(John);
        System.out.println("\nThe total income from billing records " +
                "is: $" + income);


    }

    public static void billingInformation(Patient aPatient)
    {
        Billing aBill = new Billing(aPatient, aPatient.getDoctor(),
                aPatient.getDoctor().getVisitFee());
        System.out.println(aBill);
    }

    public static void income(Patient aPatient)
    {
        income += aPatient.getDoctor().getVisitFee();
    }
}

