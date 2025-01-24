

public class Main {

    public static void main(String[] args) {
        // here you can write code to test your classes
//
//        ProductWarehouse juice = new ProductWarehouse("Juice", 1000.0);
//        juice.addToWarehouse(1000.0);
//        juice.takeFromWarehouse(11.3);
//        System.out.println(juice.getName());
//        juice.addToWarehouse(1.0);
//        System.out.println(juice);

//        ChangeHistory ch = new ChangeHistory();
//        ch.add(5.0);
//        System.out.println(ch);

        ProductWarehouseWithHistory juice = new ProductWarehouseWithHistory("Juice", 1000.0, 1000);
        juice.takeFromWarehouse(11.3);
        System.out.println(juice.getName());
        juice.addToWarehouse(1);

        System.out.println(juice.history());
    }

}
