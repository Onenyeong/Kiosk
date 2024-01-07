package Kiosk;

import java.util.*;
import java.util.stream.Collectors;

public class OrderBasket {
    static List<OrderBasket> orderBaskets = new ArrayList<>();
    // static 접근시 주의해야할듯
    int menuNumber;
    String menuName;
    String menuDesc;
    int quantity;
    int price;


    public OrderBasket(int menuNumber, String menuName, String menuDesc, int price, int quantity) {
        this.menuNumber = menuNumber;
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderBasket() {
    }

    public void cancleOrderBasket() {
        System.out.println("몇번의 주문을 취소하시겠습니까?");
        Scanner scan = new Scanner(System.in);
        int orderNumber = scan.nextInt();
//            orderBaskets.remove(orderBaskets.indexOf(orderNumber));
//        System.out.println(orderBaskets.get(i));      // 주소만 출력되는게 정상임.
        // i번째 방이 없는데 오류가 안났다?? 예외처리 필요했던 상황임.
        orderBaskets.remove(orderNumber - 1);   //  리스트는 0부터시작.
//            System.out.println(orderBaskets.indexOf(orderNumber));  //
    }

    public void clearOrderBasket() {
        System.out.println("정말로 지우시겠습니까?");
        Scanner scan = new Scanner(System.in);
        int checkNumber = scan.nextInt();
        if (checkNumber == 0) {
            orderBaskets.clear();
            System.out.println("모두 삭제되었습니다");
        } else if (checkNumber == 1) {
            System.out.println("취소되었습니다 메뉴화면으로 이동합니다.");
        }
    }

    public void showOrderTotal() {
        int orderTotal = 0;

        for (int i = 0; i < orderBaskets.size(); i++) {
            int basketTotal = orderBaskets.get(i).price * orderBaskets.get(i).quantity;
            orderTotal += basketTotal;  // 각 리스트의 합한값을 넣어야하는데
        }
        System.out.println("결제하신 금액은" + orderTotal + "입니다.");
    }

    public void showOrderBasket() {

        /* Edit by YuJin */

        // 주문 내역을 메뉴 이름을 기준으로 그룹화하고, 수량과 가격을 합산

        // key를 메뉴 이름으로 하고 value에 OrderBasket을 넣는다.
        Map<String, OrderBasket> consolidatedOrders = new HashMap<>();

        // 메뉴를 반복문으로 순회한다.
        for (OrderBasket basket : orderBaskets) {
            // 만약 map에 메뉴가 있으면 (중복된 메뉴라면) 수량과 가격을 합산한다.
            if (consolidatedOrders.containsKey(basket.menuName)) {
                OrderBasket existingBasket = consolidatedOrders.get(basket.menuName);
                existingBasket.quantity += basket.quantity;
                existingBasket.price += basket.price;
            }

            // 그렇지 않다면 map에 메뉴를 추가한다.
            else {
                consolidatedOrders.put(basket.menuName, new OrderBasket(basket.menuNumber, basket.menuName, basket.menuDesc, basket.price, basket.quantity));
            }
        }

        // 최종 주문 내역 출력
        int index = 1;
        for (OrderBasket basket : consolidatedOrders.values()) {
            System.out.println(index + ". " + basket.menuName + ", " + basket.menuDesc + ", " + basket.quantity + ", " + (basket.price * basket.quantity));
            index++;
        }


        /* ======================================= */


//        int finalQuantity = 0;
//        int finalPrice = 0;
//        // 값을 빼고, 새로운 객체를 생성, for문 돌때마다 add로 값을 채워줌.
//        for (int i = 0; i < orderBaskets.size(); i++) {      // 함수화 (orderBasket에서 정의했어야)
//            for (int j = i + 1; j < orderBaskets.size(); j++) {     // map,list(포인터), 어떤방식 사용할지 키워드 묻기
//                // i와 j의 중복되는 위치의 이름을 어떻게 반환하지?
//                if (orderBaskets.get(i).menuName.equals(orderBaskets.get(j).menuName)) {
//                    finalQuantity = orderBaskets.get(i).quantity + orderBaskets.get(j).quantity;
//                    finalPrice = orderBaskets.get(i).price + orderBaskets.get(j).price; // 메뉴이름은 변경할필요가없음
//                }
//                continue;
//            }
//        }
//        setQuantity(finalQuantity);
//        setPrice(finalPrice);

        // 순회하면서 같은 이름 || 같은 설명이 있다면 quantity 갖고있는만큼 더해줘
        // 리스트를 하나더 클론해서..비교


//        for (int i = 0; i < orderBaskets.size(); i++) {
//            System.out.println((i + 1) + ". " + orderBaskets.get(i).menuName + orderBaskets.get(i).menuDesc + (orderBaskets.get(i).price * orderBaskets.get(i).quantity) + orderBaskets.get(i).quantity);
//        }
    }

    private void setPrice(int price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

