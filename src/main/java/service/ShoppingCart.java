package service;

import model.Discountable;
import model.Food;

public class ShoppingCart {
    private Food[] foods;

    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    // общая сумма без скидки
    public double getTotalPriceWithoutDiscount() {
        double total = 0;
        for (Food food : foods) {
            total += food.getAmount() * food.getPrice();
        }
        return total;
    }

    // общая сумма со скидкой
    public double getTotalPriceWithDiscount() {
        double total = 0;

        for (Food food : foods) {
            double price = food.getAmount() * food.getPrice();

            if (food instanceof Discountable) {
                double discount = ((Discountable) food).getDiscount(); // например 60
                price = price * (1 - discount / 100.0);
            }

            total += price;
        }

        return total;
    }

    // сумма всех вегетарианских продуктов без скидки
    public double getTotalVegetarianPriceWithoutDiscount() {
        double total = 0;

        for (Food food : foods) {
            if (food.isVegetarian()) {
                total += food.getAmount() * food.getPrice();
            }
        }

        return total;
    }
}

