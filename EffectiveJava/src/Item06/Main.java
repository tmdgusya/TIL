package Item06;

public class Main {


    public static void main(String[] args) {
        String gd = "10";
        String dz = "10";
        String s = String.valueOf(10);
        String d = String.valueOf(10);
        String f = String.valueOf(10);
        String g = String.valueOf(10);
        String h = String.valueOf(10);
        String k = Integer.toString(10);
        String z = Integer.toString(10);
        String b = new String("10");

        System.out.println(System.identityHashCode(gd));
        System.out.println(System.identityHashCode(dz));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(f));
        System.out.println(System.identityHashCode(g));
        System.out.println(System.identityHashCode(h));
        System.out.println(System.identityHashCode(k));
        System.out.println(System.identityHashCode(z));
        System.out.println(System.identityHashCode(b));

        System.out.println(s.hashCode());
        System.out.println(d.hashCode());
        System.out.println(f.hashCode());
        System.out.println(g.hashCode());
        System.out.println(h.hashCode());
        System.out.println(k.hashCode());
        System.out.println(z.hashCode());
        System.out.println(b.hashCode());

        /*System.identityHashCode()
        * System 클래스의 identityHashCode 메서드로 객체가 메모리에서 가진 해쉬 주소값을 출력한다.
        * 즉 이게 OS(System) 에서 가지는 해쉬값이다.
        * */

        /* Object.hashCode()
        *  객체가 메모리에서 가진 해쉬 주소값을 출력한다.
        *  즉, 이게 Java(Application)_에서 가지는 해쉬값이다.
        * */
    }

}
