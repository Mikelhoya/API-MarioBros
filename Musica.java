import greenfoot.Actor;
import greenfoot.GreenfootSound;

public class Musica extends Actor {
   GreenfootSound theme = new GreenfootSound("mainTheme (online-audio-converter.com).mp3");

   public void start() {
      this.theme.playLoop();
   }

   public void stop() {
      this.theme.setVolume(0);
   }
}
