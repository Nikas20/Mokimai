public class ProductWarehouseWithHistory extends ProductWarehouse {
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
    }

    public String history() {
        ChangeHistory hystory = null;
        return String.valueOf(hystory);
    }
}
