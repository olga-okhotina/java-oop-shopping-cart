import model.Apple;
import model.Food;
import model.Meat;
import model.constants.Colour;
import service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Food meat = new Meat(5, 100);
        Food redApples = new Apple(10, 50, Colour.RED);
        Food greenApples = new Apple(8, 60, Colour.GREEN);

        Food[] foods = {meat, redApples, greenApples};

        ShoppingCart cart = new ShoppingCart(foods);

        System.out.printf("Общая сумма без скидки: %.2f%n", cart.getTotalPriceWithoutDiscount());
        System.out.printf("Общая сумма со скидкой: %.2f%n", cart.getTotalPriceWithDiscount());
        System.out.printf("Сумма вегетарианских продуктов без скидки: %.2f%n",
                cart.getTotalVegetarianPriceWithoutDiscount());
    }
}


