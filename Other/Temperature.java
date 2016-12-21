import javax.swing.*;
import java.awt.*;

public class Temperature extends JFrame{
    private Container pane;

    private JButton b;
    private JLabel C;
    private JLabel F;
    private JTextField c;
    private JTextField f;

    public static double CtoF(double t){
	return ((t * 1.8) + 32);
    }

    public static double FtoC(double t){
	return ((t - 32) / 1.8);
    }

    this.setTitle("Farenheit/Celsius Converter");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    
    b = new JButton("Convert");
    l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
    t = new JTextField(12);
    c = new JCheckBox("Overclock!!!");
    pane.add(l);
    pane.add(b);
    pane.add(t);
    pane.add(c);
    public static void main(String[] a){
	Temperature w = new Temperature();
	w.setVisible(true);
    }
}
