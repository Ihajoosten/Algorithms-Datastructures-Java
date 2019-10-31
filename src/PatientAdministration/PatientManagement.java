package PatientAdministration;

import javax.swing.*;
import javax.swing.tree.TreeCellRenderer;
import java.security.KeyException;
import java.util.*;

public class PatientManagement {

    private HashMap<Patient, MedicalRecord> patients = new HashMap<>();
    private SortedSet<Patient> patientsSorted = new TreeSet<>();

    public static void main(String[] args) {

    }

    public void AddPatient(Patient patient, MedicalRecord medicalRecord)
    {
        patients.put(patient, medicalRecord);
        patientsSorted.add(patient);
    }


    public MedicalRecord findMedicalRecord(Patient patient) throws KeyException {
        for (Map.Entry<Patient, MedicalRecord> entry : patients.entrySet()) {
            if (entry.getKey() == patient) return entry.getValue();
        }
        return null;
    }

    public SortedSet<Patient> FindPatients(int minAge, int maxAge) {
        return patientsSorted.subSet(new Patient("", minAge, 0), new Patient("", maxAge, 0));
    }


}
