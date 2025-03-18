package A1;
public class Pattern {
    public static void pattern(int n, int m) {
        if (n <= 0 && m <= 0) return;
        if (n > 0 && n % 2 == 0)  System.out.print(n + " ");
        pattern(n - 1, m - 1);
        if (m > 0 && m % 2 == 1) System.out.print(m + " ");
    }

    public static void main(String[] args) {
        pattern(15, 7);
    }
}