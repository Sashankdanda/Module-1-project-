package Customer_support_ticket;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class SupportSystem1Test<SupportSystem1Test> {
    private SupportSystem1 supportSystem1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        supportSystem1 = new SupportSystem1();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testLowSeverityTicket() {
        SupportTicket lowTicket = new SupportTicket("Low priority issue", SupportTicket.Severity.LOW);
        supportSystem1.handleRequest(lowTicket);

        String expectedOutput = "LowSeverityHandler: Handling low severity request: Low priority issue";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testMediumSeverityTicket() {
        SupportTicket mediumTicket = new SupportTicket("Medium priority issue", SupportTicket.Severity.MEDIUM);
        supportSystem1.handleRequest(mediumTicket);

        String expectedOutput = "MediumSeverityHandler: Handling medium severity request: Medium priority issue";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testHighSeverityTicket() {
        SupportTicket highTicket = new SupportTicket("High priority issue", SupportTicket.Severity.HIGH);
        supportSystem1.handleRequest(highTicket);

        String expectedOutput = "HighSeverityHandler: Handling high severity request: High priority issue";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
