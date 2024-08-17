package Customer_support_ticket;

public class SupportSystem {
    private SupportHandler firstHandler;

    public SupportSystem() {
        // Initialize handlers
        SupportHandler lowSeverityHandler = new LowSeverityHandler();
        SupportHandler mediumSeverityHandler = new MediumSeverityHandler();
        SupportHandler highSeverityHandler = new HighSeverityHandler();

        // Set the chain of responsibility
        lowSeverityHandler.setNextHandler(mediumSeverityHandler);
        mediumSeverityHandler.setNextHandler(highSeverityHandler);

        // Set the first handler
        firstHandler = lowSeverityHandler;
    }

    public void handleRequest(SupportTicket request) {
        if (firstHandler != null) {
            firstHandler.handleRequest(request);
        }
    }

    public static void main(String[] args) {
        SupportSystem supportSystem = new SupportSystem();

        SupportTicket lowTicket = new SupportTicket("Low priority issue", SupportTicket.Severity.LOW);
        SupportTicket mediumTicket = new SupportTicket("Medium priority issue", SupportTicket.Severity.MEDIUM);
        SupportTicket highTicket = new SupportTicket("High priority issue", SupportTicket.Severity.HIGH);

        supportSystem.handleRequest(lowTicket);
        supportSystem.handleRequest(mediumTicket);
        supportSystem.handleRequest(highTicket);
    }
}

