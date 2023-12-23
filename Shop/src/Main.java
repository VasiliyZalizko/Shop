import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Катамаран", "Ноутбук", "Смартфон", "Планшет", "Скутер"};
        int[] prices = {100, 200, 300, 400, 500};
        int[] counts = new int[products.length];// Применение принципа Magics
        showProducts(products, prices); // Применение принципа DRY
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String answer = scanner.nextLine();
            if ("end".equals(answer)) {
                break;
            }
            String[] answerSeparated = answer.split(" ");
            int productNumber = Integer.parseInt(answerSeparated[0]) - 1;
            int productCount = Integer.parseInt(answerSeparated[1]);
            counts[productNumber] += productCount;
        }
        calcTogether(products, prices, counts); // Применение принципа DRY
    }
    private static void calcTogether(String[] products, int[] prices, int[] counts) {
        System.out.println("Ваша корзина:");
        int sumProducts = 0;
        for (int i = 0; i < products.length; i++) {
            if (counts [i] > 0) {
                int currentPrice = prices[i] * counts[i];
                System.out.println(products[i] + " " + counts[i] + " шт. " + prices[i] + " у.е./шт. " + currentPrice + " у.е. в сумме");
                sumProducts += currentPrice;
            }
        }
        System.out.println("Итого " + sumProducts + " у.е.");
    }
    private static void showProducts(String[] products, int[] prices) {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + " " + prices[i] + " у.е./шт.");
        }

    }

}