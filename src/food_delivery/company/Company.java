package food_delivery.company;

public class Company {
    protected String name;
    protected boolean international;

    public Company() {
    }

    public Company(String name, boolean international) {
        this.name = name;
        this.international = international;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", international=" + international +
                '}';
    }
}
