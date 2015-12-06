package view;

import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.App;

public class LoadWindow extends JPanel {
	private JTextField txtRuta;
	final JFileChooser fc = new JFileChooser();
	
	public LoadWindow() {
		setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(224, 5, 1, 1);
		add(desktopPane);
		
		txtRuta = new JTextField();
		txtRuta.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		txtRuta.setBounds(87, 28, 287, 20);
		add(txtRuta);
		txtRuta.setColumns(10);
		
		JLabel lblRuta = new JLabel("Ruta: ");
		lblRuta.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblRuta.setBounds(32, 29, 45, 19);
		add(lblRuta);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setEnabled(false);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App.getInstance().setTitle(txtRuta.getText());
				App.getInstance().analizar(txtRuta.getText());
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRuta.setText(buscar());
				if(!txtRuta.getText().isEmpty()){
					btnCargar.setEnabled(true);
				}
			}
		});
		btnBuscar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnBuscar.setBounds(87, 59, 127, 27);
		add(btnBuscar);
		
		btnCargar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnCargar.setBounds(224, 59, 150, 27);
		add(btnCargar);

	}
	
	private String buscar(){
		String rt = "";
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java", "java");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    rt = selectedFile.getAbsolutePath();
		}
		return rt;
	}
}
