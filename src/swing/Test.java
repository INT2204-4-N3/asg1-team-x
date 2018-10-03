package swing;


import cmd0.DictionaryCommandline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class SwingControlDemo {
    DictionaryCommandline dictionaryCommandline=new DictionaryCommandline();
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private void prepareGUI(){
        mainFrame = new JFrame("Dictinary");
        mainFrame.setSize(400,400);
        mainFrame.getContentPane().setBackground(Color.pink);
        mainFrame.setLayout(new GridLayout( 3,1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);
        statusLabel.setBackground(Color.pink);
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.pink);
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    public SwingControlDemo(){
         prepareGUI();
     }

    private void showTextFieldDemo(){
        headerLabel.setText("DICTIONARY");

        JLabel  namelabel= new JLabel("Nhap tu ", JLabel.RIGHT);
        final JTextField Search = new JTextField(15);
        JButton SearchButton = new JButton("Search");
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Tiếng Việt: "+ dictionaryCommandline.dictionaryAdvanced(Search.getText());
                statusLabel.setText(data);
            }
        });

        controlPanel.add(namelabel);
        controlPanel.add(Search);
        controlPanel.add(SearchButton);
        mainFrame.setVisible(true);
    }
     public static void main(String[] args){
         SwingControlDemo  swingControlDemo = new SwingControlDemo();
         swingControlDemo.showTextFieldDemo();
     }
}
