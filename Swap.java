public class Swap {
    public static synchronized void execute(boolean[] m1, boolean[] m2) {
        boolean t = m1[0];
        m1[0] = m2[0];
        m2[0] = t;
    }
}
