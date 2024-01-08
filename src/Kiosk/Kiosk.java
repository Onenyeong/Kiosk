package Kiosk;

import java.util.Timer;
import java.util.TimerTask;


public class Kiosk {


    public static void main(String[] args) {

        // 메뉴 추가 메서드
        Menu menu = new Menu();
        menu.addMenuView();
        // 카테고리 선택 메서드
        // 상품번호,수량을 입력받는 메서드
        // 입력받은 내용 넣기
        // 메뉴로 돌아가기, 보여주기
        // 수량,상품 다시 입력하는 메서드
        menu.menuSelectSwitch();


    }

    // 그만 주문하고싶으면 "주문확정" or "주문취소" 예외처리필요

    // 장바구니에 담긴 내용 꺼내서 게산해서 출력

}

