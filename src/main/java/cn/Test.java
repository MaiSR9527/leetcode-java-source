package cn;


/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-09-06 19:55:59
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "he"+"llo";
        String s2 = "hello";
        System.out.println(s2==s1); // true
        int a = 3;
        int b = 3;
        a = a ^ b;
        System.out.println(a);
        b = a ^ b;
        System.out.println(b);
        a = a ^ b;
        System.out.println(a + "," + b);
    }

    private static void stet1() {
        String s1 = new String("hello");
        String intern = s1.intern();
        String s2 = "hello";
        System.out.println(s2==s1);
        System.out.println(s2==intern);
    }
}
