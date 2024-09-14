package Healthcare_Appointment_System;

import java.util.UUID;

public class Patient {
    private String id;
    private String name;
    private String email;

    public Patient(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

