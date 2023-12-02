import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import java.lang.*;
class Home extends JFrame implements ActionListener{

	//Reg r;
	JButton btnLogin;
	JButton btnReg;
     JTextField txtId;
	JPasswordField txtPass;
	JPanel panel;
	JLabel lblId;
		JLabel lblPass,pageNameLabel,pageNameLabel1;
		JLabel imgLabel;
		 ImageIcon image;
		
	
	public Home(){
		this.panel=new JPanel();
		this.imgLabel=new JLabel();
		this.image=new ImageIcon();
		this.lblId = new JLabel("USER ID :");
		this.lblPass = new JLabel("PASSWORD :");
		this.pageNameLabel=new JLabel("Welcome To Library");
		this.pageNameLabel1=new JLabel("Management System");
		
		this.txtId = new JTextField();
		this.txtPass = new JPasswordField();
		
		this.btnLogin = new JButton("Login");
	    this.btnReg = new JButton("Reg");
		this.setLayout(null);
		this.txtId.setBounds(340,250,120,30);
		this.txtPass.setBounds(340,320,120,30);
		this.btnLogin.setBounds(200,410,100,30);
		this.btnReg.setBounds(370,410,100,30);
		this.lblId.setBounds(200,250,160,30);
		this.lblPass.setBounds(200,320,170,30);
		
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblId.setForeground(Color.black);
		lblPass.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPass.setForeground(Color.black);
	
		pageNameLabel.setBounds(180,60,400,100);
		pageNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		pageNameLabel.setForeground(Color.BLACK);
		panel.add(pageNameLabel);
		pageNameLabel1.setBounds(180,100,400,100);
		pageNameLabel1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		pageNameLabel1.setForeground(Color.BLACK);
		panel.add(pageNameLabel1);
		btnLogin.setBackground(Color.GRAY);
		btnReg.setBackground(Color.GRAY);
		btnLogin.setForeground(Color.WHITE);
		btnReg.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Latin",Font.BOLD,15));
		btnReg.setFont(new Font("Latin",Font.BOLD,15));
		//btnLogin.addMouseListener(this);
		//btnReg.addMouseListener(this);
	    
		add(this.lblId);
		add(this.lblPass);
		add(this.txtId);
		add(this.txtPass);
		add(this.btnLogin);
		add(this.btnReg);
		
		add(this.pageNameLabel);
	    add(this.pageNameLabel1);
		
		
		/*panel.setSize(800,533);
		panel.setBackground(new Color(127,255,212));
		panel.setLayout(null);
		this.add(panel);*/
		
		btnLogin.addActionListener(this);
		btnReg.addActionListener(this);
		
		
	
		
        this.setTitle("ImageDemo");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(737,586);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        //imgLabel=new JLabel();
        imgLabel.setSize(737,586);
        this.add(imgLabel);

        image=new ImageIcon("addbook23.jpg");
        imgLabel.setIcon(image);	
			
		
	   
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnReg){
			new Reg();
			this.dispose();
			//this.setVisible(false);
		}
		if(e.getSource()==btnLogin){
			
			//this.dispose();
			this.DBConnect();
			//this.setVisible(false);
		}
	}
		public void DBConnect()
		{
			String query="select UserName,Password,Status from member where UserName='"+txtId.getText()+"'";
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
					String password=rs.getString("Password");
					if(password.equals(new String(txtPass.getText())))
					{
						System.out.println("Login is Confirmed");
						String type=rs.getString("Status");
						int a= Integer.parseInt(type);
						if(a==0)
						{
						new Member();}
						else if(a==1)
						{
							new Librarian();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Password");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong UserName");
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
		new Home(); 
	}
	
}