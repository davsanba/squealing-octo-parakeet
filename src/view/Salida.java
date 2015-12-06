package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class Salida extends JPanel {
	
	public JLabel lblfileName = new JLabel("Por favor cargue un archivo");
	JTextPane textPane = new JTextPane();
	public Salida() {
		setLayout(null);
		
		lblfileName.setHorizontalAlignment(SwingConstants.CENTER);
		lblfileName.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblfileName.setBounds(10, 0, 744, 36);
		add(lblfileName);
		textPane.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		
		
		textPane.setBounds(10, 47, 420, 274);
		add(textPane);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 762, 2);
		add(separator);

	}
	
	public void titulo(String str){
		lblfileName.setText(str);
	}
	
	public void listaErrores(List<String> lst) {
		String rt = "";
		for(String str: lst){
			rt += str;
			rt += "\n";
		}
		textPane.setText(rt);
	}

}
