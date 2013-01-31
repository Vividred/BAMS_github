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
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPanel extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JPasswordField pwdField_confirm;

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
		panel_c.setBorder(new EmptyBorder(0, 0, 0, 20));
		contentPane.add(panel_c, BorderLayout.CENTER);
		panel_c.setLayout(new GridLayout(7, 2, 20, 20));
		
		JLabel lblType = new JLabel("\u8D26\u6237\u7C7B\u578B\uFF1A");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u8D26\u6237", "\u4FE1\u7528\u8D26\u6237"}));
		panel_c.add(comboBox);
		
		JLabel lblAccount = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		lblAccount.setAlignmentY(Component.TOP_ALIGNMENT);
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblAccount);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_c.add(textField_6);
		
		JLabel lblPwd = new JLabel("\u5BC6    \u7801\uFF1A");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblPwd);
		
		passwordField = new JPasswordField();
		panel_c.add(passwordField);
		
		JLabel lblPwdconf = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblPwdconf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblPwdconf);
		
		pwdField_confirm = new JPasswordField();
		panel_c.add(pwdField_confirm);
		
		JLabel lblPerId = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblPerId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblPerId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_c.add(textField_3);
		
		JLabel lblAddress = new JLabel("\u8BE6\u7EC6\u5730\u5740\uFF1A");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_c.add(textField_4);
		
		JLabel lblMail = new JLabel("E-Mail\uFF1A");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_c.add(lblMail);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_c.add(textField_5);
		
		JPanel panel_b = new JPanel();
		contentPane.add(panel_b, BorderLayout.SOUTH);
		panel_b.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		
		JButton btnSubmit = new JButton("\u63D0\u4EA4");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_b.add(btnSubmit);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		panel_b.add(btnReturn);
	}

}
