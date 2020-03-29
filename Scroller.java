import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;
import java.util.Iterator;

public class Scroller {
   private World world;
   private GreenfootImage scrollImage;
   private boolean limited;
   private int scrolledX;
   private int scrolledY;
   private int wide;
   private int high;

   public Scroller(World viewWorld, GreenfootImage image) {
      this.world = viewWorld;
      this.scrollImage = image;
      if (image != null) {
         this.wide = image.getWidth();
         this.high = image.getHeight();
      }

      this.scroll(0, 0);
   }

   public Scroller(World viewWorld, GreenfootImage image, int wide, int high) {
      this.wide = wide;
      this.high = high;
      this.limited = true;
      this.world = viewWorld;
      if (image != null) {
         this.scrollImage = new GreenfootImage(wide * this.world.getCellSize(), high * this.world.getCellSize());

         for(int x = 0; x < wide * this.world.getCellSize(); x += image.getWidth()) {
            for(int y = 0; y < high * this.world.getCellSize(); y += image.getHeight()) {
               this.scrollImage.drawImage(image, x, y);
            }
         }

         this.scroll(0, 0);
      }

   }

   public void scroll(int dsx, int dsy) {
      int imageX;
      int imageY;
      if (this.limited) {
         imageX = this.wide - this.world.getWidth();
         imageY = this.high - this.world.getHeight();
         if (this.scrolledX + dsx < 0) {
            dsx = -this.scrolledX;
         }

         if (this.scrolledX + dsx >= imageX) {
            dsx = imageX - this.scrolledX;
         }

         if (this.scrolledY + dsy < 0) {
            dsy = -this.scrolledY;
         }

         if (this.scrolledY + dsy >= imageY) {
            dsy = imageY - this.scrolledY;
         }

         this.scrolledX += dsx;
         this.scrolledY += dsy;
         if (this.scrollImage != null) {
            this.world.getBackground().drawImage(this.scrollImage, -this.scrolledX * this.world.getCellSize(), -this.scrolledY * this.world.getCellSize());
         }
      } else {
         this.scrolledX += dsx;
         this.scrolledY += dsy;
         if (this.scrollImage != null) {
            imageX = this.scrolledX * this.world.getCellSize();
            imageY = this.scrolledY * this.world.getCellSize();
            imageX %= this.wide;
            imageY %= this.high;
            if (imageX < 0) {
               imageX += this.wide;
            }

            if (imageY < 0) {
               imageY += this.high;
            }

            GreenfootImage hold = new GreenfootImage(this.scrollImage);
            hold.drawImage(this.scrollImage, -imageX, -imageY);
            if (imageX > 0) {
               hold.drawImage(this.scrollImage, this.wide - imageX, -imageY);
            }

            if (imageY > 0) {
               hold.drawImage(this.scrollImage, -imageX, this.high - imageY);
            }

            if (imageX > 0 && imageY > 0) {
               hold.drawImage(this.scrollImage, this.wide - imageX, this.high - imageY);
            }

            this.world.setBackground(hold);
         }
      }

      Iterator var6 = this.world.getObjects((Class)null).iterator();

      while(var6.hasNext()) {
         Object obj = var6.next();
         Actor actor;
         if (obj instanceof Mario) {
            actor = (Actor)obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
         } else if (obj instanceof Goomba) {
            actor = (Actor)obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
         } else if (obj instanceof Tuberia) {
            actor = (Actor)obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
         } else if (obj instanceof Bandera) {
            actor = (Actor)obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
         } else if (obj instanceof Block) {
            actor = (Actor)obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
         } else if (obj instanceof Escalon) {
            actor = (Actor)obj;
            actor.setLocation(actor.getX() - dsx, actor.getY() - dsy);
         }
      }

   }

   public int getScrolledX() {
      return this.scrolledX;
   }

   public int getScrolledY() {
      return this.scrolledY;
   }
}
