package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class Credit extends JFrame implements ActionListener
{
	
	private JLabel stdNameLabel1, stdIdLabel1,semesterLabel1,versityLabel1,stdNameLabel2, stdIdLabel2,semesterLabel2,versityLabel2,stdNameLabel3, stdIdLabel3,semesterLabel3,versityLabel3,stdNameLabel4, stdIdLabel4,semesterLabel4,versityLabel4;
	
	
	private JButton backBtn;
	
	private JPanel panel;
	private LoginFrame lf;
	
	public Credit(LoginFrame lf)
	{
		super("CREDIT !!!");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.lf = lf;
	
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		stdNameLabel1 = new JLabel("Tareq Md Rabiul Hossain Chy");
		stdNameLabel1.setBounds(100,50,300,30);
		panel.add(stdNameLabel1);
		
	    stdIdLabel1 = new JLabel("ID:17-34649-2");
		stdIdLabel1.setBounds(100,90,100,30);
		panel.add(stdIdLabel1);
		
		semesterLabel1 = new JLabel("7th Semester");
		semesterLabel1.setBounds(100,130,100,30);
		panel.add(semesterLabel1);
		
		versityLabel1 = new JLabel("AIUB");
		versityLabel1.setBounds(100,170,100,30);
		panel.add(versityLabel1);
		
		
		stdNameLabel2 = new JLabel("Khairul Alam Mazumder");
		stdNameLabel2.setBounds(100,230,100,30);
		panel.add(stdNameLabel2);
		
	    stdIdLabel2 = new JLabel("ID:17-35185-2");
		stdIdLabel2.setBounds(100,270,100,30);
		panel.add(stdIdLabel2);
		
		semesterLabel2 = new JLabel("7th Semester");
		semesterLabel2.setBounds(100,310,100,30);
		panel.add(semesterLabel2);
		
		versityLabel2 = new JLabel("AIUB");
		versityLabel2.setBounds(100,350,100,30);
		panel.add(versityLabel2);
		
		
		stdNameLabel3 = new JLabel("Ruhul Amin");
		stdNameLabel3.setBounds(100,410,100,30);
		panel.add(stdNameLabel3);
		
	    stdIdLabel3 = new JLabel("ID:17-35160-2");
		stdIdLabel3.setBounds(100,450,100,30);
		panel.add(stdIdLabel3);
		
		semesterLabel3 = new JLabel("7th Semester");
		semesterLabel3.setBounds(100,490,100,30);
		panel.add(semesterLabel3);
		
		versityLabel3 = new JLabel("AIUB");
		versityLabel3.setBounds(100,530,100,30);
		panel.add(versityLabel3);
		
		
		stdNameLabel4 = new JLabel("Shanto Kumar Saha");
		stdNameLabel4.setBounds(100,590,300,30);
		panel.add(stdNameLabel4);
		
	    stdIdLabel4 = new JLabel("ID:17-34699-2");
		stdIdLabel4.setBounds(100,630,100,30);
		panel.add(stdIdLabel4);
		
		semesterLabel4 = new JLabel("7th Semester");
		semesterLabel4.setBounds(100,670,100,30);
		panel.add(semesterLabel4);
		
		versityLabel4 = new JLabel("AIUB");
		versityLabel4.setBounds(100,710,100,30);
		panel.add(versityLabel4);
		
		
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(390, 240, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		

	   if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
		else{}
	}
}