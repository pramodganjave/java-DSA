import javax.swing.*;

public class Button {
    public static void main(String args[]) {
        JFrame f = new JFrame("Button Example");
        JButton b = new JButton("click here");
        b.setBounds(50, 100, 90, 30);
        f.add(b);
        f.setLayout(null);
        f.setVisible(true);

    }
}