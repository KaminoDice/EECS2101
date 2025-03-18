package A1;

public class Mystery {
    public static void main(String[] args) {
        int[] a = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        for (int e : a) {  a[e] = e;	System.out.print(" " + e);	   }
    }
}

