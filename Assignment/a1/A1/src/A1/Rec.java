package A1;

public class Rec {
    public static int mystery( int n )  {
        if (n > 56) return n - 3;
        return mystery( mystery(n + 4) + 1 );
    }
    public static void main(String[] args) {
        System.out.println(mystery(55));
    }
}
