public class Billing {
    private Patient aPatient;
    private Doctor aDoctor;
    private double amountDue;

    public Billing ()
    {
        this.aPatient = null;
        this.aDoctor = null;
        this.amountDue = 0.0;
    }

    public Billing(Patient aPatient, Doctor aDoctor, double amountDue)
    {
        this.aPatient = aPatient;
        this.aDoctor = aDoctor;
        this.amountDue = amountDue;
    }

    public Patient getaPatient() {
        return aPatient;
    }

    public void setaPatient(Patient aPatient) {
        this.aPatient = aPatient;
    }

    public Doctor getaDoctor() {
        return aDoctor;
    }

    public void setaDoctor(Doctor aDoctor) {
        this.aDoctor = aDoctor;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    @Override
    public String toString() {
        return "Patient: " + aPatient.getName() +
                "\nDoctor: " + aDoctor.getName() +
                "\nAmount Due: $" + amountDue;
    }

    public boolean equals(Billing aBill)
    {
        return (aBill.equals(aBill.aDoctor) && aBill.equals(aBill.aPatient)
                && aBill.equals(aBill.amountDue));
    }
}
