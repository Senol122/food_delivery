package food_delivery.company;

public class Company {
    protected String name;
    protected int nrOfEmployees;
    protected boolean international;

    public Company(String name, int nrOfEmployees, boolean international) {
        this.name = name;
        this.nrOfEmployees = nrOfEmployees;
        this.international = international;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfEmployees() {
        return nrOfEmployees;
    }

    public void setNrOfEmployees(int nrOfEmployees) {
        this.nrOfEmployees = nrOfEmployees;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", nrOfEmployees=" + nrOfEmployees +
                ", international=" + international +
                '}';
    }
}
