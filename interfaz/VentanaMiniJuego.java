package interfaz;

import dominio.MiniJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class VentanaMiniJuego extends JFrame {

    private final MiniJuego juego;
    private final JPanel panel;
    private Timer timer = null;

    public VentanaMiniJuego() {
        setTitle("Evita los obstáculos");
        setSize(400, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        juego = new MiniJuego(getWidth());

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.BLUE);
                g.fillRect(juego.jugadorX, juego.jugadorY, juego.jugadorAncho, juego.jugadorAlto);

                g.setColor(Color.RED);
                for (Rectangle obs : juego.obstaculos) {
                    g.fillRect(obs.x, obs.y, obs.width, obs.height);
                }

                g.setColor(Color.BLACK);
                g.drawString("Puntos: " + juego.puntaje, 10, 20);

                if (!juego.jugando) {
                    g.setFont(new Font("Arial", Font.BOLD, 20));
                    g.drawString("¡Perdiste! Puntaje: " + juego.puntaje, 90, 250);
                }
            }
        };

        add(panel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!juego.jugando) {
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    juego.moverJugador(-20);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    juego.moverJugador(20);
                }
            }
        });

        setFocusable(true);

        timer = new Timer(30, e -> {
            if (juego.jugando) {
                juego.actualizar();
            } else {
                timer.stop();

                int opcion = JOptionPane.showConfirmDialog(
                        this,
                        "¡Perdiste! Puntaje: " + juego.puntaje + "\n¿Querés reiniciar?",
                        "Juego terminado",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    juego.reiniciar();
                    requestFocusInWindow();
                    timer.start();
                } else {
                    dispose();
                }
            }

            panel.repaint();
        });

        timer.start(); // <- Esto es clave para que el juego comience
    }
    
}
