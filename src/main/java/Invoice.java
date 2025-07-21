import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    private final int id;
    private final int organisationId;
    private final LocalDate raisedDate;
    private final LocalDate dueDate;
    private final LocalDate paidDate;
    private final String status;
    private final double amount;

    public Invoice(int id, int organisationId, LocalDate raisedDate, LocalDate dueDate, 
                   LocalDate paidDate, String status, double amount) {
        this.id = id;
        this.organisationId = organisationId;
        this.raisedDate = raisedDate;
        this.dueDate = dueDate;
        this.paidDate = paidDate;
        this.status = status;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public LocalDate getRaisedDate() {
        return raisedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", organisationId=" + organisationId +
                ", raisedDate=" + raisedDate +
                ", dueDate=" + dueDate +
                ", paidDate=" + paidDate +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
} 