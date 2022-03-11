package xh.app.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<Movie> movies = new ArrayList<>();
        movies.add(new Movie("肖申克的救赎","弗兰克",9.7));
        movies.add(new Movie("霸王别姬","程凯歌",9.5));
        movies.add(new Movie("阿甘正传","罗伯特",9.5));
        System.out.println(movies);

        for (Movie m :
                movies) {
            System.out.println("名称："+m.getName());
            System.out.println("导演："+m.getAuthor());
            System.out.println("评分："+m.getScore());

        }


    }
}
