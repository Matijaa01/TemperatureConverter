package com.converter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.*;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JTextField;

public class TempConverter {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldConverted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempConverter window = new TempConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public TempConverter() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		System.setProperty("http.agent", "Chrome");
		JLabel lblimgLeft = new JLabel("");
		BufferedImage resizedImageLeft = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2DLeft = resizedImageLeft.createGraphics();
		URL urlLeft = new URL("https://feelmanapp.com/wp-content/uploads/2020/06/icon_temperatureconverter.png");
		BufferedImage cLeft = ImageIO.read(urlLeft.openStream());
		graphics2DLeft.drawImage(cLeft, 0, 0, 400, 400, null);
		ImageIcon imgLeft = new ImageIcon(resizedImageLeft);
		graphics2DLeft.dispose();
		/*Image imgLeft = new ImageIcon(this.getClass().getResource("/img400x400.png")).getImage();*/
		lblimgLeft.setIcon(imgLeft);
		lblimgLeft.setBounds(0, 0, 400, 400);
		panel.add(lblimgLeft);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(400, 0, 400, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kelvin", "Fahrenheit", "Celsius"}));
		comboBox.setBounds(269, 121, 101, 40);
		panel_1.add(comboBox);
		
		
		BufferedImage resizedImageExit = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2DExit = resizedImageExit.createGraphics();
		URL urlExit = new URL("https://png.pngtree.com/png-vector/20190603/ourmid/pngtree-icon-close-button-png-image_1357822.jpg");
		BufferedImage cExit = ImageIO.read(urlExit.openStream());
		graphics2DExit.drawImage(cExit, 0, 0, 50, 50, null);
		ImageIcon imgExit = new ImageIcon(resizedImageExit);
		graphics2DExit.dispose();
		/*Image imgExit = new ImageIcon(this.getClass().getResource("/button_exit.png")).getImage();*/
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon(imgExit);
		btnExit.setBounds(350, 0, 50, 50);
		panel_1.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature Converter");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 50, 400, 50);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 25));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(38, 111, 221, 60);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textFieldConverted = new JTextField();
		textFieldConverted.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldConverted.setFont(new Font("SansSerif", Font.PLAIN, 25));
		textFieldConverted.setColumns(10);
		textFieldConverted.setBounds(38, 273, 221, 60);
		panel_1.add(textFieldConverted);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Kelvin", "Fahrenheit", "Celsius"}));
		comboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		comboBox_1.setBounds(269, 284, 101, 40);
		panel_1.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				double first = Double.parseDouble(textField.getText());
				double second;
				String boxFirst = (String)comboBox.getSelectedItem();
				String boxSecond = (String)comboBox_1.getSelectedItem();
				
				if(boxFirst.equals("Fahrenheit") && boxSecond.equals("Celsius")) {
					second = (first-32)*((double)5/9);
					second = (double)Math.round(second* 100d) / 100d;
					textFieldConverted.setText(String.valueOf(second));
				}
				
				if(boxFirst.equals("Fahrenheit") && boxSecond.equals("Kelvin")) {
					second = (first-32)*((double)5/9)+273.15;
					second = (double)Math.round(second* 100d) / 100d;
					textFieldConverted.setText(String.valueOf(second));
				}
				
				if(boxFirst.equals("Celsius") && boxSecond.equals("Fahrenheit")) {
					second = (first)*1.8+32;
					second = (double)Math.round(second* 100d) / 100d;
					textFieldConverted.setText(String.valueOf(second));
				}
				
				if(boxFirst.equals("Celsius") && boxSecond.equals("Kelvin")) {
					second = first+273.15;
					second = (double)Math.round(second* 100d) / 100d;
					textFieldConverted.setText(String.valueOf(second));
				}
				
				if(boxFirst.equals("Kelvin") && boxSecond.equals("Celsius")) {
					second = first-273.15;
					second = (double)Math.round(second* 100d) / 100d;
					textFieldConverted.setText(String.valueOf(second));
				}
				
				if(boxFirst.equals("Kelvin") && boxSecond.equals("Fahrenheit")) {
					second = (first-273.15)*1.8+32;
					second = (double)Math.round(second* 100d) / 100d;
					textFieldConverted.setText(String.valueOf(second));
				}
				
				if(boxFirst.equals("Kelvin") && boxSecond.equals("Kelvin") 
					|| (boxFirst.equals("Fahrenheit") && boxSecond.equals("Fahrenheit"))
					|| (boxFirst.equals("Celsius") && boxSecond.equals("Celsius"))) 
				{
					textFieldConverted.setText(String.valueOf(first));
				}
				
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(38, 201, 105, 40);
		panel_1.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textFieldConverted.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(154, 201, 105, 40);
		panel_1.add(btnClear);
	}
}
