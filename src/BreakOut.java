import javax.swing.JFrame;
import java.awt.EventQueue;

public class BreakOut  extends JFrame{
    
    public BreakOut() {
        initUI();
    } 

    public void initUI() {
        add(new Board());
        setTitle("Canton's Method");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {

            BreakOut game = new BreakOut();
            game.setVisible(true);
        });
    }

    
}
