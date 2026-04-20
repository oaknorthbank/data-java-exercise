import java.util.Map;

public class InvoiceStatistics {

    private final Map<Integer, Integer> invoicesCountByOrgMap;
    private final Map<Integer, Integer> overDueInvoicesCountByOrg;
    private final Map<Integer, Map<Integer, Integer>> invoicesCountByOrgMapByMonth;

    public InvoiceStatistics(Map<Integer, Integer> invoicesCountByOrgMap, Map<Integer, Integer> overDueInvoicesCountByOrg, Map<Integer, Map<Integer, Integer>> invoicesCountByOrgMapByMonth) {
        this.invoicesCountByOrgMap = invoicesCountByOrgMap;
        this.overDueInvoicesCountByOrg = overDueInvoicesCountByOrg;
        this.invoicesCountByOrgMapByMonth = invoicesCountByOrgMapByMonth;
    }

    public Map<Integer, Integer> getInvoicesCountByOrgMap() {
        return invoicesCountByOrgMap;
    }

    public Map<Integer, Integer> getOverDueInvoicesCountByOrg() {
        return overDueInvoicesCountByOrg;
    }

    public Map<Integer, Map<Integer, Integer>> getInvoicesCountByOrgMapByMonth() {
        return invoicesCountByOrgMapByMonth;
    }
}