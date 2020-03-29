import greenfoot.Actor;

public class Vidas extends Actor {
   static int vidas = 3;

   public static void reducirVidas() {
      --vidas;
   }

   public static int obtVidas() {
      return vidas;
   }
}
