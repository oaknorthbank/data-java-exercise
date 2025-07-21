import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvInvoiceReader {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public List<Invoice> readInvoices(String filename) throws IOException {
        List<Invoice> invoices = new ArrayList<>();
        
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            
            // Skip header
            String line = reader.readLine();
            if (line == null || !line.startsWith("id,organisation_id")) {
                throw new IOException("Invalid CSV format: missing header");
            }
            
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Invoice invoice = parseInvoice(line);
                    invoices.add(invoice);
                }
            }
        }
        
        return invoices;
    }
    
    private Invoice parseInvoice(String line) {
        String[] fields = line.split(",");
        if (fields.length != 7) {
            throw new IllegalArgumentException("Invalid invoice line: " + line);
        }
        
        int id = Integer.parseInt(fields[0]);
        int organisationId = Integer.parseInt(fields[1]);
        LocalDate raisedDate = LocalDate.parse(fields[2], DATE_FORMATTER);
        LocalDate dueDate = LocalDate.parse(fields[3], DATE_FORMATTER);
        
        LocalDate paidDate = null;
        if (!fields[4].isEmpty()) {
            paidDate = LocalDate.parse(fields[4], DATE_FORMATTER);
        }
        
        String status = fields[5];
        double amount = Double.parseDouble(fields[6]);
        
        return new Invoice(id, organisationId, raisedDate, dueDate, paidDate, status, amount);
    }
} 