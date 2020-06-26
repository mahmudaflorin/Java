import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
 class MemberDetails extends JFrame implements ActionListener
{
	JLabel userLabel, eNameLabel, phoneLabel,StatusLabel,welcomeLabel;
	JLabel userTF, phoneTF1, phoneTF2, eNameTF, StatusTF;
	JButton refreshBtn,delBtn, backBtn, logoutBtn;
	JPanel panel;
	
	String userId;
	
	public MemberDetails(String UserName,String Name,String Status)
	{
		
		this.setTitle("Member Details");
		
		this.backBtn = new JButton("Back");
		this.userLabel = new JLabel("User ID : ");
		this.userTF = new JLabel();
		this.eNameLabel = new JLabel("Name : ");
		this.eNameTF = new JLabel();
		this.phoneLabel = new JLabel("Phone No. : ");
		this.phoneTF1 = new JLabel();
		this.StatusLabel = new JLabel("Status : ");
		this.StatusTF = new JLabel();
		//this.delBtn = new JButton("Delete");
		this.setLayout(null);
		this.setSize(800, 800);
		
		
		//this.logoutBtn.setBounds(330, 450, 100, 30);
		this.userLabel.setBounds(250, 150, 120, 30);
		this.userLabel.setBounds(250, 150, 120, 30);
		this.eNameLabel.setBounds(250, 200, 120, 30);
		this.userTF.setBounds(400, 150, 120, 30);
		this.eNameTF.setBounds(400, 200, 120, 30);
		this.phoneLabel.setBounds(250, 250, 120, 30);
		this.phoneTF1.setBounds(400, 250, 120, 30);
		this.StatusLabel.setBounds(250, 300, 120, 30);
		this.StatusTF.setBounds(400, 300, 120, 30);
		//this.delBtn.setBounds(250, 400, 120, 30);
		this.backBtn.setBounds(400, 400, 120, 30);
		
		
		
		
		//add(this.logoutBtn);
		add(this.userLabel);
		add(this.userTF);
	    add(this.eNameLabel);
		add(this.eNameTF);
		add(this.phoneLabel);
		add(this.phoneTF1);
		add(this.StatusLabel);
		add(this.StatusTF);
		//add(this.delBtn);
		add(this.backBtn);
		
		userTF.setText(UserName);
		eNameTF.setText(Name);
		StatusTF.setText(Status);
		
		
		//logoutBtn.addActionListener(this);
		//delBtn.addActionListener(this);
		backBtn.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
			
	}	

	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==backBtn){
			
			new Librarian();
			this.dispose();
		}
}




	
/*public static void main(String []ar)
	{
	new MemberDetails();
	
    }*/
}