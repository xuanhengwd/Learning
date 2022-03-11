package xh.com_api.regex;

public class RegexDemo2 {
    public static void main(String[] args) {
        System.out.println("a".matches("[abc]"));
        System.out.println("ab".matches("[abc]"));
        System.out.println("ab".matches("[abc]+"));

        System.out.println("a".matches("^[abc]"));
        System.out.println("z".matches("^[abc]"));


    }
}
