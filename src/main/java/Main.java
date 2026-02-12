import java.time.Instant;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataRetriever dataRetriever = new DataRetriever();

//        getStockValueAt
//        // Date après tous les mouvements du data.sql
//        Instant testDate = Instant.parse("2024-01-07T00:00:00Z");
//
//        System.out.println("=== TEST STOCK SQL ===");
//
//        StockValue laitueStock = dataRetriever.getStockValueAt(testDate, 1);
//        System.out.println("Laitue (id=1) : " + laitueStock);
//
//        StockValue tomateStock = dataRetriever.getStockValueAt(testDate, 2);
//        System.out.println("Tomate (id=2) : " + tomateStock);
//
//        StockValue pouletStock = dataRetriever.getStockValueAt(testDate, 3);
//        System.out.println("Poulet (id=3) : " + pouletStock);
//
//        StockValue chocolatStock = dataRetriever.getStockValueAt(testDate, 4);
//        System.out.println("Chocolat (id=4) : " + chocolatStock);
//
//        StockValue beurreStock = dataRetriever.getStockValueAt(testDate, 5);
//        System.out.println("Beurre (id=5) : " + beurreStock);


//        getDishCost
//        System.out.println("=== TEST DISH COST SQL ===");
//
//        Double saladeCost = dataRetriever.getDishCost(1);
//        System.out.println("Salade fraîche (id=1) cost = " + saladeCost);
//
//        Double pouletCost = dataRetriever.getDishCost(2);
//        System.out.println("Poulet grillé (id=2) cost = " + pouletCost);
//
//        Double gateauCost = dataRetriever.getDishCost(4);
//        System.out.println("Gâteau au chocolat (id=4) cost = " + gateauCost);
//
//        Double rizCost = dataRetriever.getDishCost(3);
//        System.out.println("Riz aux légumes (id=3) cost = " + rizCost);

//        getGrossMargin
//        System.out.println("=== TEST GROSS MARGIN SQL ===");
//
//        Double saladeMargin = dataRetriever.getGrossMargin(1);
//        System.out.println("Salade fraîche (id=1) margin = " + saladeMargin);
//
//        Double pouletMargin = dataRetriever.getGrossMargin(2);
//        System.out.println("Poulet grillé (id=2) margin = " + pouletMargin);
//
//        Double gateauMargin = dataRetriever.getGrossMargin(4);
//        System.out.println("Gâteau au chocolat (id=4) margin = " + gateauMargin);
//
//        Double rizMargin = dataRetriever.getGrossMargin(3);
//        System.out.println("Riz aux légumes (id=3) margin = " + rizMargin);

        Instant from = Instant.parse("2024-01-01T00:00:00Z");
        Instant to = Instant.parse("2024-01-07T00:00:00Z");

        System.out.println("=== STOCK EVOLUTION (DAY) ===");

        List<DataRetriever.StockPoint> evolution =
                dataRetriever.getStockEvolution(1, from, to, "DAY");

        evolution.forEach(System.out::println);
    }
}
