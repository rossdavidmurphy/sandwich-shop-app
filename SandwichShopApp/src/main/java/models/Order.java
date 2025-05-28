package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> menuItems;

    public Order() {
        this.menuItems = new ArrayList<>();
    }

    public double getBasePrice() {
        return menuItems.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public double getTax() {
        return getBasePrice() * 0.0725;
    }

    public double getTotal() {
        return getBasePrice() + getTax();
    }

    public String getOrderDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MenuItem menuItem : menuItems) {
            stringBuilder.append(menuItem.getDetails()).append("\n");
        }
        stringBuilder.append(String.format("Subtotal: $%.2f\n", getBasePrice()));
        stringBuilder.append(String.format("Tax: $%.2f\n", getTax()));
        stringBuilder.append(String.format("Total: $%.2f", getTotal()));
        return stringBuilder.toString();
    }
}
