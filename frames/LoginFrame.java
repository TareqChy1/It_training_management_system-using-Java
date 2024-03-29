package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, regBtn, showPassBtn, crsBtn,forgetBtn,creditBtn;
	JPanel panel;
	
	public LoginFrame()
	{
		super("IT-CENTER Management System - Login Window");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("IT-Center Management System");
		title.setBounds(300, 50, 350, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,150,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		regBtn = new JButton("Registration");
		regBtn.setBounds(300, 250, 170, 30);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		crsBtn = new JButton("All Course");
		crsBtn.setBounds(300, 300, 170, 30);
		crsBtn.addActionListener(this);
		panel.add(crsBtn);
		
		forgetBtn = new JButton("forget password");
		forgetBtn.setBounds(300, 350, 170, 30);
		forgetBtn.addActionListener(this);
		panel.add(forgetBtn);
		
		creditBtn = new JButton("credit");
		creditBtn.setBounds(300, 400, 170, 30);
		creditBtn.addActionListener(this);
		panel.add(creditBtn);
		
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 || user.getStatus() == 1)
				{
					EmployeeHome eh = new EmployeeHome(user);
					eh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					StudentHome eh = new StudentHome(user);
					eh.setVisible(true);
					this.setVisible(false); 
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame(this);
			rf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(crsBtn.getText()))
		{
			AllCourse rf = new AllCourse();
			rf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(forgetBtn.getText()))
		{
			ForgetFrame rf = new ForgetFrame();
			rf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(creditBtn.getText()))
		{
		    Credit rf = new Credit(this);
			rf.setVisible(true);
			this.setVisible(false);
		}
		
		
		else{}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}