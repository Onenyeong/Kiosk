package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    private int menuNumber;
    private String menuName;
    private String menuDesc;
    private int price;
    List<OrderBasket> orderBaskets = OrderBasket.orderBaskets;

    OrderBasket orderBasket = new OrderBasket();

    public Order() {
    }


    public void getHamburgerAndOrder() {
        System.out.println("번호를 입력하세요");
        Scanner scan = new Scanner(System.in);
        int menuNumber = scan.nextInt();
        System.out.println("수량을 입력하세요");
        int quantity = scan.nextInt();

        switch (menuNumber) {       // 의식의 흐름대로 짜버림.. 기존 For문
            case 1:
                orderBaskets.add(new OrderBasket(1, "불고기 버거", "불고기에 소스만 바른 버거", 3800, quantity));
                break;
            case 2:
                orderBaskets.add(new OrderBasket(2, "새우 버거", "새우만 넣은 버거", 4200, quantity));
                break;
            case 3:
                orderBaskets.add(new OrderBasket(3, "맥스파이시 상하이버거", "꽤나 매운 버거", 5500, quantity));
                break;
            case 4:
                orderBaskets.add(new OrderBasket(4, "빅맥", "소고기 들어간 버거", 6400, quantity));
                break;
            case 5:
                orderBaskets.add(new OrderBasket(5, "쿼터 파운더 치즈", "치즈 듬뿍 들어간 버거", 7000, quantity));
                break;
        }
        orderBasket.showOrderBasket();
        // 추가로 주문하시겠습니까? 예, 아니오
        // 예 클릭시 항목 다시한번 보여주기
        // 아니오 클릭시 메뉴로 돌아가기
    }


}

