import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
class Librarian extends JFrame implements ActionListener{

	MemberDetails r;
	JButton btnSearch;
	JButton btnSearchc;
	JButton btnCustomer;
	JButton btnReturn;
	JButton btnDelete;
	
	
    JTextField txtSearch;
	JTextField txtSearchc;
	
	JLabel lblSearch;
	JLabel lblSearchc;
	JLabel lblName;
	
	
	public Librarian(){
		
		this.setTitle("Librarian");
		this.lblName = new JLabel("For Librarian:");
		this.lblSearch = new JLabel("Search Book:");
		this.lblSearchc = new JLabel("Search Customer:");
		
		this.txtSearch = new JTextField();
		this.txtSearchc = new JTextField();
		
		this.btnSearch = new JButton("Search");
		this.btnSearchc = new JButton("Member Search");
		this.btnReturn = new JButton("Return");
		this.btnDelete = new JButton("Add Book");
		
		
		
		this.setLayout(null);
		this.setSize(800,800);
		
		this.lblSearch.setBounds(200,220,400,100);
		this.lblSearchc.setBounds(180,320,400,100);
	    this.lblName.setBounds(300,100,400,100);
		lblName.setFont(new Font("century gothic", Font.PLAIN, 30));
		
		this.txtSearch.setBounds(290,250,120,30);
		this.txtSearchc.setBounds(290,350,120,30);
		
		
		this.btnSearch.setBounds(450,250,100,30);
		this.btnSearchc.setBounds(450,350,150,30);
		this.btnDelete.setBounds(390,500,150,30);
		this.btnReturn.setBounds(210,500,150,30);
		
		
		//lblProjectName.setFont(new Font("century gothic", Font.PLAIN, 25));
		
		//lblProjectName.setForeground(Color.cyan);
	
	    add(this.lblName);
		add(this.lblSearch);
		add(this.lblSearchc);
		
		add(this.txtSearch);
		add(this.txtSearchc);
		
		add(this.btnSearch);
		add(this.btnSearchc);
		//add(this.btnCustomer);
		add(this.btnDelete);
		add(this.btnReturn);
		
	
		
	    btnSearch.addActionListener(this);
		  btnSearchc.addActionListener(this);
		//btnCustomer.addActionListener(this);
		btnDelete.addActionListener(this);
		btnReturn.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
			
		
	   
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnReturn){
			new Home();
			this.dispose();
			//this.setVisible(false);
		}
		if(e.getSource()==btnSearch){
			this.DBConnect1();
			//new BookInfo();
			//this.dispose();
			//this.setVisible(false);
		}
		if(e.getSource()==btnSearchc){
			this.DBConnect();
			//new MemberDetails();
			//this.dispose();
			//this.setVisible(false);
		}
	}
	public void DBConnect1()
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
					JOptionPane.showMessageDialog(this, " Fill up the gaps ");
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
	
	public void DBConnect()
		{
			
			String query="select UserName,Name,Status from member where UserName='"+txtSearchc.getText()+"'";
			String query1="select BookID,BookName,AuthorName,Edition,AvailableCopy from Book where BookName='"+txtSearch.getText()+"'";
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
					String UserName=rs.getString("UserName");
					String Name=rs.getString("Name");
					String Status=rs.getString("Status");
					if(UserName.equals(new String(txtSearchc.getText())))
					{
						//new MemberDetails();
					 MemberDetails da =new MemberDetails(UserName,Name,Status);
					 this.dispose();
					
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Name");
						txtSearchc.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Fill up the gaps ");
					txtSearchc.setText("");
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

	

	/*public static void main(String [] ar){
		new Librarian(); 
	}*/
	
}
