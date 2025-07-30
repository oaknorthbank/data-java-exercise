import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consumer {


    private LocalDate currDate;

    Consumer(){
    }

    Consumer(LocalDate currDate){
        this.currDate = currDate;
    }
    
    public InvoiceStatistics consumeInvoices(List<Invoice> invoices) {
        Map<Integer, Integer> invoicesCountByOrgMap = getInvoicesCountByOrg(invoices);
        Map<Integer, Integer> overDueInvoicesCountByOrg = getOverDueInvoicesCountByOrg(invoices,currDate);
        Map<Integer, Map<Integer, Integer>> invoicesCountByOrgMapByMonth = getInvoicesCountByOrgByMonth(invoices);
        InvoiceStatistics invoiceStatistics = new InvoiceStatistics(invoicesCountByOrgMap,overDueInvoicesCountByOrg,invoicesCountByOrgMapByMonth);
        return invoiceStatistics;
    }

        public Map<Integer, Integer> getOverDueInvoicesCountByOrg(List<Invoice> invoices, LocalDate currDate) {

        if(null==currDate) {
            currDate = LocalDate.now();
        }

        Map<Integer,Integer> result = new HashMap<>();
        for (Invoice invoice : invoices) {
            if( "unpaid".equalsIgnoreCase(invoice.getStatus()) && invoice.getDueDate().isAfter(currDate)){
                int currCount = result.getOrDefault(invoice.getOrganisationId(),0);
                result.put(invoice.getOrganisationId(),currCount+1);
            }
        }
        return result;
    }

    public Map<Integer, Integer> getInvoicesCountByOrg(List<Invoice> invoices) {
        Map<Integer,Integer> result = new HashMap<>();
        for (Invoice invoice : invoices) {
            int currCount = result.getOrDefault(invoice.getOrganisationId(),0);
            result.put(invoice.getOrganisationId(),currCount+1);
        }
        return result;
    }


    public Map<Integer, Map<Integer,Integer>> getInvoicesCountByOrgByMonth(List<Invoice> invoices) {
        Map<Integer,Map<Integer,Integer>> result = new HashMap<>();
        for (Invoice invoice : invoices) {
            if("paid".equalsIgnoreCase(invoice.getStatus())) {
                Map<Integer,Integer> countByMonth = result.getOrDefault(invoice.getOrganisationId(),new HashMap<>());
                int invCount = countByMonth.getOrDefault(invoice.getRaisedDate().getMonth().getValue(),0);
                countByMonth.put(invoice.getRaisedDate().getMonth().getValue(),invCount+1);
                result.put(invoice.getOrganisationId(),countByMonth);
            }

        }
        return result;
    }


} 