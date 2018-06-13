
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Font;
import javax.swing.JLabel;
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

class Cronometro extends JFrame implements Runnable {

    JLabel reloj = new JLabel("aaaaaaaaaaa");

    int seg = 0;
    int min = 0;
    int hor = 0;

    JPanel main = new JPanel(new FlowLayout());

    public Cronometro() {
        super();
        configurarVentana();

    }

    @Override
    public void run() {

        while (true) {

            // SETEA EL VALOR DEL LABEL RELOJ
            // Y MUESTRA POR CONSOLA EL TIEMPO QUE TRANSCURRE
            reloj.setText(hor + ":" + min + ":" + seg);
            System.out.println(hor + ":" + min + ":" + seg + " " + Thread.currentThread().getName());
            seg++;

            // SI LOS SEGUNDOS PASAN DE 59 LOS CAMBIA A 0
            // Y AUMENTA EN 1 LOS MINUTOS
            if (seg > 59) {
                seg = 0;
                min++;
            }

             // SI LOS MINUTOS PASAN DE 59 LOS CAMBIA A 0
            // Y AUMENTA EN 1 LAS HORAS
            if (min > 59) {
                min = 0;
                hor++;
            }

            try {

                // CON **Thread.sleep(1000)** SIMULAMOS LOS TICKS DE LOS SEGUNDOS
                Thread.sleep(1000);

            } catch (InterruptedException e) {
            }
        }

    }

    private void configurarVentana() {

        // CONFIGURAMOS TODO LO RELACIONADO CON LA VENTANA
        this.setTitle("threads");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // CONFIGURAMOS TODO LO RELACIONADO CON LOS COMPONENTES
        // Y LO AGREGAMOS AL LAYOUT DE LA VENTANA
        reloj.setFont(new Font("Serif", Font.PLAIN, 72));
        main.add(reloj);

        this.add(main);

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
}