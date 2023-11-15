import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollSyncExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scroll Synchronization Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea1 = new JTextArea(10, 40);
        JTextArea textArea2 = new JTextArea(10, 40);

        // Crear paneles de desplazamiento para las áreas de texto
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);

        // Agregar los paneles de desplazamiento al marco
        frame.add(scrollPane1, BorderLayout.WEST);
        frame.add(scrollPane2, BorderLayout.EAST);

        // Agregar un AdjustmentListener a los paneles de desplazamiento
        AdjustmentListener adjustmentListener = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (e.getAdjustable() == scrollPane1.getVerticalScrollBar()) {
                    scrollPane2.getVerticalScrollBar().setValue(e.getValue());
                } else if (e.getAdjustable() == scrollPane2.getVerticalScrollBar()) {
                    scrollPane1.getVerticalScrollBar().setValue(e.getValue());
                }
            }
        };

        scrollPane1.getVerticalScrollBar().addAdjustmentListener(adjustmentListener);
        scrollPane2.getVerticalScrollBar().addAdjustmentListener(adjustmentListener);

        frame.setVisible(true);
    }
}