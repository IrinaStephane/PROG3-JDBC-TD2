import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRetriever retriever = new DataRetriever();

        System.out.println("=== Test de getGrossMargin() ===");
        System.out.println("Les marges brutes calculées :");
        System.out.println("=================================");

        // Tester chaque plat
        List<Dish> dishes = List.of(
                retriever.findDishById(1),  // Salade fraîche
                retriever.findDishById(2),  // Poulet grillé
                retriever.findDishById(3),  // Riz aux légumes
                retriever.findDishById(4),  // Gâteau au chocolat
                retriever.findDishById(5)   // Salade de fruits
        );

        for (Dish dish : dishes) {
            System.out.println("\nPlat: " + dish.getName());
            System.out.println("Prix de vente: " +
                    (dish.getPrice() == null ? "NULL" : String.format("%.2f", dish.getPrice())));
            System.out.println("Coût des ingrédients: " +
                    String.format("%.2f", dish.getDishCost()));

            try {
                double margin = dish.getGrossMargin();
                System.out.println("Marge brute: " + String.format("%.2f", margin));
                System.out.println("✓ Calcul réussi");
            } catch (RuntimeException e) {
                System.out.println("✗ Exception: " + e.getMessage());
            }
        }

        // Résumé des valeurs attendues
        System.out.println("\n\n=== RÉSUMÉ DES VALEURS ATTENDUES ===");
        System.out.println("D'après le sujet, les marges doivent être :");
        System.out.println("-------------------------------------------");
        System.out.println("1. Salade fraîche : 3250.00");
        System.out.println("2. Poulet grillé : 7500.00");
        System.out.println("3. Riz aux légumes : Exception (prix NULL)");
        System.out.println("4. Gâteau au chocolat : 6600.00");
        System.out.println("5. Salade de fruits : Exception (prix NULL)");

        // Vérification détaillée
        System.out.println("\n\n=== VÉRIFICATION DÉTAILLÉE ===");
        System.out.println("Calculs attendus :");
        System.out.println("------------------");

        // Salade fraîche
        Dish salade = retriever.findDishById(1);
        System.out.println("\n1. Salade fraîche :");
        System.out.println("   Prix vente = 3500.00");
        System.out.println("   Coût = " + String.format("%.2f", salade.getDishCost()) +
                " (250.00 attendu)");
        System.out.println("   Marge = 3500.00 - 250.00 = 3250.00");

        // Poulet grillé
        Dish poulet = retriever.findDishById(2);
        System.out.println("\n2. Poulet grillé :");
        System.out.println("   Prix vente = 12000.00");
        System.out.println("   Coût = " + String.format("%.2f", poulet.getDishCost()) +
                " (4500.00 attendu)");
        System.out.println("   Marge = 12000.00 - 4500.00 = 7500.00");

        // Gâteau au chocolat
        Dish gateau = retriever.findDishById(4);
        System.out.println("\n3. Gâteau au chocolat :");
        System.out.println("   Prix vente = 8000.00");
        System.out.println("   Coût = " + String.format("%.2f", gateau.getDishCost()) +
                " (1400.00 attendu)");
        System.out.println("   Marge = 8000.00 - 1400.00 = 6600.00");

        // Tests avec exceptions
        System.out.println("\n4. Riz aux légumes :");
        System.out.println("   Prix vente = NULL");
        System.out.println("   Exception attendue : 'Price is null'");

        System.out.println("\n5. Salade de fruits :");
        System.out.println("   Prix vente = NULL");
        System.out.println("   Exception attendue : 'Price is null'");

        // Test unitaire
        System.out.println("\n=== TEST AUTOMATISÉ ===");
        int testsPassed = 0;
        int totalTests = 5;

        try {
            double marge1 = salade.getGrossMargin();
            if (Math.abs(marge1 - 3250.00) < 0.01) {
                System.out.println("✓ Test 1 (Salade fraîche) : PASS");
                testsPassed++;
            } else {
                System.out.println("✗ Test 1 (Salade fraîche) : FAIL - Valeur obtenue: " + marge1);
            }
        } catch (Exception e) {
            System.out.println("✗ Test 1 (Salade fraîche) : FAIL - Exception inattendue");
        }

        try {
            double marge2 = poulet.getGrossMargin();
            if (Math.abs(marge2 - 7500.00) < 0.01) {
                System.out.println("✓ Test 2 (Poulet grillé) : PASS");
                testsPassed++;
            } else {
                System.out.println("✗ Test 2 (Poulet grillé) : FAIL - Valeur obtenue: " + marge2);
            }
        } catch (Exception e) {
            System.out.println("✗ Test 2 (Poulet grillé) : FAIL - Exception inattendue");
        }

        try {
            Dish riz = retriever.findDishById(3);
            riz.getGrossMargin();
            System.out.println("✗ Test 3 (Riz aux légumes) : FAIL - Aucune exception levée");
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Price is null") || e.getMessage().contains("selling price is null")) {
                System.out.println("✓ Test 3 (Riz aux légumes) : PASS - Exception correcte");
                testsPassed++;
            } else {
                System.out.println("✗ Test 3 (Riz aux légumes) : FAIL - Mauvais message d'exception");
            }
        }

        try {
            double marge4 = gateau.getGrossMargin();
            if (Math.abs(marge4 - 6600.00) < 0.01) {
                System.out.println("✓ Test 4 (Gâteau au chocolat) : PASS");
                testsPassed++;
            } else {
                System.out.println("✗ Test 4 (Gâteau au chocolat) : FAIL - Valeur obtenue: " + marge4);
            }
        } catch (Exception e) {
            System.out.println("✗ Test 4 (Gâteau au chocolat) : FAIL - Exception inattendue");
        }

        try {
            Dish saladeFruits = retriever.findDishById(5);
            saladeFruits.getGrossMargin();
            System.out.println("✗ Test 5 (Salade de fruits) : FAIL - Aucune exception levée");
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Price is null") || e.getMessage().contains("selling price is null")) {
                System.out.println("✓ Test 5 (Salade de fruits) : PASS - Exception correcte");
                testsPassed++;
            } else {
                System.out.println("✗ Test 5 (Salade de fruits) : FAIL - Mauvais message d'exception");
            }
        }

        System.out.println("\n=== RÉSULTAT FINAL ===");
        System.out.println("Tests réussis : " + testsPassed + "/" + totalTests);

        if (testsPassed == totalTests) {
            System.out.println("🎉 Tous les tests passent !");
        } else {
            System.out.println("⚠ Certains tests échouent");
        }
    }
}