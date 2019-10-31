package PatientAdministration;

public class MedicalRecord {

    private String details;

    public MedicalRecord(String details) {
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }

    @Override
    public String toString() {
        return "MedicalRecord: " + "\n\n" +
                "Record = " + this.details;
    }
}
