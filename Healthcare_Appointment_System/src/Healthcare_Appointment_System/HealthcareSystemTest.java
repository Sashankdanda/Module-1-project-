package Healthcare_Appointment_System;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HealthcareSystemTest {
   private HealthcareSystem healthcareSystem;

    @Before
    public void setUp() {
        healthcareSystem = new HealthcareSystem();
    }

    @Test
    public void testAddPatient() {
        Patient patient = healthcareSystem.addPatient("Alice Smith", "alice@example.com");

        assertNotNull(patient.getId());
        assertEquals("Alice Smith", patient.getName());
        assertEquals("alice@example.com", patient.getEmail());
    }

    @Test
    public void testScheduleAppointment() {
        Patient patient = healthcareSystem.addPatient("Bob Johnson", "bob@example.com");
        LocalDateTime appointmentTime = LocalDateTime.of(2024, 8, 18, 10, 0);
        Appointment appointment = healthcareSystem.scheduleAppointment(patient, appointmentTime);

        assertNotNull(appointment.getId());
        assertEquals(patient, appointment.getPatient());
        assertEquals(appointmentTime, appointment.getDateTime());
    }

    @Test
    public void testGetAppointments() {
        Patient patient = healthcareSystem.addPatient("Charlie Brown", "charlie@example.com");
        LocalDateTime appointmentTime = LocalDateTime.of(2024, 8, 18, 10, 0);
        healthcareSystem.scheduleAppointment(patient, appointmentTime);

        List<Appointment> appointments = healthcareSystem.getAppointments();

        assertEquals(1, appointments.size());
        assertEquals(patient, appointments.get(0).getPatient());
        assertEquals(appointmentTime, appointments.get(0).getDateTime());
    }

    @Test
    public void testSendReminders() {
        Patient patient1 = healthcareSystem.addPatient("Alice Smith", "alice@example.com");
        Patient patient2 = healthcareSystem.addPatient("Bob Johnson", "bob@example.com");

        LocalDateTime appointmentTime1 = LocalDateTime.now().plusHours(1);
        LocalDateTime appointmentTime2 = LocalDateTime.now().plusDays(2);

        healthcareSystem.scheduleAppointment(patient1, appointmentTime1);
        healthcareSystem.scheduleAppointment(patient2, appointmentTime2);

        // Redirect system output to a ByteArrayOutputStream to capture the reminders
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        healthcareSystem.sendReminders();

        // Reset System.out to its original state
        System.setOut(originalOut);

        String remindersOutput = outContent.toString();

        assertTrue(remindersOutput.contains("Reminder: Appointment for Alice Smith on " + appointmentTime1));
        assertTrue(!remindersOutput.contains("Reminder: Appointment for Bob Johnson on " + appointmentTime2));
    }
}