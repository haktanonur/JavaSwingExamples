
import java.awt.HeadlessException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author onurh
 */
public class AnaEkran extends JFrame{
    public static void main(String[] args) {
        GrafikKullanimi grafik = new GrafikKullanimi();
        AnaEkran ekran = new AnaEkran("Grafik Kullanımı");
        ekran.setVisible(true); // pencere açılsın
        ekran.setResizable(true); // pencereyi büyütüp küçültelim
        ekran.setSize(800, 600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ekran.add(grafik);
        
    }

    public AnaEkran(String title) throws HeadlessException {
        super(title);
    }
}
