
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainContent extends JFrame {

    public JButton start = new JButton("Start");

    JPanel main = new JPanel(new FlowLayout());

    int i = 0;

    public MainContent() {
        super();
        configurarVentana();

    }

    private void configurarVentana() {
        this.setTitle("threads");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);

        main.add(start);

        this.add(main);

        this.start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                System.out.println("boton funcionando");
                new Thread(new Cronometro(), ("Hilo " + i)).start();
            }
        });

        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        MainContent v = new MainContent();
        v.setVisible(true);
    }

}