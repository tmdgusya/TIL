package Chapter03.Item06;

public class test {
    public static void main(String[] args) {
        Integer s = Integer.valueOf("10");
        Integer d = Integer.valueOf("10");
        Integer f = Integer.valueOf("10");
        Integer g = Integer.valueOf("10");
        Integer h = Integer.valueOf("10");
        Integer k = Integer.parseInt("10");
        Integer z =  Integer.parseInt("10");
        Integer b = new Integer("10");

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
    }
}
