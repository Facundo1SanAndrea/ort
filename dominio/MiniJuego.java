package dominio;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class MiniJuego {

    public int jugadorX;
    public final int jugadorY = 460;
    public final int jugadorAncho = 50;
    public final int jugadorAlto = 20;

    public ArrayList<Rectangle> obstaculos;
    public int velocidadObstaculos = 5;
    public int puntaje = 0;
    public boolean jugando = true;

    private final int anchoPantalla;

    public MiniJuego(int anchoPantalla) {
        this.anchoPantalla = anchoPantalla;
        jugadorX = anchoPantalla / 2;
        obstaculos = new ArrayList<>();
    }

    public void moverJugador(int dx) {
        jugadorX += dx;
        if (jugadorX < 0) {
            jugadorX = 0;
        }
        if (jugadorX > anchoPantalla - jugadorAncho) {
            jugadorX = anchoPantalla - jugadorAncho;
        }
    }

    public void actualizar() {
        if (!jugando) {
            return;
        }

        Iterator<Rectangle> it = obstaculos.iterator();
        while (it.hasNext()) {
            Rectangle obs = it.next();
            obs.y += velocidadObstaculos;

            if (obs.intersects(new Rectangle(jugadorX, jugadorY, jugadorAncho, jugadorAlto))) {
                jugando = false;
            }

            if (obs.y > 500) {
                it.remove();
                puntaje++;
                if (puntaje % 5 == 0) {
                    velocidadObstaculos++;
                }
            }
        }

        if (Math.random() < 0.05) {
            Random rand = new Random();
            int obsX = rand.nextInt(anchoPantalla - 40);
            obstaculos.add(new Rectangle(obsX, 0, 40, 20));
        }
    }

    public void reiniciar() {
        jugadorX = anchoPantalla / 2;
        obstaculos.clear();
        velocidadObstaculos = 5;
        puntaje = 0;
        jugando = true;
    }
}
