package Healthcare_Appointment_System;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HealthcareSystem {
    private List<Patient> patients;
    private List<Appointment> appointments;

    public HealthcareSystem() {
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public Patient addPatient(String name, String email) {
        Patient patient = new Patient(name, email);
        patients.add(patient);
        return patient;
    }

    public Appointment scheduleAppointment(Patient patient, LocalDateTime dateTime) {
        Appointment appointment = new Appointment(patient, dateTime);
        appointments.add(appointment);
        return appointment;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now();
        for (Appointment appointment : appointments) {
            if (appointment.getDateTime().isAfter(now) && appointment.getDateTime().isBefore(now.plusDays(1))) {
                System.out.println("Reminder: Appointment for " + appointment.getPatient().getName() + " on " + appointment.getDateTime());
            }
        }
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

