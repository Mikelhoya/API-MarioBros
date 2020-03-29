import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Nivel1 extends World {
   private int x;
   private int y;
   private static int vidas;
   public static int posMarioX;
   public static int posMarioY;
   Scroller scroller;
   Mario mario;
   Goomba goomba;
   Mushroom mushroom;
   Coin coin;
   Bandera bandera;
   Tuberia tuberia;
   Tuberia tuberia2;
   Tuberia tuberia3;
   Tuberia tuberia4;
   Tuberia tuberia5;
   Tuberia tuberia6;
   GreenfootImage nivel1;
   Numero num;
   Block block;
   Escalon escalon;
   Musica musica;

   public Nivel1() {
      super(800, 448, 1, false);
      this.iniciarTodo();
   }

   public void act() {
      this.anadirNumero();
      if (this.mario != null) {
         this.scroll();
      }

      if (this.checkMuerto() && vidas != 0) {
         this.reducirVida();
      }

      this.checkAyuda();
   }

   public void checkAyuda() {
      if (Greenfoot.isKeyDown("F1")) {
         this.setBackground("manual-1.png");
         Greenfoot.stop();
      } else if (Greenfoot.isKeyDown("F2")) {
         Greenfoot.start();
      }

   }

   private void scroll() {
      int dsx = this.mario.getX() - 400;
      int dsy = this.mario.getY() - 224;
      this.scroller.scroll(dsx, dsy);
   }

   public void iniciarTodo() {
      this.nivel1 = new GreenfootImage("bgMarioTamDoble.png");
      int anchuraNivel = this.nivel1.getWidth();
      int alturaNivel = this.nivel1.getHeight();
      this.scroller = new Scroller(this, this.nivel1, anchuraNivel, alturaNivel);
      this.musica = new Musica();
      this.musica.start();
      this.num = new Numero();
      this.anadirBandera();
      this.anadirGoomba();
      this.anadirChampinon();
      this.anadirCoin();
      this.anadirMario();
      this.anadirTuberia();
      this.anadirBlocks();
      vidas = Vidas.obtVidas();
      this.scroll();
   }

   public boolean checkMuerto() {
      if (this.mario.getY() > 500) {
         this.musica.stop();
         Greenfoot.setWorld(new Nivel1());
         this.mario.muerto = false;
         return true;
      } else {
         return false;
      }
   }

   private void reducirVida() {
      Vidas.reducirVidas();
      vidas = Vidas.obtVidas();
      this.anadirNumero();
      if (vidas == 0) {
         Greenfoot.stop();
         this.musica.stop();
         Greenfoot.setWorld(new Fin());
      } else {
         Greenfoot.playSound("Die.mp3");
      }

   }

   private void anadirBlocks() {
      this.block = new Block();
      Block b1 = new Block();
      Block b2 = new Block();
      Block b3 = new Block();
      Block b4 = new Block();
      Block b5 = new Block();
      Block b6 = new Block();
      Block b7 = new Block();
      Block b8 = new Block();
      Block b9 = new Block();
      Block b10 = new Block();
      Block b11 = new Block();
      Block b12 = new Block();
      Block b13 = new Block();
      Block b14 = new Block();
      Block b15 = new Block();
      Block b16 = new Block();
      Block b17 = new Block();
      Block b18 = new Block();
      new Block();
      Block b20 = new Block();
      Block b21 = new Block();
      Block b22 = new Block();
      Block b23 = new Block();
      Block b24 = new Block();
      Block b25 = new Block();
      Block b26 = new Block();
      Block b27 = new Block();
      Block b28 = new Block();
      Escalon e1 = new Escalon();
      Escalon e2 = new Escalon();
      Escalon e3 = new Escalon();
      Escalon e4 = new Escalon();
      Escalon e5 = new Escalon();
      Escalon e6 = new Escalon();
      Escalon e7 = new Escalon();
      Escalon e8 = new Escalon();
      Escalon e9 = new Escalon();
      Escalon e10 = new Escalon();
      Escalon e11 = new Escalon();
      Escalon e12 = new Escalon();
      Escalon e13 = new Escalon();
      Escalon e14 = new Escalon();
      Escalon e15 = new Escalon();
      Escalon e16 = new Escalon();
      Escalon e17 = new Escalon();
      Escalon e18 = new Escalon();
      Escalon e19 = new Escalon();
      Escalon e20 = new Escalon();
      Escalon e21 = new Escalon();
      Escalon e22 = new Escalon();
      Escalon e23 = new Escalon();
      Escalon e24 = new Escalon();
      Escalon e25 = new Escalon();
      Escalon e26 = new Escalon();
      this.addObject(this.block, 527, 287);
      this.addObject(b1, 688, 287);
      this.addObject(b2, 656, 287);
      b2.setImage("bloque.png");
      this.addObject(b3, 752, 287);
      this.addObject(b4, 783, 287);
      b4.setImage("bloque.png");
      this.addObject(b5, 719, 159);
      this.addObject(b6, 2689, 159);
      b6.setImage("bloque8.png");
      this.addObject(b7, 2480, 287);
      b7.setImage("bloque.png");
      this.addObject(b8, 2542, 287);
      b8.setImage("bloque.png");
      this.addObject(b9, 2512, 287);
      this.addObject(b10, 2961, 159);
      b10.setImage("bloque3.png");
      this.addObject(b11, 3024, 159);
      this.addObject(b12, 3023, 287);
      b12.setImage("bloque.png");
      this.addObject(b13, 3231, 287);
      b13.setImage("bloque2.png");
      this.addObject(b14, 3503, 159);
      this.addObject(b15, 3407, 287);
      this.addObject(b16, 3503, 287);
      this.addObject(b17, 3599, 287);
      this.addObject(b18, 3791, 287);
      b18.setImage("bloque.png");
      this.addObject(b20, 3919, 159);
      b20.setImage("bloque3.png");
      this.addObject(b21, 4159, 287);
      b21.setImage("bloque2.png");
      this.addObject(b22, 4112, 159);
      b22.setImage("bloque.png");
      this.addObject(b23, 4206, 159);
      b23.setImage("bloque.png");
      this.addObject(b24, 4175, 159);
      this.addObject(b25, 4145, 159);
      this.addObject(b26, 5408, 287);
      b26.setImage("bloque2.png");
      this.addObject(b27, 5486, 287);
      b27.setImage("bloque.png");
      this.addObject(b28, 5455, 287);
      this.addObject(e1, 4304, 384);
      this.addObject(e2, 4336, 352);
      this.addObject(e3, 4368, 320);
      this.addObject(e4, 4400, 288);
      this.addObject(e5, 4496, 288);
      this.addObject(e6, 4528, 320);
      this.addObject(e7, 4560, 352);
      this.addObject(e8, 4592, 384);
      this.addObject(e9, 4592, 384);
      this.addObject(e10, 4752, 384);
      this.addObject(e11, 4784, 352);
      this.addObject(e12, 4816, 320);
      this.addObject(e13, 4848, 288);
      this.addObject(e14, 4880, 288);
      this.addObject(e15, 4976, 288);
      this.addObject(e16, 5008, 320);
      this.addObject(e17, 5040, 352);
      this.addObject(e18, 5072, 384);
      this.addObject(e19, 5807, 384);
      this.addObject(e20, 5840, 352);
      this.addObject(e21, 5872, 320);
      this.addObject(e22, 5904, 288);
      this.addObject(e23, 5936, 256);
      this.addObject(e24, 5968, 224);
      this.addObject(e25, 6000, 192);
      this.addObject(e26, 6032, 160);
   }

   private void anadirNumero() {
      vidas = Vidas.obtVidas();
      this.num = new Numero();
      if (vidas == 3) {
         this.num.setImage("3.png");
      } else if (vidas == 2) {
         this.num.setImage("2.png");
      } else if (vidas == 1) {
         this.num.setImage("1.png");
      }

      this.addObject(this.num, 30, 30);
   }

   private void anadirBandera() {
      this.bandera = new Bandera();
      this.bandera.setImage("bandera.png");
      this.addObject(this.bandera, 6351, 243);
   }

   private void anadirTuberia() {
      this.tuberia = new Tuberia();
      this.tuberia.setImage("tuberia.jpeg");
      this.tuberia2 = new Tuberia();
      this.tuberia2.setImage("tuberia2.jpeg");
      this.tuberia3 = new Tuberia();
      this.tuberia3.setImage("tuberia3.jpeg");
      this.tuberia4 = new Tuberia();
      this.tuberia4.setImage("tuberia3.jpeg");
      this.tuberia5 = new Tuberia();
      this.tuberia5.setImage("tuberia.jpeg");
      this.tuberia6 = new Tuberia();
      this.tuberia6.setImage("tuberia.jpeg");
      this.addObject(this.tuberia, 927, 368);
      this.addObject(this.tuberia2, 1247, 353);
      this.addObject(this.tuberia3, 1504, 337);
      this.addObject(this.tuberia4, 1856, 337);
      this.addObject(this.tuberia5, 5248, 337);
      this.addObject(this.tuberia6, 5759, 368);
   }

   public void anadirMario() {
      this.mario = new Mario();
      posMarioX = 30;
      posMarioY = 370;
      this.addObject(this.mario, 30, 370);
   }

   public void anadirGoomba() {
      this.goomba = new Goomba();
      Goomba g2 = new Goomba();
      Goomba g3 = new Goomba();
      Goomba g4 = new Goomba();
      Goomba g5 = new Goomba();
      Goomba g6 = new Goomba();
      Goomba g7 = new Goomba();
      Goomba g8 = new Goomba();
      Goomba g9 = new Goomba();
      Goomba g10 = new Goomba();
      Goomba g11 = new Goomba();
      Goomba g12 = new Goomba();
      Goomba g13 = new Goomba();
      Goomba g14 = new Goomba();
      Goomba g15 = new Goomba();
      Goomba g16 = new Goomba();
      this.addObject(this.goomba, 638, 384);
      this.addObject(g2, 1340, 384);
      this.addObject(g3, 1632, 384);
      this.addObject(g4, 1680, 384);
      this.addObject(g5, 2580, 384);
      this.addObject(g6, 2606, 384);
      this.addObject(g7, 3058, 384);
      this.addObject(g8, 3086, 384);
      this.addObject(g9, 3620, 384);
      this.addObject(g10, 3648, 384);
      this.addObject(g11, 3960, 384);
      this.addObject(g12, 3988, 384);
      this.addObject(g13, 4254, 384);
      this.addObject(g14, 4226, 384);
      this.addObject(g15, 5500, 384);
      this.addObject(g16, 5528, 384);
   }

   public void anadirChampinon() {
      this.mushroom = new Mushroom();
      this.mushroom.getImage().clear();
      this.addObject(this.mushroom, 673, 272);
      this.addObject(this.mushroom, 3488, 144);
   }

   public void anadirCoin() {
      this.coin = new Coin();
      this.coin.getImage().clear();
      this.addObject(this.coin, 528, 285);
      this.addObject(this.coin, 754, 285);
      this.addObject(this.coin, 720, 157);
      this.addObject(this.coin, 2514, 285);
      this.addObject(this.coin, 3026, 157);
      this.addObject(this.coin, 3408, 285);
      this.addObject(this.coin, 3504, 285);
      this.addObject(this.coin, 3600, 285);
      this.addObject(this.coin, 5457, 285);
   }
}
