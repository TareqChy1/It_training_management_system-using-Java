package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class ChangeSecurity1 extends JFrame implements ActionListener
{
	private JLabel canswerLabel, nanswerLabel,idLabel;
	private JTextField idfield,canswerfield,nanswerfield;
	private JButton backBtn, submitBtn, logoutBtn;
	private JPanel panel;
	 User user;
	 SecurityRepo ur;
	
	 
	
	
	
	public ChangeSecurity1(User user)
	{
		super("answer Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user=user;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		idLabel = new JLabel("id: ");
		idLabel.setBounds(200, 40, 160, 30);
		panel.add(idLabel);
		idfield = new JTextField();
		idfield.setBounds(310, 40, 150, 30);
		idfield.setEnabled(false);
		panel.add(idfield);
		
		idfield.setText(user.getUserId());
		
		
		
		canswerLabel = new JLabel("Current answer: ");
		canswerLabel.setBounds(200, 100, 160, 30);
		panel.add(canswerLabel);
		
		canswerfield = new JTextField();
		canswerfield.setBounds(310, 100, 150, 30);
		panel.add(canswerfield);
		
		nanswerLabel = new JLabel("New answer: ");
		nanswerLabel.setBounds(200, 140, 160, 30);
		panel.add(nanswerLabel);
		
		nanswerfield = new JTextField();
		nanswerfield.setBounds(310, 140, 150, 30);
		panel.add(nanswerfield);
		
		
		submitBtn= new JButton("Submit");
		submitBtn.setBounds(420, 200, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		
		backBtn= new JButton("Back");
		backBtn.setBounds(300, 300, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		this.add(panel);
		
		logoutBtn= new JButton("Log out");
		logoutBtn.setBounds(415, 300, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
	    if(command.equals(submitBtn.getText()))
		{
			
			Security me=new Security();
			ur = new SecurityRepo();
			
			SecurityRepo yr = new SecurityRepo();
		    Security user_1 = yr.getSecurity(idfield.getText(), canswerfield.getText());
			
			if(user_1 != null)
			{
			   try{
		    me.setUserId(idfield.getText());
			
			me.setAnswer(nanswerfield.getText());
			
			ur.updateAnswer(me);
			
			
			JOptionPane.showMessageDialog(this, "Updated");
			}
			catch(Exception ro)
			{
				JOptionPane.showMessageDialog(this, "operation halted");
				ro.printStackTrace();
			}
			
			
			
			
			
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild current answer");
			}
			
			
		}
		else if(command.equals(backBtn.getText()))
		{
			StudentHome pw = new StudentHome(user);
			pw.setVisible(true);
			this.setVisible(false);
			
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame eh = new LoginFrame();
			eh.setVisible(true);
			this.setVisible(false);
		}
	}
}
