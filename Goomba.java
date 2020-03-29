import greenfoot.Actor;

public class Goomba extends Actor {
   boolean toca;

   public void act() {
      if (this.tuberita()) {
         this.move(150);
      } else {
         this.move(-1);
      }

   }

   public boolean tuberita() {
      Actor actor = this.getOneIntersectingObject(Tuberia.class);
      if (actor instanceof Tuberia) {
         this.toca = true;
      } else {
         this.toca = false;
      }

      return this.toca;
   }
}
