package interfaz;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Fernando Gonzalez (223939) & Facundo San Andrea (258053)
 */

public class ManejadorTema {

    public static void aplicarTema(JFrame ventana, boolean modoOscuro) {

        Color fondo = modoOscuro ? new Color(45, 45, 45) : new Color(242, 242, 242);
        Color texto = modoOscuro ? Color.WHITE : new Color(0, 0, 0);
        Color campoFondo = modoOscuro ? new Color(70, 70, 70) : new Color(255, 255, 255);
        Color campoTexto = modoOscuro ? Color.WHITE : new Color(0, 0, 0);
        Color botonFondo = modoOscuro ? new Color(80, 80, 80) : new Color(255, 255, 255);
        Color botonTexto = modoOscuro ? Color.WHITE : new Color(0, 0, 0);

        aplicarTemaRecursivo(ventana.getContentPane(), fondo, texto, campoFondo, campoTexto, botonFondo, botonTexto, modoOscuro);

        if (ventana.getJMenuBar() != null) {
            Component c = ventana.getJMenuBar().getComponent();
            if (c instanceof JMenuBar menuBar) {
                for (int i = 0; i < menuBar.getMenuCount(); i++) {
                    JMenu menu = menuBar.getMenu(i);
                    if (menu != null) {
                        menu.setBackground(fondo);
                        menu.setForeground(texto);
                        menu.getPopupMenu().setBackground(fondo);
                        menu.getPopupMenu().setForeground(texto);
                        menu.setOpaque(true);
                        menu.repaint();
                        for (Component subItem : menu.getMenuComponents()) {
                            if (subItem instanceof JMenuItem item) {
                                item.setBackground(fondo);
                                item.setForeground(texto);
                            }
                        }
                    }
                }
                menuBar.setBackground(fondo);
                menuBar.setForeground(texto);
                menuBar.setOpaque(true);
                menuBar.repaint();
            }
        }
        ventana.repaint();
    }

    private static void aplicarTemaRecursivo(Container contenedor, Color fondo, Color texto, Color campoFondo, Color campoTexto, Color botonFondo, Color botonTexto, boolean modoOscuro) {
        contenedor.setBackground(fondo);

        for (Component c : contenedor.getComponents()) {

            if (c instanceof Container cont) {
                aplicarTemaRecursivo(cont, fondo, texto, campoFondo, campoTexto, botonFondo, botonTexto, modoOscuro);
            }

            if (c instanceof JTabbedPane tabbedPane) {
                tabbedPane.setBackground(fondo);
                tabbedPane.setForeground(texto);
                tabbedPane.setOpaque(true);

                int tabs = tabbedPane.getTabCount();
                for (int i = 0; i < tabs; i++) {
                    Component tabComponent = tabbedPane.getComponentAt(i);
                    if (tabComponent instanceof Container cont) {
                        aplicarTemaRecursivo(cont, fondo, texto, campoFondo, campoTexto, botonFondo, botonTexto, modoOscuro);
                    } else {
                        // En caso de que no sea container, aplicar directamente
                        tabComponent.setBackground(fondo);
                        tabComponent.setForeground(texto);
                    }
                }
                tabbedPane.repaint();
            }

            if (c instanceof JScrollPane scroll) {
                scroll.setBackground(fondo);
                scroll.getViewport().setBackground(fondo);

                Component contenido = scroll.getViewport().getView();

                if (contenido instanceof JList<?> lista) {
                    lista.setBackground(campoFondo);
                    lista.setForeground(campoTexto);
                    lista.setOpaque(true);
                    lista.repaint();
                }
                if (contenido instanceof JTable tabla) {
                    tabla.setBackground(campoFondo);
                    tabla.setForeground(campoTexto);
                    tabla.setGridColor(campoTexto);
                    tabla.getTableHeader().setBackground(fondo);
                    tabla.getTableHeader().setForeground(texto);
                    tabla.repaint();
                }
                if (contenido instanceof JTextArea area) {
                    area.setBackground(campoFondo);
                    area.setForeground(campoTexto);
                    area.setOpaque(true);
                    area.repaint();
                }
            }

            if (c instanceof JLabel) {
                c.setForeground(texto);
                c.repaint();
            }

            if (c instanceof JTextField) {
                c.setBackground(campoFondo);
                c.setForeground(campoTexto);
                ((JComponent) c).setOpaque(true);
                c.repaint();
            }

            if (c instanceof JComboBox combo) {
                combo.setBackground(campoFondo);
                combo.setForeground(campoTexto);
                combo.setOpaque(true);

                combo.setRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        if (isSelected) {
                            label.setBackground(campoTexto);
                            label.setForeground(campoFondo);
                        } else {
                            label.setBackground(campoFondo);
                            label.setForeground(campoTexto);
                        }
                        label.setOpaque(true);
                        return label;
                    }
                });
                combo.repaint();
            }

            if (c instanceof JButton btn) {
                if (modoOscuro) {
                    btn.setOpaque(true);
                    btn.setBackground(botonFondo);
                    btn.setForeground(botonTexto);
                    btn.setBorderPainted(false);
                } else {
                    btn.setOpaque(false);
                    btn.setBackground(null);
                    btn.setForeground(null);
                    btn.setBorderPainted(true);
                }
                btn.repaint();

            }
            
            if (c instanceof JRadioButton rbtn){
                rbtn.setBackground(campoFondo);
                rbtn.setForeground(campoTexto);
                rbtn.repaint();            
            }
        }
    }

}
