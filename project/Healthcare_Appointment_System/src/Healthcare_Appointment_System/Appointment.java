package Healthcare_Appointment_System;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private String id;
    private Patient patient;
    private LocalDateTime dateTime;

    public Appointment(Patient patient, LocalDateTime dateTime) {
        this.id = UUID.randomUUID().toString();
        this.patient = patient;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

