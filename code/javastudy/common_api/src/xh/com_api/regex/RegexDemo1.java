package xh.com_api.regex;

public class RegexDemo1 {
    public static void main(String[] args) {
        System.out.println(checkQQ("121342342"));
        System.out.println(checkQQ("121"));
        System.out.println(checkQQ("dheuhde"));
        System.out.println(checkQQ2("121342342"));
        System.out.println(checkQQ2("121"));
        System.out.println(checkQQ2("dheuhde"));

    }

    //非正则表达式
    public static boolean checkQQ(String s){
        int len=s.length();
        if(len < 6 || len > 10)
            return false;

        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(c<'0'||c>'9')
                return false;
        }

        return true;

    }

    public static boolean checkQQ2(String s){
        return s!=null&&s.matches("\\d{6,20}");
    }

}
