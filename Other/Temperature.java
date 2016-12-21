import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends JFrame implements ActionListener{
    private Container pane;

    private JButton bf;
    private JButton bc;
    private JLabel C;
    private JLabel F;
    private JTextField c;
    private JTextField f;

    public Temperature(){
	this.setTitle("Farenheit/Celsius Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    
	bf = new JButton("Convert to Farenheit");
	bf.addActionListener(this);
	bf.setActionCommand("toF");
	bc = new JButton("Convert to Celcius");
	bc.addActionListener(this);
	bc.setActionCommand("toC");
	F = new JLabel("Farenheit",null,JLabel.CENTER);
	C = new JLabel("Celsius",null,JLabel.CENTER);
	f = new JTextField(12);
	c = new JTextField(12);
    
	pane.add(bf);
	pane.add(bc);
	pane.add(F);
	pane.add(f);
	pane.add(C);
	pane.add(c);
    }

    public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals("toF")){
	    f.setText(Double.toString(CtoF(Double.parseDouble(c.getText()))));
	}
	else if(e.getActionCommand().equals("toC")){
	    c.setText(Double.toString(FtoC(Double.parseDouble(f.getText()))));
	}
    }
    public static double CtoF(double t){
	return ((t * 1.8) + 32);
    }

    public static double FtoC(double t){
	return ((t - 32) / 1.8);
    }
    
    public static void main(String[] a){
	Temperature w = new Temperature();
	w.setVisible(true);
    }
}
