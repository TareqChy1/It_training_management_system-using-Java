package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class RegistrationFrame extends JFrame implements ActionListener
{
	
	private JLabel stdNameLabel, crsIdLabel,crsNameLabel,loverLabel;
	private JTextField stdNameTF,crsIdTF,crsNameTF,loverNameTF;
	
	private JButton submitBtn, backBtn;
	
	private JPanel panel;
	private LoginFrame lf;
	private StudentRepo er;
	
	public RegistrationFrame(LoginFrame lf)
	{
		super("Register Now !!!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.lf = lf;
		er = new StudentRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		stdNameLabel = new JLabel("NAME :");
		stdNameLabel.setBounds(100,50,100,30);
		panel.add(stdNameLabel);
		
		stdNameTF = new JTextField();
		stdNameTF.setBounds(220,50,100,30);
		panel.add(stdNameTF);
		
	    crsIdLabel = new JLabel("COURSE ID :");
		crsIdLabel.setBounds(100,90,100,30);
		panel.add(crsIdLabel);
		
		crsIdTF = new JTextField();
		crsIdTF.setBounds(220,90,100,30);
		panel.add(crsIdTF);
		
		crsNameLabel = new JLabel("COURSE NAME :");
		crsNameLabel.setBounds(100,130,100,30);
		panel.add(crsNameLabel);
		
		crsNameTF = new JTextField();
		crsNameTF.setBounds(220,130,100,30);
		panel.add(crsNameTF);
		
		loverLabel = new JLabel("Gf/Bf Name :");
		loverLabel.setBounds(100,170,100,30);
		panel.add(loverLabel);
		
		loverNameTF = new JTextField();
		loverNameTF.setBounds(220,170,100,30);
		panel.add(loverNameTF);
		
		
		
		
		
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(300, 240, 80, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(390, 240, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			Student e = new Student();
			CourseRepo yr = new CourseRepo();
			Course course = yr.searchCourse(crsIdTF.getText());
			User u = new User();
			UserRepo ur = new UserRepo();
			Security s=new Security();
			SecurityRepo sr=new SecurityRepo();
			Purchase pe=new Purchase();
			PurchaseRepo xr=new PurchaseRepo();
			if(course !=null && (crsNameTF.getText().equals(course.getCourseName())))
			{
			try{
			
		
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			int y = rd.nextInt(99999)+10000;
			int z = rd.nextInt(999999)+10000;
			try{
			
			e.setStudentId(y+"");
			e.setStudentName(stdNameTF.getText());
			e.setCourseId(crsIdTF.getText());
			
			e.setCourseName(crsNameTF.getText());
			
			pe.setPurchaseId(z+"");
			pe.setCourseId(crsIdTF.getText());
			pe.setStudentId(y+"");
			pe.setStudentName(stdNameTF.getText());
			pe.setAmount(course.getCourseFee());
			
	
			xr.insertInDB(pe);
			
			u.setUserId(y+"");
			u.setPassword(x+"");
			s.setUserId(y+"");
			s.setAnswer(loverNameTF.getText());
			
			
			
				u.setStatus(2);
			
			
			
			er.insertInDB(e);
			ur.insertUser(u);
			sr.insertSecurity(s);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+y+"and Password: "+x+"and purchase id:"+z);
			}
			catch(Exception ro)
			{
			    JOptionPane.showMessageDialog(this, "operation halted");
			}
			
			stdNameTF.setText("");
			crsIdTF.setText("");
			crsNameTF.setText("");
			
		
			
		}
		catch(Exception ro)
		{
			JOptionPane.showMessageDialog(this, "operation halted");
		}
			}
		
		else{
			JOptionPane.showMessageDialog(this, "Course Not Found");
		}
		    this.setVisible(false);
			lf.setVisible(true);
		}
		else if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
		else{}
	}
}