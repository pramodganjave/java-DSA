import javax.swing.*;
import java.awt.*;

class JButtonExample extends JFrame {
JButtonExample()
{
setLayout(new FlowLayout());
JButton btnOk = new JButton("OK");
ImageIcon icon = new ImageIcon("C:\Users\Pramod Ganjave\Desktop\ok.jpg");
JButton btnIcon = new JButton(icon);
Jbutton btnTxtIcon = new JButton("OK",icon);
add(btnOk);
add(btnIcon);
add(btnTxtIcon);
}
}

class JButtonJavaExample1 {
    public static void main(String args[]) {
        JButtonExample frame = new JButtonExample();
        frame.setTitle("JButton in java swing Example");
        frame.setBounds(200, 250, 250, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}