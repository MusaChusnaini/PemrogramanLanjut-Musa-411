package tugas1;

class Doctor {
    private static final double BONUS_RATE = 0.08;
    private String name;
    private int id;
    private double salary;
    private String specialization;

    // Constructor
    public Doctor(String name, int id, double salary, String specialization) {
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
        this.setSpecialization(specialization);
    }

    public void applyBonus() {
        double bonus = getBonus();
        setSalary(getSalary() + bonus);
        System.out.println("Bonus applied! New Salary : " + getSalary());
    }

    private double getBonus() {
        return getSalary() * BONUS_RATE;
    }

    public void printDetails() {
        System.out.println("Doctor ID: " + getId());
        System.out.println("Name : " + getName());
        System.out.println("Specialization : " + getSpecialization());
        System.out.println("Salary: $" + getSalary());
    }

    // Update specialization
    public void updateSpecialization(String newSpecialization) {
        setSpecialization(newSpecialization);
        System.out.println("Specialization updated to: " + getSpecialization());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}