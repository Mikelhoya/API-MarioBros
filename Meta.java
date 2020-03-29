import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Meta extends World {
   GreenfootImage meta;
   Musica musica = new Musica();

   public Meta() {
      super(800, 448, 1, false);
      this.musica.stop();
      Greenfoot.playSound("nivelacabado.mp3");
      this.meta = new GreenfootImage("victoria.png");
      this.setBackground(this.meta);
   }
}
