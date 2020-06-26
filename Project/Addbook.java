import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.Font;
import java.sql.*;
 class Addbook extends JFrame implements ActionListener,MouseListener
{
	JLabel BidLabel,  bNameLabel, phoneLabel, roleLabel,welcomeLabel,AvcopyLabel, pageNameLabel;
	JTextField userTF, phoneTF1, phoneTF2, bNameTF, roleTF,AvcopyLabelTF;
 	JButton refreshBtn,enterBtn, backBtn;
	 JPanel panel;
	
	
String BookID,BookName,AuthorName,Edition,AvailableCopy;
	
	public Addbook()
	{
	
	
		this.backBtn = new JButton("Back");
	    this.BidLabel = new JLabel("Book ID : ");
		this.userTF = new JTextField();
		this.bNameLabel = new JLabel("Book Name : ");
		this.bNameTF = new JTextField();
		this.phoneLabel = new JLabel("Author Name : ");
		this.AvcopyLabel=new JLabel("Available Copy:");
		this.AvcopyLabelTF=new JTextField();
		this.phoneTF1 = new JTextField();
		this.roleLabel = new JLabel("Edition : ");
		this.roleTF = new JTextField();
		this.enterBtn = new JButton("Enter");
		enterBtn.setBackground(new Color(153,50,204));
		enterBtn.setForeground(Color.white);
		enterBtn.addMouseListener(this);
		backBtn.setBackground(new Color(153,50,204));
		backBtn.setForeground(Color.white);
		backBtn.addMouseListener(this);
		this.setLayout(null);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		
		
		
		
		
		this.BidLabel.setBounds(250, 150, 120, 30);
		this.AvcopyLabel.setBounds(250,350,150,30);
		this.AvcopyLabelTF.setBounds(400,350,120,30);
		this.bNameLabel.setBounds(250, 200, 120, 30);
		this.userTF.setBounds(400, 150, 120, 30);
		this.bNameTF.setBounds(400, 200, 120, 30);
		this.phoneLabel.setBounds(250, 250, 150, 30);
		this.phoneTF1.setBounds(400, 250, 120, 30);
		this.roleLabel.setBounds(250, 300, 120, 30);
		this.roleTF.setBounds(400, 300, 120, 30);
		this.enterBtn.setBounds(250, 420, 120, 30);
		this.backBtn.setBounds(400, 420, 120, 30);
		
		
		BidLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
		BidLabel.setForeground(new Color(0,0,139));
		bNameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
		bNameLabel.setForeground(new Color(0,0,139));
		phoneLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
		phoneLabel.setForeground(new Color(0,0,139));
		AvcopyLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
		AvcopyLabel.setForeground(new Color(0,0,139));
		roleLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
	    roleLabel.setForeground(new Color(0,0,139));
		
		panel=new JPanel();
		panel.setSize(800, 600);
		panel.setBackground(new Color(127,255,212));
		panel.setLayout(null);
		this.add(panel);
		
		pageNameLabel=new JLabel("Add Book");
		pageNameLabel.setBounds(320, 40, 200, 50);
		pageNameLabel.setFont(new Font("times new roman", Font.BOLD, 30));
		pageNameLabel.setForeground(new Color(75,0,130));
		panel.add(pageNameLabel);
	
		panel.add(this.BidLabel);
		panel.add(this.userTF);
		panel.add(this.bNameLabel);
		panel.add(this.bNameTF);
		panel.add(this.phoneLabel);
		panel.add(this.phoneTF1);
		panel.add(this.roleLabel);
		panel.add(this.roleTF);
		panel.add(this.AvcopyLabel);
		panel.add(this.AvcopyLabelTF);
		
	
		panel.add(this.enterBtn);
		panel.add(this.backBtn);
		
		
		enterBtn.addActionListener(this);
		backBtn.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		
	
      		
			
	}	

	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==backBtn){
			
			new Librarian();
			this.dispose();
		}
		if(e.getSource()==enterBtn){
			
			 BookID=userTF.getText();
			 BookName=bNameTF.getText();
		     AuthorName=phoneTF1.getText();
		     Edition=roleTF.getText();
			 AvailableCopy=AvcopyLabelTF.getText();
			this.DBConnect();
		}
		
	}
	
   

	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==enterBtn)
		{
			enterBtn.setBackground(new Color(176,196,222));
			enterBtn.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==backBtn)
		{
	    backBtn.setBackground(new Color(176,196,222));
		backBtn.setForeground(new Color(72,61,139));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==enterBtn)
		{
			enterBtn.setBackground(new Color(123,104,238));
			enterBtn.setForeground(Color.white);
		}

		if(e.getSource()==enterBtn)
		{
			backBtn.setBackground(new Color(123,104,238));
			backBtn.setForeground(Color.white);
		}
		

	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	
	
	public void DBConnect()
		{
			
			
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;//to get row by row result from DB
			String query="insert into book(BookID,BookName,AuthorName,Edition,AvailableCopy) values('"+ BookID + "','"+BookName+"','"+ AuthorName+"','"+ Edition +"','"+AvailableCopy+"');";
			
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//load driver
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");//connection with database established
				st = con.createStatement();//create statement
				System.out.println("statement created");
				st.execute(query);//getting result
				JOptionPane.showMessageDialog(this, "Book added");
				
			}
			catch(Exception e)
			{
				System.out.println("Exception : " +e.getMessage());
			}
			finally
			{
				try
				{
					if(rs!=null)
						rs.close();

					if(st!=null)
						st.close();

					if(con!=null)
						con.close();
				}
				catch(Exception ex){}
			}
			
			
			
		}
	
	
	
	
public static void main(String []ar)
	{
	new Addbook();
    }
}