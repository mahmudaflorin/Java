import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
class BorrowBook extends JFrame implements ActionListener,MouseListener
{

	

	
	JButton btnReturn;
	JButton btnLogout;
	JButton btnDone;
	
    JTextField txtCustomerid;
	JTextField txtBookid;
	JTextField txtBorrow;
	JTextField txtReturn;

	
	JLabel lblCustomerid;
	JLabel lblBookid;
	JLabel lblBorrow;
	JLabel lblReturn;
    JLabel lblFine;
	JLabel lblName;
	JPanel panel;
	
	public BorrowBook(){
		
		this.lblCustomerid = new JLabel("Customer ID :");
		this.lblBookid = new JLabel("Book ID :");
		this.lblBorrow = new JLabel("Borrow Date:");
		this.lblReturn = new JLabel("Return Date :");
	    this.lblName = new JLabel("Borrow Book");
		
		
		this.txtCustomerid = new JTextField();
		this.txtBookid = new JTextField();
		this.txtBorrow = new JTextField();
		this.txtReturn = new JTextField();
		
		
		
	    this.btnReturn = new JButton("Return");
		this.btnLogout = new JButton("Logout");
		this.btnDone = new JButton("Done");
		btnDone.setBackground(new Color(153,50,204));
		btnDone.setForeground(Color.white);
		btnDone.addMouseListener(this);
		btnLogout.setBackground(new Color(153,50,204));
		btnLogout.setForeground(Color.white);
		btnLogout.addMouseListener(this);
		btnReturn.setBackground(new Color(153,50,204));
		btnReturn.setForeground(Color.white);
		btnReturn.addMouseListener(this);
		
		this.setLayout(null);
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.lblCustomerid.setBounds(200,150,120,30);
		this.lblBookid.setBounds(200,200,120,30);
		this.lblBorrow.setBounds(200,250,120,30);
		this.lblReturn.setBounds(200,300,120,30);
		this.lblName.setBounds(240,30,400,100);
		
		this.txtCustomerid.setBounds(320,150,120,30);
		this.txtBookid.setBounds(320,200,120,30);
		this.txtBorrow.setBounds(320,250,120,30);
		this.txtReturn.setBounds(320,300,120,30);
	
		
		
		this.btnReturn.setBounds(210,470,100,30);
		this.btnLogout.setBounds(380,470,100,30);
		this.btnDone.setBounds(290,400,100,30);
		
		lblCustomerid.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblCustomerid.setForeground(new Color(0,0,139));
		lblBookid.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblBookid.setForeground(new Color(0,0,139));
		lblBorrow.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblBorrow.setForeground(new Color(0,0,139));
		lblReturn.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
		lblReturn.setForeground(new Color(0,0,139));
		lblReturn.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
	    lblReturn.setForeground(new Color(0,0,139));
		
		
		
		lblName.setFont(new Font("Forte", Font.BOLD, 30));
		lblName.setForeground(new Color(75,0,130));
		
		
	
		add(this.lblCustomerid);
		add(this.lblBookid);
		add(this.lblBorrow);
		add(this.lblReturn);
		add(this.lblName);
		
		add(this.txtCustomerid);
		add(this.txtBookid);
		add(this.txtBorrow);
		add(this.txtReturn);
	
	
		add(this.btnReturn);
		add(this.btnLogout);
		add(this.btnDone);
		
	
		
		btnReturn.addActionListener(this);
		btnLogout.addActionListener(this);
		btnDone.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	

		panel=new JPanel();
		panel.setSize(700,600);
		panel.setBackground(new Color(127,255,212));
		panel.setLayout(null);
		this.add(panel);
		
			
	   
	}
	public void actionPerformed(ActionEvent e){
		
	
	/*if(e.getSource()==btnDone)
		{
			
			String a = txtCustomerid.getText();
			String b = txtBookid.getText();
			
			try {
			String date1 = txtBorrow.getText();
			String time1 = "11:00 AM";
			String date2 = txtReturn.getText();
			String time2 = "12:15 AM";
 
			String format = "MM/dd/yyyy hh:mm a";
 
			SimpleDateFormat sdf = new SimpleDateFormat(format);
 
			Date dateObj1 = sdf.parse(date1 + " " + time1);
			Date dateObj2 = sdf.parse(date2 + " " + time2);
 
			DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
 
			long diff = dateObj2.getTime() - dateObj1.getTime();
 
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			System.out.println(+diffDays);
			if(diffDays>=7)
			{				
		   int x=((diffDays-7)*10);
		   String y=Integer.toString(x);
           txtFine.setText(y);
		} 
		else{txtFine.setText("No Fine");}
		System.out.println(+diffDays);}
		catch (Exception s) {
			s.printStackTrace();
		}
		    txtCustomerid.setText("");
			txtBookid.setText("");
			txtBorrow.setText("");
			txtReturn.setText("");

	}*/
	if(e.getSource()==btnReturn)
		{
			new Home();
			this.dispose();
		}
		}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnDone)
		{
			btnDone.setBackground(new Color(176,196,222));
			btnDone.setForeground(new Color(72,61,139));
		}
		if(e.getSource()==btnLogout)
		{
	    btnLogout.setBackground(new Color(176,196,222));
		btnLogout.setForeground(new Color(72,61,139));
		}
		
		if(e.getSource()==btnReturn)
		{
	    btnReturn.setBackground(new Color(176,196,222));
		btnReturn.setForeground(new Color(72,61,139));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnDone)
		{
			btnDone.setBackground(new Color(123,104,238));
			btnDone.setForeground(Color.white);
		}

		if(e.getSource()==btnLogout)
		{
			btnLogout.setBackground(new Color(123,104,238));
			btnLogout.setForeground(Color.white);
		}
		
		if(e.getSource()==btnReturn)
		{
			btnReturn.setBackground(new Color(123,104,238));
			btnReturn.setForeground(Color.white);
		}
		
		

	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	

	/*public static void main(String [] ar){
		new BorrowBook(); 
	} */
}
	

