	package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;



public class MainWindow extends JFrame {

	private JPanel contentPane;
	JPanel load = new LoadWindow();
	JPanel salida = new Salida();
	
	public MainWindow() {
		setTitle("Buenas Practicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));;
		this.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		load.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		load.setForeground(Color.BLACK);
		load.setBackground(Color.WHITE);
		load.setBounds(375, 0, 400, 90);
		contentPane.add(load);
		load.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 106, 1000, 2);
		load.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Analizador De Buenas Practicas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 0, 355, 96);
		contentPane.add(lblNewLabel);
		
		
		salida.setForeground(Color.BLACK);
		salida.setBackground(Color.WHITE);
		salida.setBounds(10, 112, 764, 338);
		contentPane.add(salida);
		salida.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 102, 790, 2);
		contentPane.add(separator);
	
		this.setVisible(true);
	}
	
	public void setContentTitle(String text) {
		((Salida) salida).titulo(text);
		
	}

	public void listaErrores(List<String> lst) {
		((Salida) salida).listaErrores(lst);
	}
	
	
}
