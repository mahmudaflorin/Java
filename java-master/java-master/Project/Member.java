import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
class Member extends JFrame implements ActionListener{

	
	JButton btnSearch;
	JButton btnBorrow;
	JButton btnReturn;
	JButton btnBack;
	
	
    JTextField txtSearch;
	JLabel lblSearch;
	JLabel lblName;
	
	
	public Member(){
		
		this.setTitle("Member");
		this.lblName = new JLabel("For Member:");
		this.lblSearch = new JLabel("Search Book:");
		
		this.txtSearch = new JTextField();
		//this.txtPass = new JPasswordField();
		
		this.btnSearch = new JButton("Search");
		this.btnBorrow = new JButton("Borrow Book");
		this.btnReturn = new JButton("Return Book");
		this.btnBack = new JButton("Back");
		
		
		
		this.setLayout(null);
		this.setSize(800,800);
		
		this.lblSearch.setBounds(200,220,400,100);
	    this.lblName.setBounds(300,100,400,100);
		lblName.setFont(new Font("century gothic", Font.PLAIN, 30));
		
		this.txtSearch.setBounds(290,250,120,30);
		
		
		this.btnSearch.setBounds(450,250,100,30);
		this.btnBorrow.setBounds(200,400,150,30);
		this.btnReturn.setBounds(390,400,150,30);
		this.btnBack.setBounds(300,470,150,30);
		
		
		//lblProjectName.setFont(new Font("century gothic", Font.PLAIN, 25));
		
		//lblProjectName.setForeground(Color.cyan);
	
	    add(this.lblName);
		add(this.lblSearch);
		
		add(this.txtSearch);
		
		add(this.btnSearch);
		add(this.btnBorrow);
		add(this.btnReturn);
		add(this.btnBack);
		
	
		
	    btnSearch.addActionListener(this);
		btnBorrow.addActionListener(this);
		btnReturn.addActionListener(this);
		btnBack.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
			
		
	   
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnReturn){
			this.dispose();
			new ReturnBook();
			
			//this.setVisible(false);
		}
		if(e.getSource()==btnSearch){
			this.DBConnect();
			//this.dispose();
			
			
			//this.setVisible(false);
		}
		if(e.getSource()==btnBorrow){
			this.dispose();
			new BorrowBook();
			
			//this.setVisible(false);
		}
		if(e.getSource()==btnBack){
			
			new Home();
			this.dispose();
			
			//this.setVisible(false);
		}
	}
	
	public void DBConnect()
		{
			
			String query="select BookID,BookName,AuthorName,Edition,AvailableCopy from Book where BookName='"+txtSearch.getText()+"'";
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;//to get row by row result from DB
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//load driver
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				System.out.println("connection done");//connection with database established
				st = con.createStatement();//create statement
				System.out.println("statement created");
				rs = st.executeQuery(query);//getting result
				System.out.println("results received");
				
				if(rs.next())
				{
					String BookID=rs.getString("BookID");
					String BookName=rs.getString("BookName");
					String AuthorName=rs.getString("AuthorName");
					String Edition=rs.getString("Edition");
					String AvailableCopy=rs.getString("AvailableCopy");
					
					if(BookName.equals(new String(txtSearch.getText())))
					{
					
					 BookInfo a =new BookInfo(BookID,BookName,AuthorName,Edition,AvailableCopy);
					 this.dispose();
					
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Name ");
						txtSearch.setText("");
					}
				}
				else
				{
					txtSearch.setText("");
				}
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
	
	

	public static void main(String [] ar){
		new Member(); 
	}
	
}
