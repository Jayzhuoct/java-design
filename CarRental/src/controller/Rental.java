package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import util.DbUtil;

@SuppressWarnings({ "serial", "unused" })
public class Rental extends JFrame implements ActionListener{

	/**
	 * ������Ϣչʾ
	 */	
	JTable table;
	Object name[] = {"���ƺ�","�û���","��������","���"};
	Object a[][];
	Box box1,box2,basebox;
	JButton buttonOfFanhui;
	JPanel jPanel1,jPanel2;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String username =null;
	
	public Rental ()
	{			
		init();		
		setVisible(true);
		setBounds(500, 200, 500,480);
		setTitle("������Ϣ���");	
		showUserInfo();
	}
	
	void init()
	{
		
		JTextArea area = new JTextArea(200, 200);		
		a = new Object[50][7];	
		table = new JTable(a, name);//����Ĵ���
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);		
		box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(0));		
		box1.add(area);
		box2 = Box.createHorizontalBox();
		buttonOfFanhui = new JButton("����");
		buttonOfFanhui.addActionListener(this);
		box2.add(buttonOfFanhui);		
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel1.add(box2,BorderLayout.NORTH);
        jPanel2.add(box1,BorderLayout.CENTER);
		jPanel1.add(scrollPane,BorderLayout.CENTER);
		add(jPanel1,BorderLayout.SOUTH);
		add(jPanel2,BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		Object source = e.getSource();
		if (source == buttonOfFanhui) {						
				new AdminUI(false);
			
		}
	}
	
	public void connDB() { // �������ݿ�
		try {
			Class.forName("com.mysql.jdbc.Driver");//ע������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {//��������
			con = DriverManager.getConnection(DbUtil.dbUrlString, DbUtil.dbUser, DbUtil.dbpassword);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void closeDB() // �ر�����
	{
		try {
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void showUserInfo()
	{
		 int i=0;
		 while(i<50)
		 {
			 a[i][0]=" ";
			 a[i][1]=" ";
			 a[i][2]=" ";
			 a[i][3]=" ";		
			 i++;
		 }
		 i=0;
		 this.connDB();
		 try {
			stmt = con.createStatement();
			 String sql= "select * from rental";
			 rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 String name = rs.getString("carnum");
				 String pass = rs.getString("username");
				 String card = rs.getString("days");
				 String phone = rs.getString("allprice");				
				 a[i][0]=name;
				 a[i][1]=pass;
				 a[i][2]=card;
				 a[i][3]=phone;				
				 i++;				 
			 }
			 this.closeDB();
			 repaint();
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
		 this.closeDB();
	}		
}
