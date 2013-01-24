package com.fengyun.atm.model.client.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class RegisterPanel extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					RegisterPanel frame = new RegisterPanel();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterPanel()
	{
		setTitle("BAM Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_c = new JPanel();
		contentPane.add(panel_c, BorderLayout.CENTER);
		panel_c.setLayout(new GridLayout(7, 2, 30, 20));
		
		JLabel lblType = new JLabel("\u8D26\u6237\u7C7B\u578B\uFF1A");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		panel_c.add(comboBox);
		
		JLabel label_5 = new JLabel("New label");
		panel_c.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_c.add(textField_6);
		
		JLabel label = new JLabel("New label");
		panel_c.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_c.add(textField_1);
		
		JLabel label_1 = new JLabel("New label");
		panel_c.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_c.add(textField_2);
		
		JLabel label_2 = new JLabel("New label");
		panel_c.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_c.add(textField_3);
		
		JLabel label_3 = new JLabel("New label");
		panel_c.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_c.add(textField_4);
		
		JLabel label_4 = new JLabel("New label");
		panel_c.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_c.add(textField_5);
		
		JPanel panel_b = new JPanel();
		contentPane.add(panel_b, BorderLayout.SOUTH);
		panel_b.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
	}

}
