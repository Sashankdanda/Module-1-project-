package Customer_support_ticket;

public class MediumSeverityHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket request) {
        if (request.getSeverity() == SupportTicket.Severity.MEDIUM) {
            System.out.println("MediumSeverityHandler: Handling medium severity request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
