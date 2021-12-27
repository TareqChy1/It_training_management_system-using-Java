package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StudentAllCourse extends JFrame implements ActionListener
{
	
	private JButton backBtn,logoutBtn;
	private JPanel panel;
	private JTable crsTable;
	private JScrollPane crsTableSP;
	private CourseRepo er;
	private User user;
	
	
	
	public StudentAllCourse(User user)
	{
		super("All CourseFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.user=user;
		er = new CourseRepo();
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data_1[][] = {{"", "", "", ""}};
		
		String head_1[] = {"courseId", "courseName", "courseFee", "duration"};
		
		crsTable = new JTable(data_1,head_1);
		crsTableSP = new JScrollPane(crsTable);
		crsTableSP.setBounds(50, 50, 700, 250);
		crsTable.setEnabled(false);
		panel.add(crsTableSP);
		

		
		
	
		
		backBtn = new JButton("Back");
		backBtn.setBounds(500, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		logoutBtn = new JButton("logout");
		logoutBtn.setBounds(600, 350, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		
		this.add(panel);
		
		
		    String data[][] = er.getAllCourse();
		    String head[] = {"courseId", "courseName", "courseFee", "duration"};
			
			panel.remove(crsTableSP);
			
			crsTable = new JTable(data,head);
			crsTable.setEnabled(false);
			crsTableSP = new JScrollPane(crsTable);
			crsTableSP.setBounds(50, 50, 700, 250);
			panel.add(crsTableSP);
			
			panel.revalidate();
			panel.repaint();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
	
	     if(command.equals(backBtn.getText()))
		{
			StudentHome eh = new StudentHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame e = new LoginFrame();
			e.setVisible(true);
			this.setVisible(false);
		}
		
		else{}
		
	}
}
