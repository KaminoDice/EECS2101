package A1;
public class Diet {
    static class Food { public Food() {  System.out.print ( "<My Favorite>" );  }   }
    static class Meet extends Food { public Meet() {  System.out.print ("<Calorie Source>" );  }  }
    static class Poultry extends Meet { public Poultry() {  System.out.print ( "<Less Purine>" );  }  }
    public static void main( String[] args ) {  Poultry dinner = new Poultry();  }
}