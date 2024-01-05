package Kiosk;

public class Pizza extends Menu {
    public int price;

    public int getPrice() {
        return price;
    }

    public Pizza(int menuNumber, String menuName, String menuDesc, int price) {
        super(menuNumber, menuName, menuDesc);
        this.price = price;
    }

    public void getMenuToString() {
        System.out.println(getMenuNumber() + ". " + getMenuName() + " | " + getMenuDesc() + " | " + getPrice());
    }

}
