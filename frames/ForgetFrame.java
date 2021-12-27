package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class ForgetFrame extends JFrame implements ActionListener
{
	private JLabel answerLabel, npasswordLabel,idLabel;
	private JPasswordField npasswordfild;
	private JTextField idfield,answerfield;
	private JButton backBtn, submitBtn;
	private JPanel panel;
	 SecurityRepo pe=new SecurityRepo();
	
	 
	
	
	
	public ForgetFrame()
	{
		super("ForgetFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		idLabel = new JLabel("id: ");
		idLabel.setBounds(200, 40, 160, 30);
		panel.add(idLabel);
		idfield = new JTextField();
		idfield.setBounds(310, 40, 150, 30);

		panel.add(idfield);
		
		
		
		
		
		answerLabel = new JLabel("gf/bf name:");
		answerLabel.setBounds(200, 100, 160, 30);
		panel.add(answerLabel);
		
		answerfield = new JTextField();
		answerfield.setBounds(310, 100, 150, 30);
		panel.add(answerfield);
		
		npasswordLabel = new JLabel("New Password: ");
		npasswordLabel.setBounds(200, 140, 160, 30);
		panel.add(npasswordLabel);
		
		npasswordfild = new JPasswordField();
		npasswordfild.setBounds(310, 140, 150, 30);
		panel.add(npasswordfild);
		
		
		submitBtn= new JButton("Submit");
		submitBtn.setBounds(420, 200, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		
		backBtn= new JButton("Back");
		backBtn.setBounds(300, 300, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		this.add(panel);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
	    if(command.equals(submitBtn.getText()))
		{
			
			User me=new User();
			 UserRepo ur = new UserRepo();
			
			
			Security security = pe.getSecurity(idfield.getText(),answerfield.getText());
			
			if(security != null)
			{
			   try{
		    me.setUserId(idfield.getText());
			me.setStatus(1);
			
			me.setPassword(npasswordfild.getText());
			
			ur.updatePassword(me);
			
			
			JOptionPane.showMessageDialog(this, "Updated");
			}
			catch(Exception ro)
			{
				JOptionPane.showMessageDialog(this, "operation halted");
				ro.printStackTrace();
			}
			
			
			
			LoginFrame e = new LoginFrame();
			e.setVisible(true);
			this.setVisible(false);	
			
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild ans");
			}
			
			
		}
		else if(command.equals(backBtn.getText()))
		{
			LoginFrame pw = new LoginFrame();
			pw.setVisible(true);
			this.setVisible(false);
			
		}
	}
}
