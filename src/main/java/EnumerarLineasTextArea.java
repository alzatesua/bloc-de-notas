import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnumerarLineasTextArea extends JFrame {
    private JTextArea textArea;
    private JButton enumerarButton;

    public EnumerarLineasTextArea() {
        setTitle("Enumerar Líneas en JTextArea");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea(10, 40);
        enumerarButton = new JButton("Enumerar Líneas");

        enumerarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enumerarLineas();
            }
        });

        JPanel panel = new JPanel();
        panel.add(enumerarButton);

        add(new JScrollPane(textArea));
        add(panel, "South");

        setVisible(true);
    }

    private void enumerarLineas() {
        String texto = textArea.getText();
        String[] lineas = texto.split("\n");
        StringBuilder textoEnumerado = new StringBuilder();

        for (int i = 0; i < lineas.length; i++) {
            textoEnumerado.append((i + 1) + ": " + lineas[i] + "\n");
        }

        textArea.setText(textoEnumerado.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EnumerarLineasTextArea());
    }
}
