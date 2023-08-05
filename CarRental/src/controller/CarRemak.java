package controller;
import java.awt.HeadlessException;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import util.DbUtil;

/*
 * 
 * 这个车辆界面详细信息 用户端
 */
@SuppressWarnings("serial")
public class CarRemak extends JFrame implements ActionListener{
	
	JTextArea area;
	Box box1,baseBox,box2,baseBox2;
	JButton buttonOfBianJi,buttonOfFanHui;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String number=null;
	int setEnable =0;
	String information;
	String username = null;
	
	public  CarRemak(String number,String username)
	{
		
		init();
		setVisible(true);
		setBounds(500, 200, 620, 360);
		setTitle("车辆详细信息界面");
		this.number = number;
		this.username = username;
		setArea();
	}
	
	public  void setArea()//打开界面就把 数据库中的详细信息写入到area中
	{
		this.connDB();
		try {
			stmt = con.createStatement();
			String sql = "select * from car_information where number='"+number+"'; ";
			rs = stmt.executeQuery(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			if(rs.next())
			{
				information = rs.getString("information");
				area.setText(information);
				area.setEnabled(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"没有此编号的车辆的详细信息！");
			}
			
		} catch (HeadlessException e2) {
			e2.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	void init()
	{
		JLabel label = new JLabel("车辆的详细信息：");
		area = new JTextArea(10, 10);
		buttonOfFanHui = new JButton("返回");
		buttonOfFanHui.addActionListener(this);
	
		box1 = Box.createVerticalBox();
		box1.add(box1.createVerticalStrut(8));
		box1.add(label);
		box1.add(area);
		
		
		box2 = Box.createHorizontalBox();
		box2.add(box2.createHorizontalStrut(8));
		box2.add(buttonOfFanHui);
		
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(baseBox.createHorizontalStrut(10));
		baseBox.add(box1);
		baseBox.add(baseBox.createHorizontalStrut(10));
		
		baseBox2 = Box.createVerticalBox();
		baseBox2.add(baseBox);
		baseBox2.add(baseBox2.createVerticalStrut(10));
		baseBox2.add(box2);
		baseBox2.add(baseBox2.createVerticalStrut(10));
		
		add(baseBox2);
		
		
		
	}
	
	public void connDB() { // 连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");//注册驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {//创建连接
			con = DriverManager.getConnection(DbUtil.dbUrlString, DbUtil.dbUser, DbUtil.dbpassword);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	public void closeDB() // 关闭连接
	{
		try {
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	 if (source == buttonOfFanHui)
		{
			this.dispose();
			new UserUI(username);
		}							
		}			
}
