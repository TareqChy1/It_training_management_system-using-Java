package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;



public class UpdateInfo  extends JFrame implements ActionListener{

	private JLabel empIdLabel, empNameLabel, empDesignationLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF;
	private JButton updateBtn, backBtn,logoutBtn;
	private JTable empTable;
	private JScrollPane empTableSP;
	private JPanel panel;
	private User user;
	private EmployeeRepo ur=new EmployeeRepo() ;
	
	public  UpdateInfo (User user) {
		super("Employee update info");
		this.setSize(800, 600);
		this.setLocation(500, 100);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.user=user;

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#53354a"));
		
		
		empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(100,100,100,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(220,100,100,30);
		empIdTF.setEnabled(false);
		panel.add(empIdTF);
		empIdTF.setText(user.getUserId());
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,150,100,30);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(220,150,100,30);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Designation: ");
		empDesignationLabel.setBounds(100,200,100,30);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(220,200,100,30);
		empDesignationTF.setEnabled(false);
		panel.add(empDesignationTF);
		
		
		
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(280,280,150,30);
		updateBtn.addActionListener(this);
		updateBtn.setBackground(Color.decode("#283149"));
		updateBtn.setForeground(Color.decode("#e8f1f5"));
		updateBtn.setFont(new Font("Calibri",Font.PLAIN,18));
		panel.add(updateBtn);
		
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(330, 460, 150, 30);
		
		backBtn.setBackground(Color.decode("#283149"));
		backBtn.setForeground(Color.decode("#e8f1f5"));
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(500, 460, 150, 30 );
		logoutBtn.setBackground(Color.decode("#283149"));
		logoutBtn.setForeground(Color.decode("#e8f1f5"));
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
		
				if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Employee e = ur.searchEmployee(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getName());
					empDesignationTF.setText(e.getDesignation());
				
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
		
		
		
		
	}
	}
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if(command.equals(backBtn.getText())) {
			EmployeeHome ep = new EmployeeHome(user);
			ep.setVisible(true);
			this.setVisible(false);
		}
		
	
		else if(command.equals(logoutBtn.getText())) {
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		
		
	
	
	      else if(command.equals(updateBtn.getText()))
		{
			Employee ef = new Employee();
			EmployeeRepo sf=new EmployeeRepo();
			
			
			try{
			ef.setEmpId(empIdTF.getText());
			ef.setName(empNameTF.getText());
			ef.setDesignation(empDesignationTF.getText());
			ef.setSalary(0.00);
			
			
			sf.updateName(ef);
	
			
			
			JOptionPane.showMessageDialog(this, "Updated");
			}
			catch(Exception ro)
			{
				JOptionPane.showMessageDialog(this, "operation halted");
			}
			
			
		}
	}
	
	
}
