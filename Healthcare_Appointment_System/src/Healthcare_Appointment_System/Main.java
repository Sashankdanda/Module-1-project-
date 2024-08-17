package Healthcare_Appointment_System;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        HealthcareSystem healthcareSystem = new HealthcareSystem();

        // Adding patients
        Patient patient1 = healthcareSystem.addPatient("Alice Smith", "alice@example.com");
        Patient patient2 = healthcareSystem.addPatient("Bob Johnson", "bob@example.com");

        // Scheduling appointments
        LocalDateTime appointmentTime1 = LocalDateTime.of(2024, 8, 18, 10, 0);
        LocalDateTime appointmentTime2 = LocalDateTime.of(2024, 8, 19, 14, 30);
        
        Appointment appointment1 = healthcareSystem.scheduleAppointment(patient1, appointmentTime1);
        Appointment appointment2 = healthcareSystem.scheduleAppointment(patient2, appointmentTime2);

        // Display all appointments
        for (Appointment appointment : healthcareSystem.getAppointments()) {
            System.out.println("Appointment ID: " + appointment.getId() +
                               ", Patient: " + appointment.getPatient().getName() +
                               ", Date and Time: " + appointment.getDateTime());
        }

        // Send reminders for appointments happening in the next 24 hours
        healthcareSystem.sendReminders();
    }
}

