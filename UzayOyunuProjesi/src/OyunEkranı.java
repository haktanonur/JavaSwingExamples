
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class OyunEkranı extends JFrame{

    public OyunEkranı(String title) throws HeadlessException {
        super(title);
    }
    
    public static void main(String[] args) {
        
        OyunEkranı oyunEkranı = new OyunEkranı("Uzay Oyunu");
        
        oyunEkranı.setResizable(false); //
        oyunEkranı.setFocusable(false);
        oyunEkranı.setSize(800, 600);
        oyunEkranı.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ///////////////////////////////////////////////////
        Oyun oyun = new Oyun();
        oyun.requestFocus(); // klavye işlemlerini alması için izin alıyor
        oyun.addKeyListener(oyun); // klavyeden işlemleri almayı sağlıyor
        oyun.setFocusable(true); //
        oyun.setFocusTraversalKeysEnabled(false); // klavye işlerini jpanel in anlaması için gerekli olan method
        
        oyunEkranı.add(oyun);
        oyunEkranı.setVisible(true);
    }
    
}
