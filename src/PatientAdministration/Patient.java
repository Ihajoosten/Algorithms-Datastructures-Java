package PatientAdministration;

public class Patient implements Comparable<Patient> {

    private String name;
    private int age;
    private double weight;

    public Patient(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Patient: " + "\n\n" +
                "Name = " + this.name + "\n" +
                "Age = " + this.age + "\n" +
                "Weight = " + this.weight;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.age, other.age);
    }

    public int getHashCode() {
        System.out.println("GetHashCode called: " + name.hashCode());
        return name.hashCode();
    }

    public boolean Equals(Patient other)
    {
        System.out.println("Equals<T>(Patient patient) on Patient called");
        return name.equals(other.name) && age == other.age && weight == other.weight;
    }


}
