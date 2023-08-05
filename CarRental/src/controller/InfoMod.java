package controller;
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
import javax.swing.JTextField;

import util.DbUtil;

@SuppressWarnings("serial")
public class InfoMod extends JFrame implements ActionListener {

	JTextField field1,field2,field3,field4,field5,field6;	
	Box box1,box2,box3,box4,box5,box6,box7,baseBox;
	JButton buttonOfQueDing,buttonOfReset,buttonOfQuXIAO;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String number;
	public InfoMod(String number)
	{
		
		init();
		setVisible(true);
		setBounds(550, 200, 550, 280);
		setTitle("车辆信息修改界面");
		this.number = number;
		setText();
	}
	
	@SuppressWarnings("static-access")
	void init()
	{
		JLabel label1 = new JLabel(" 序        号  : ");
		JLabel label2 = new JLabel(" 车        型  : ");
		JLabel label3 = new JLabel(" 门   店  名: ");
		JLabel label4 = new JLabel(" 价        格  : ");
		JLabel label5 = new JLabel(" 颜        色  : ");
		JLabel label6 = new JLabel("是否被租用:");
	
		
		field1 = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		field5 = new JTextField();
		field6 = new JTextField();
		
		buttonOfQueDing = new JButton("提交");
		buttonOfQueDing.addActionListener(this);
		buttonOfReset = new JButton("重置");
		buttonOfReset.addActionListener(this);
		buttonOfQuXIAO = new JButton("取消");
		buttonOfQuXIAO.addActionListener(this);
		
		box1 = Box.createHorizontalBox();
		box1.add(box1.createHorizontalStrut(8));
		box1.add(label1);
		box1.add(box1.createHorizontalStrut(8));
		box1.add(field1);
		box1.add(box1.createHorizontalStrut(8));
		
		box2 = Box.createHorizontalBox();
		box2.add(box2.createHorizontalStrut(8));
		box2.add(label2);
		box2.add(box2.createHorizontalStrut(8));
		box2.add(field2);
		box2.add(box2.createHorizontalStrut(8));
		
		box3 = Box.createHorizontalBox();
		box3.add(box3.createHorizontalStrut(8));
		box3.add(label3);
		box3.add(box3.createHorizontalStrut(8));
		box3.add(field3);
		box3.add(box3.createHorizontalStrut(8));
		
		box4 = Box.createHorizontalBox();
		box4.add(box4.createHorizontalStrut(8));
		box4.add(label4);
		box4.add(box4.createHorizontalStrut(8));
		box4.add(field4);
		box4.add(box4.createHorizontalStrut(8));
		
		box5 = Box.createHorizontalBox();
		box5.add(box5.createHorizontalStrut(8));
		box5.add(label5);
		box5.add(box5.createHorizontalStrut(8));
		box5.add(field5);
		box5.add(box5.createHorizontalStrut(8));
		
		box6 = Box.createHorizontalBox();
		box6.add(box6.createHorizontalStrut(8));
		box6.add(label6);
		box6.add(box6.createHorizontalStrut(8));
		box6.add(field6);
		box6.add(box6.createHorizontalStrut(8));
		
		box7 = Box.createHorizontalBox();
		box7.add(box7.createHorizontalStrut(8));
		box7.add(buttonOfQueDing);
		box7.add(box7.createHorizontalStrut(8));
		box7.add(buttonOfQuXIAO);
		box7.add(box7.createHorizontalStrut(8));
		box7.add(buttonOfReset);
		box7.add(box7.createHorizontalStrut(8));
		
		baseBox = Box.createVerticalBox();
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box1);
		baseBox.add(Box.createVerticalStrut(10));
		baseBox.add(box2);
		baseBox.add(Box.createVerticalStrut(10));
		baseBox.add(box3);
		baseBox.add(Box.createVerticalStrut(10));
		baseBox.add(box4);
		baseBox.add(Box.createVerticalStrut(10));
		baseBox.add(box5);
		baseBox.add(Box.createVerticalStrut(10));
		baseBox.add(box6);
		baseBox.add(Box.createVerticalStrut(10));
		baseBox.add(box7);
		baseBox.add(Box.createVerticalStrut(15));
		
		add(baseBox);
		
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
	
	public void setText()//此函数功能是 把数据库 需要修改的信息 都打印到界面的文本框中
	{
		String cartype =null;
		String carower=null;
		String price=null;
		String color=null;
		String hire=null;
		field1.setText(number);
		field1.setEnabled(false);
		
		this.connDB();
		try {
			stmt = con.createStatement();
			String sql = "select * from car where carnum = '"+number+"';";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				  cartype = rs.getString("cartype");
				  carower = rs.getString("num");
				  price = rs.getString("price");
				  color = rs.getString("color");
				  hire = rs.getString("hire");
			}else{
				JOptionPane.showMessageDialog(null, "不存在该编号！");
				this.dispose();
				new AdminUI(true);//为ture
			}
			this.closeDB();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		field2.setText(cartype);
		field3.setText(carower);
		field4.setText(price);
		field5.setText(color);
		field6.setText(hire);
	
	}

	public void actionPerformed(ActionEvent e) {
		String cartype =null;
		String carower=null;
		String price=null;
		String color=null;
		String hire=null;	 
		Object source = e.getSource();
		
		this.connDB();
		
		 cartype = field2.getText() ;
		 carower = field3.getText() ;
		 price = field4.getText();
		 color = field5.getText();
		 hire = field6.getText();
				
		if(source == buttonOfQueDing)//点击确定按钮
		{
			if(cartype.equals("")||carower.equals("")||price.equals("")||color.equals("")||hire.equals(""))
			{
				JOptionPane.showMessageDialog(null, "请填写完整！");
			}
			else
			{
				
				int n  = JOptionPane.showConfirmDialog(this, "确定修改此车辆信息？","确认对话框",JOptionPane.YES_NO_OPTION);//确认文本框
				if(n == JOptionPane.YES_OPTION)
				{
					this.connDB();
					try {
						
						stmt = con.createStatement();
						String str =  "update car set cartype='"+cartype+"',num='"+carower+"',price='"+price+"',color='"+color+"',hire='"+hire+"' where carnum = '"+number+"';";
						stmt.executeUpdate(str);
						JOptionPane.showMessageDialog(null, "修改成功！");
						this.closeDB();
						this.dispose();
						new AdminUI(true);//为ture
						
					} catch (SQLException e1) {
					e1.printStackTrace();
	
					}
				}
				else 
				{
				
				}
				
			}
			
		}
		else if(source == buttonOfQuXIAO)
		{
			this.dispose();
			new AdminUI(false);
			
		}
		else if(source == buttonOfReset)
		{
			
			field2.setText("");
			field3.setText("");
			field4.setText("");
			field5.setText("");
			field6.setText("");			
		}
		
		
	}

	
}
