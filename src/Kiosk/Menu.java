package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private int menuNumber;
    private String menuName;
    private String menuDesc;
    private int price;
    List<Menu> menu = new ArrayList<>();


    List<Hamburger> hamburger = new ArrayList<>();
    List<Pizza> pizza = new ArrayList<>();
    List<Chicken> chicken = new ArrayList<>();

    List<Drink> drink = new ArrayList<>();
    Order order = new Order();
    OrderBasket orderBasket = new OrderBasket();
    OrderTimer orderTimer = new OrderTimer();

    public int getMenuNumber() {
        return menuNumber;
    }


    public String getMenuName() {
        return menuName;
    }


    public String getMenuDesc() {
        return menuDesc;
    }


    public int getPrice() {
        return price;
    }


    public Menu(int menuNumber, String menuName, String menuDesc) {
        this.menuNumber = menuNumber;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
    }

    public Menu(int menuNumber, String menuName, String menuDesc, int price) {
        this.menuNumber = menuNumber;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.price = price;
    }

    public Menu() {

    }


    public void menuAdd() {
        menuCategoryWelcomeView();
        menu.add(new Menu(1, "Burgers", "햄버거"));
        menu.add(new Menu(2, "Pizza", "피자"));
        menu.add(new Menu(3, "Chicken", "치킨"));
        menu.add(new Menu(4, "Drinks", "음료수"));
        menu.add(new Menu(5, "OrderCheck", "주문확인 및 주문진행"));
        menu.add(new Menu(6, "Cancel", "주문취소"));
        menu.add(new Menu(7, "Clear", "모두비우기"));

        menuCategoryView();
        menuCategoryEndView();
    }

    // 주문취소를 통해 되돌아갔을경우. 추가주문을 해야하는 경우
    public void menuSelectSwitch() {


        while (true) {
            int inputMenuNumber = getMenuNumberFromUsr();
            switch (inputMenuNumber) {
                case 1:
                    addBurger();
                    // 케이스에 두번 접근해야 할 경우 버거의 종류를 두번 add하기떄문에 예외처리 필요
                    hamburgerMenuView();
                    order.getHamburgerAndOrder();
                    // 뒤로가기 예외처리 (구매를 하고싶지 않을경우)
                    break;
                case 2:
                    addPizza();
                    pizzaMenuView();
                    break;
                case 3:
                    addChicken();
                    chickenMenuView();
                    break;
                case 4:
                    addDrink();
                    drinkMenuView();
                    break;
                case 5:
                    orderBasket.showOrderBasket();
                    int orderConfirmNumber = getConfirmNumberFromUsr();
                    if (orderConfirmNumber == 0) {
                        System.out.println("주문이 완료되었습니다");
                        orderBasket.showOrderTotal();
                        orderTimer.timerRun();
                    } else {
                        System.out.println("취소되었습니다. 메뉴로 돌아갑니다");
                        getReturnMenuCategoryView();
                    }
                    break;

                case 6:
                    orderBasket.showOrderBasket();
                    orderBasket.cancleOrderBasket();
                    break;
                case 7:
                    orderBasket.clearOrderBasket();
            }
            getReturnMenuCategoryView();

        }


    }

    private static int getConfirmNumberFromUsr() {
        System.out.println("주문하시겠습니까?(주문하려면 0번을 눌러주시고 아니면 1번을 눌러주세요");
        return getUsrIntInput();
    }

    private static int getMenuNumberFromUsr() {
        System.out.println("메뉴에 대해서 자세히 보시려면 해당번호를 입력해주세요");
        return getUsrIntInput();
    }

    private static int getUsrIntInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public void menuCategoryView() {
        for (Menu item : menu) {
            item.getCategoryToString();
        }
    }

    public void menuCategoryWelcomeView() {
        System.out.println("====================피치버거에 오신걸 환영합니다====================");
    }

    public void menuCategoryEndView() {
        System.out.println("============================================================");
    }

    public void hamburgerMenuView() {
        for (Hamburger item : hamburger) {
            item.getMenuToString();
        }
    }

    public void pizzaMenuView() {
        for (Pizza item : pizza) {
            item.getMenuToString();
        }
    }

    public void chickenMenuView() {
        for (Chicken item : chicken) {
            item.getMenuToString();
        }
    }

    public void drinkMenuView() {
        for (Drink item : drink) {
            item.getMenuToString();
        }
    }

    public void getReturnMenuCategoryView() {
        menuCategoryWelcomeView();
        menuCategoryView();
        menuCategoryEndView();
    }

    public void getCategoryToString() {
        System.out.println(getMenuNumber() + ". " + getMenuName() + " | " + getMenuDesc());
    }

    public void getMenuToString() {
        System.out.println(getMenuNumber() + ". " + getMenuName() + " | " + getMenuDesc() + " | " + getPrice());
    }

    // String 으로 변환 작업.
    public void addDrink() {
        drink.add(new Drink(1, "코카콜라제로", "불고기에 소스만 바른 버거", 2000));
        drink.add(new Drink(2, "펩시제로", "새우만 넣은 버거", 1800));
        drink.add(new Drink(3, "환타", "꽤나 매운 버거", 1700));
        drink.add(new Drink(4, "사이다", "소고기 들어간 버거", 2300));

    }

    public void addChicken() {
        chicken.add(new Chicken(1, "후라이드치킨", "후라이드 치킨의 교과서", 16000));
        chicken.add(new Chicken(2, "양념치킨", "싫어할 사람은 없겠죠?", 18000));
        chicken.add(new Chicken(3, "간장치킨", "간장의 짭조롬함을 좋아한다면", 17000));
    }

    public void addPizza() {
        pizza.add(new Pizza(1, "콤비네이션 피자", "토핑의 조화를 원한다면", 13500));
        pizza.add(new Pizza(2, "불새 피자", "불고기와 새우가 만나", 15000));
        pizza.add(new Pizza(3, "불갈비 피자", "불갈비를 맛보고싶다면", 16000));
        pizza.add(new Pizza(4, "휴게소 피자", "휴게소의 감자와 소시지의 합작", 14000));
    }

    public void addBurger() {
        hamburger.add(new Hamburger(1, "불고기 버거", "불고기에 소스만 바른 버거", 3800));
        hamburger.add(new Hamburger(2, "새우 버거", "새우만 넣은 버거", 4200));
        hamburger.add(new Hamburger(3, "맥스파이시 상하이버거", "꽤나 매운 버거", 5500));
        hamburger.add(new Hamburger(4, "빅맥", "소고기 들어간 버거", 6400));
        hamburger.add(new Hamburger(5, "쿼터 파운더 치즈", "치즈 듬뿍 들어간 버거", 7000));

    }


}



