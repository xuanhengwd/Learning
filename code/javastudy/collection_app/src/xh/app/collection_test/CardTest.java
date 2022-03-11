package xh.app.collection_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardTest {

    public static List<Card> cards = new ArrayList<>();

    static {
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        String[] colors = {"♠", "♥", "♣", "♦"};
        int index=0;
        for (String s : sizes) {
            index++;
            for(String c : colors){
                Card card = new Card(s,c,index);
                cards.add(card);

            }
        }

        Card c1 = new Card("小王","🃏",++index);
        Card c2 = new Card("大王","👲",++index);
        Collections.addAll(cards,c1,c2);
    }

    public static void main(String[] args) {

        System.out.println(cards);
        Collections.shuffle(cards);
        System.out.println("洗牌后");
        System.out.println(cards);
        //定义三个玩家
        List<Card> p1 = new ArrayList<>();
        List<Card> p2 = new ArrayList<>();
        List<Card> p3 = new ArrayList<>();


        for(int i=0;i<cards.size()-3;i++)
        {
            Card c = cards.get(i);
            if(i%3==0){
                p1.add(c);
            }
            else if (i%3==1){
                p2.add(c);
            }
            else if(i%3==2){
                p3.add(c);
            }
        }

        //地主牌
        List<Card> last = cards.subList(cards.size()-3, cards.size());
        cardSort(p1);
        cardSort(p2);
        cardSort(p3);
        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);
        System.out.println("p3:"+p3);
        System.out.println("last3:"+last);


    }

    public static void cardSort(List<Card> p){
        p.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getIndex()-o1.getIndex();
            }
        });
    }
}
