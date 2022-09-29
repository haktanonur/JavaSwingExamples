
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Mermi{
    private int x;
    private int y;

    public Mermi(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
} 
// KeyListener: klavye işlemlerimizi anlaması için, ActionListener : Topları ve uzay mekiğini hareket ettirmemiz için kullanır.
public class Oyun extends JPanel implements KeyListener,ActionListener{
    
    Timer timer = new Timer((int)1 , this);
    private int gecen_sure = 0;
    private int harcanan_mermi = 0;
    private BufferedImage image;
    private ArrayList<Mermi> mermiler = new ArrayList<Mermi>();
    
    private int mermidirY = 8;
    private int topX = 0; 
    private int topdirX = 10;
    private int uzayGemisiX = 0;
    private int dirUzayX = 30;
    
    public boolean kontrolEt(){
        
        for(Mermi mermi : mermiler){
            if(new Rectangle(mermi.getX(),mermi.getY(), 10, 20).intersects(new Rectangle(topX,0,20,20))){
                return true;
            }           
        }
        return false;
    }

    public Oyun() {
        
        try {
            image = ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setBackground(Color.BLACK);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        gecen_sure += 1;
        g.setColor(Color.red);
        g.fillOval(topX,0, 20, 20);
        g.drawImage(image, uzayGemisiX, 490,image.getWidth()/10 , image.getHeight()/10, this);
        
        for(Mermi mermi : mermiler){
            if(mermi.getY()<0){
                
                mermiler.remove(mermi);
                
            }
        }
        
        g.setColor(Color.BLUE);
        
        for(Mermi m : mermiler){
            g.fillRect(m.getX(), m.getY(), 10, 20);
        }
        
        if (kontrolEt()) {
            
            timer.stop();
            String mesaj = "        Kazandın \n"+
                           "Harcanan mermi : "+ harcanan_mermi+
                           "\nGeçen Süre : " + gecen_sure/100.0 + "saniye";
            JOptionPane.showMessageDialog(this, mesaj);
            System.exit(0);
            
        }
        
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int c = e.getKeyCode();
        
        if(c == KeyEvent.VK_LEFT){
            if (uzayGemisiX <=0) {
                uzayGemisiX = 0;
            }
            else{
                uzayGemisiX -=dirUzayX;
            }
        }
        if (c == KeyEvent.VK_RIGHT) {
            if (uzayGemisiX >= 740) {
                uzayGemisiX = 740;
            }
            else{
                uzayGemisiX += dirUzayX;
            }
        }
        else if (c == KeyEvent.VK_CONTROL) {
            
            mermiler.add(new Mermi(uzayGemisiX+15, 475));
            
            harcanan_mermi ++;
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(Mermi mermi : mermiler){
            
            mermi.setY(mermi.getY() - mermidirY);
            
        }
        
        topX += topdirX;
        
        if (topX >= 750) {
            
            topdirX = -topdirX;
            
        }
        if (topX <= 0) {
            
            topdirX = -topdirX;
            
        }
        
        repaint();
        
    }
    
    
    
}
