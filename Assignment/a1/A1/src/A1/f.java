package A1;

public class f {
    public static  double g ( double x, int n) {
        // Pre-Condition: x is a non-zero real number and n is a natural number.
        // Post-Condition: returns xn
        if  (n == 0)  return 1 ;
        double z = g( x, n/2) ; z *= z ;    // blank line to be filled in
        return (n % 2 == 0) ?  z  :  z *x ;
    }

    public static void main( String[] args ) {
        System.out.println(g(2,3));
        System.out.println( 5 + 3 + 7 + "26" + 4 + 9);
    }
}
