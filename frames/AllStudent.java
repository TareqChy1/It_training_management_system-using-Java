package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class AllStudent extends JFrame implements ActionListener
{
	
	private JButton backBtn,logoutBtn;
	private JPanel panel;
	private JTable stdTable;
	private JScrollPane stdTableSP;
	
	private User user;
	private StudentRepo er;
	
	
	
	public AllStudent(User user)
	{
		super("StudentFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new StudentRepo();
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data_1[][] = {{"", "", "", ""}};
		
		String head_1[] = {"studentId", "studentName", "courseName", "courseId"};
		
		stdTable = new JTable(data_1,head_1);
		stdTableSP = new JScrollPane(stdTable);
		stdTableSP.setBounds(50, 50, 700, 250);
		stdTable.setEnabled(false);
		panel.add(stdTableSP);
		

		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(700, 350, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
		
		    String data[][] = er.getAllStudent();
			String head[] = {"studentId", "studentName", "courseName", "courseId"};
			
			panel.remove(stdTableSP);
			
			stdTable = new JTable(data,head);
			stdTable.setEnabled(false);
			stdTableSP = new JScrollPane(stdTable);
			stdTableSP.setBounds(50, 50, 700, 250);
			panel.add(stdTableSP);
			
			panel.revalidate();
			panel.repaint();
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
	
	   if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame eh = new LoginFrame();
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}