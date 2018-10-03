package swing;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class Frame {
    public Frame(){
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.pink);
        frame.setPreferredSize(new Dimension(500, 450));
        frame.pack();
        frame.setVisible(true);
        JButton button1=new JButton("Search");
        button1.setBounds(50,40,80,25);
        frame.add(button1);
    }
    public static void main(String[]a){
        new Frame();

    }
}
