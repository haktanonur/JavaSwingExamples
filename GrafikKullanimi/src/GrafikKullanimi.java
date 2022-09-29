import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author onurh
 */
public class GrafikKullanimi extends JPanel{

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.red);
        
        g.drawRect(30,70,50,30);
        g.fillRect(120, 150, 50, 30);
        g.fill3DRect(250, 200, 25, 45, true);
        
        g.setColor(Color.yellow);
        
        g.fillOval(500, 300, 45, 45);
        
        g.drawLine(50, 50, 70, 70);
        
    }

    public GrafikKullanimi() {
        setBackground(Color.black);
    }
    
    
    
}
