import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Map;

class ConsumerTest {
    
    private Consumer consumer;
    private List<Invoice> testInvoices;
    
    @BeforeEach
    void setUp() throws IOException {
        LocalDate testCurrDate = LocalDate.parse("2019-10-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        consumer = new Consumer(testCurrDate);
        CsvInvoiceReader csvReader = new CsvInvoiceReader();
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


    @Test
    @DisplayName("test record count match")
    void testRecordCount(){
        assertEquals(11,testInvoices.size());
    }

    @Test
    @DisplayName("Total number of invoices per organisation should match")
    void testInvoicesPerOrgCount(){
        InvoiceStatistics result = consumer.consumeInvoices(testInvoices);
        assertNotNull(result);
        Map<Integer,Integer> invoiceCountByOrg = result.getInvoicesCountByOrgMap();

        Map<Integer,Integer> expectedResultMap=new HashMap<>();
        expectedResultMap.put(1000,5);
        expectedResultMap.put(2000,6);
        assertEquals(expectedResultMap,invoiceCountByOrg);
    }

    @Test
    @DisplayName("Total number of Over due invoices per organisation should match")
    void testOverDueInvoicesCountByOrg(){
        InvoiceStatistics result = consumer.consumeInvoices(testInvoices);
        assertNotNull(result);
        Map<Integer,Integer> overDueInvoiceCountByOrg = result.getOverDueInvoicesCountByOrg();

        Map<Integer,Integer> expectedResultMap=new HashMap<>();
        expectedResultMap.put(1000,2);
        expectedResultMap.put(2000,2);
        assertEquals(expectedResultMap,overDueInvoiceCountByOrg);
    }

    @Test
    @DisplayName("Total number of invoices per organisation per month should match")
    void testInvoicesCountByOrgMapByMonth(){
        InvoiceStatistics result = consumer.consumeInvoices(testInvoices);
        assertNotNull(result);
        Map<Integer, Map<Integer, Integer>> invoiceCountByOrgByMonth = result.getInvoicesCountByOrgMapByMonth();

        Map<Integer,Map<Integer, Integer>> expectedResultMap=new HashMap<>();
        HashMap<Integer, Integer> account1MonthlyMap = new HashMap<>();;
        account1MonthlyMap.put(10,3);

        expectedResultMap.put(1000, account1MonthlyMap);

        HashMap<Integer, Integer> account2MonthlyMap = new HashMap<>();;
        account2MonthlyMap.put(9,4);

        expectedResultMap.put(2000,account2MonthlyMap);


        assertEquals(expectedResultMap,invoiceCountByOrgByMonth);
    }


} 