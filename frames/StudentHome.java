package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StudentHome extends JFrame implements ActionListener
{
	private JLabel idLabel, nameLabel,crsIdLabel,crsNameLabel;
	private JTextField idTF, nameTF,crsIdTF,crsNameTF;
	private JButton changePasswordBtn, logoutBtn,crsBtn,changeSecurityBtn;
	private JPanel panel;
	private User user;
	private StudentRepo er;
	
	public StudentHome(User user)
	{
		super("StudentHome ");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user=user;
		er = new StudentRepo();
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		idLabel = new JLabel("ID: ");
		idLabel.setBounds(200, 50, 160, 30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(370, 50, 150, 30);
		idTF.setEditable(false);
		panel.add(idTF);
		idTF.setText(user.getUserId());
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(200, 90, 160, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(370, 90, 150, 30);
		nameTF.setEditable(false);
		panel.add(nameTF);
		
		
		crsIdLabel = new JLabel("courrse id: ");
		crsIdLabel.setBounds(200, 130, 160, 30);
		panel.add(crsIdLabel);
		
		crsIdTF = new JTextField();
		crsIdTF.setBounds(370, 130, 150, 30);
		crsIdTF.setEditable(false);
		panel.add(crsIdTF);
		
		crsNameLabel = new JLabel("course Name: ");
		crsNameLabel.setBounds(200, 170, 160, 30);
		panel.add(crsNameLabel);
		
		crsNameTF = new JTextField();
		crsNameTF.setBounds(370, 170, 150, 30);
		crsNameTF.setEditable(false);
		panel.add(crsNameTF);
		
		
		changePasswordBtn= new JButton("Change Password");
		changePasswordBtn.setBounds(300, 220, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		this.add(panel);
		
		changeSecurityBtn= new JButton("Change answer");
		changeSecurityBtn.setBounds(620, 220, 150, 30);
		changeSecurityBtn.addActionListener(this);
		panel.add(changeSecurityBtn);
		this.add(panel);
		
		
		crsBtn= new JButton("All course");
		crsBtn.setBounds(460, 220, 150, 30);
		crsBtn.addActionListener(this);
		panel.add(crsBtn);
		this.add(panel);
	
		
		logoutBtn= new JButton("Log out");
		logoutBtn.setBounds(415, 300, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		this.add(panel);
		
		
		if(!idTF.getText().equals("") || !idTF.getText().equals(null))
			{
				Student e = er.searchStudent(idTF.getText());
				if(e!= null)
				{
					nameTF.setText(e.getStudentName());
					crsIdTF.setText(e.getCourseId());
					crsNameTF.setText(e.getCourseName());
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
		
		
		
		
	}
	}


public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame e = new LoginFrame();
			e.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(changePasswordBtn.getText()))
		{
			PasswordFrame pw = new PasswordFrame(user);
			pw.setVisible(true);
			this.setVisible(false);
			
		}
		
		else if(command.equals(changeSecurityBtn.getText()))
		{
			ChangeSecurity1 pw = new ChangeSecurity1(user);
			pw.setVisible(true);
			this.setVisible(false);
			
		}
		
		else if(command.equals(crsBtn.getText()))
		{
			StudentAllCourse pw = new StudentAllCourse(user);
			pw.setVisible(true);
			this.setVisible(false);
			
		}
	}
}