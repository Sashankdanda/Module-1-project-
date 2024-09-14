package Customer_support_ticket;

public class LowSeverityHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket request) {
        if (request.getSeverity() == SupportTicket.Severity.LOW) {
            System.out.println("LowSeverityHandler: Handling low severity request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
