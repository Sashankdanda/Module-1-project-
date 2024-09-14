package Customer_support_ticket;

public class HighSeverityHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket request) {
        if (request.getSeverity() == SupportTicket.Severity.HIGH) {
            System.out.println("HighSeverityHandler: Handling high severity request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
