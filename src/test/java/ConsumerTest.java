import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ConsumerTest {
    
    private Consumer consumer;
    private CsvInvoiceReader csvReader;
    private List<Invoice> testInvoices;
    
    @BeforeEach
    void setUp() throws IOException {
        consumer = new Consumer();
        csvReader = new CsvInvoiceReader();
        testInvoices = csvReader.readInvoices("invoices.csv");
    }
    
    @Test
    @DisplayName("Should handle empty list of invoices")
    void testEmptyList() {
        List<Invoice> emptyInvoices = new ArrayList<>();
        InvoiceStatistics result = consumer.consumeInvoices(emptyInvoices);
        
        // TODO: This test should pass once the implementation is complete
        // For now, it will fail because the method returns null
        assertNotNull(result);
    }
} 