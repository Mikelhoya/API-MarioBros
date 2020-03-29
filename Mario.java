import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Mario extends Actor {
   private int vSpeed = 0;
   private int acceleration = 1;
   private int jumpHeight = -18;
   private boolean der = true;
   private boolean right = true;
   public boolean muerto = false;
   boolean suelo = true;
   private int MarioCounter = 0;

   public void act() {
      this.moveAround();
      this.checkFalling();
      this.checkGoomba();
      this.checkFlag();
      ++this.MarioCounter;
      this.animarMario();
   }

   private void moveAround() {
      if (Greenfoot.isKeyDown("left") && (!this.checkPipe() || this.checkPipe() && this.der) && (!this.checkEscalon() || this.checkEscalon() && this.der)) {
         this.setLocation(this.getX() - 5, this.getY());
         Nivel1.posMarioX -= 5;
         this.der = false;
      }

      if (Greenfoot.isKeyDown("right") && (!this.checkPipe() || this.checkPipe() && !this.der) && (!this.checkEscalon() || this.checkEscalon() && !this.der)) {
         this.der = true;
         this.setLocation(this.getX() + 5, this.getY());
         Nivel1.posMarioX += 5;
      }

      if ((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up")) && this.onGround()) {
         this.vSpeed = this.jumpHeight;
         Greenfoot.playSound("Big Jump.wav");
         this.fall();
         if (this.der) {
            this.setImage("jump_right.png");
         } else {
            this.setImage("jump_left.png");
         }
      }

   }

   public void animarMario() {
      if (Greenfoot.isKeyDown("right")) {
         if (this.MarioCounter <= 12) {
            this.setImage("walk_right1.png");
            ++this.MarioCounter;
         }

         if (this.MarioCounter > 13 && this.MarioCounter <= 25) {
            this.setImage("walk_right2.png");
            ++this.MarioCounter;
         }

         if (this.MarioCounter >= 26) {
            this.MarioCounter = 0;
         }
      }

      if (Greenfoot.isKeyDown("left")) {
         if (this.MarioCounter <= 12) {
            this.setImage("walk_left1.png");
            ++this.MarioCounter;
         }

         if (this.MarioCounter > 13 && this.MarioCounter <= 25) {
            this.setImage("walk_left2.png");
            ++this.MarioCounter;
         }

         if (this.MarioCounter >= 26) {
            this.MarioCounter = 0;
         }
      }

      if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up")) {
         if (this.der) {
            this.setImage("jump_right.png");
         } else {
            this.setImage("jump_left.png");
         }
      }

   }

   public boolean onGround() {
      if ((this.getY() != 370 || !this.checkFloor()) && !this.isTouching(Block.class) && !this.isTouching(Escalon.class) && !this.isTouching(Tuberia.class)) {
         if (this.getY() >= 370 && this.getY() <= 400 && !this.muerto && this.suelo) {
            if (this.getY() > 370) {
               this.setLocation(this.getX(), 370);
            }

            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   private boolean checkFloor() {
      int x = Nivel1.posMarioX;
      if ((x < 2209 || x > 2273) && (x < 2751 || x > 2849) && (x < 4895 || x > 4963)) {
         this.suelo = true;
         return true;
      } else {
         this.suelo = false;
         return false;
      }
   }

   private boolean checkPipe() {
      int x = Nivel1.posMarioX;
      int y = Nivel1.posMarioY;
      return this.isTouching(Tuberia.class);
   }

   private boolean checkEscalon() {
      int x = Nivel1.posMarioX;
      int y = Nivel1.posMarioY;
      return this.isTouching(Escalon.class);
   }

   private boolean checkBlock() {
      int x = Nivel1.posMarioX;
      int y = Nivel1.posMarioY;
      return this.isTouching(Block.class);
   }

   private void checkFalling() {
      if (!this.onGround()) {
         this.fall();
      }

      if (this.onGround()) {
         this.vSpeed = 0;
         if (this.der) {
            this.setImage("still_right.png");
         } else {
            this.setImage("still_left.png");
         }
      }

   }

   private void checkGoomba() {
      if (this.isTouching(Goomba.class)) {
         this.muerto = true;
         this.vSpeed = 2;
         this.fall();
      }

   }

   private void checkFlag() {
      if (this.isTouching(Bandera.class)) {
         Greenfoot.setWorld(new Meta());
      }

   }

   private void fall() {
      this.setLocation(this.getX(), this.getY() + this.vSpeed);
      Nivel1.posMarioY += this.vSpeed;
      this.vSpeed += this.acceleration;
      Actor actor = this.getOneIntersectingObject(Goomba.class);
      if (actor instanceof Mario) {
         this.removeTouching(Goomba.class);
      }

   }
}
