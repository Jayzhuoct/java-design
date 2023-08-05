package controller;
import java.awt.BorderLayout;

import util.DbUtil;
import vo.User;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import service.UserService;

@SuppressWarnings({ "unused", "serial" })
public class AdminUI extends JFrame implements ActionListener{
	/*
	 * 
	 * 管理员端的界面
	 */
	JTable table;
	JLabel label1,label2,label3,label4,label5;
	Object a[][];
	Object name[] = {"编号","车型","车主","价格(元/天)","颜色","是否被租用","租用的用户"};
	JButton buttonOfXinxiluru,buttonOfuserliulan,buttonOfuserxiugai,buttonOfUdelete,
	        buttonOfXinxiliulan,buttonOfDelete,buttonOfLogout,buttonOfXiangXi,buttonOfXiugai,buttonOfRental;
	Box box1,box2;
	JTextField field,field2,field3,field4;
	JPanel jPanel4,jPanel5;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public AdminUI(Boolean success)
	{
		
		init();
		setVisible(true);
		setBounds(500, 200, 700, 750);
		setTitle("管理员界面");
		if(success)//successs是一个boolean类型，如果为true，打开此窗口直接信息浏览，false表里面没有信息，需要点击信息浏览！
		{
			xinXiLiuLan();			
		}
	}
	
	void init()
	{
		label1 = new JLabel("汽车租赁信息管理系统");
		buttonOfXinxiluru = new JButton("  汽车信息录入  ");
		buttonOfXinxiluru.addActionListener(this);
		
		buttonOfXinxiliulan = new JButton("  汽车信息浏览  ");
		buttonOfXinxiliulan.addActionListener(this);
		
		buttonOfuserliulan = new JButton("  用户信息浏览  ");
		buttonOfuserliulan.addActionListener(this);
		
		buttonOfRental = new JButton("  租赁信息浏览  ");
		buttonOfRental.addActionListener(this);
		
		buttonOfuserxiugai = new JButton("  用户信息修改  ");
		buttonOfuserxiugai.addActionListener(this);
		
		buttonOfUdelete = new JButton("  用户信息删除  ");
		buttonOfUdelete.addActionListener(this);
		
		buttonOfDelete = new JButton("    删	            除      ");
		buttonOfDelete.addActionListener(this);
		buttonOfLogout = new JButton("  退   出   登   录  ");
		buttonOfLogout.addActionListener(this);
		buttonOfXiugai = new JButton("    修	           改      ");
		buttonOfXiugai.addActionListener(this);
		buttonOfXiangXi = new JButton("  详   细   信   息  ");
		buttonOfXiangXi.addActionListener(this);
		label2 = new JLabel("待删除信息车牌号：");
		label3 = new JLabel("待修改信息的车牌号：");
		label4 = new JLabel("待查询车辆备注的车牌号：");
		label5 = new JLabel("需操作的用户名 ：   ");
		field = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		
		
		
		a = new Object[50][7];
		table = new JTable(a, name);//组件的创建
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		
		box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(20));
		box1.add(buttonOfXinxiluru);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(buttonOfXinxiliulan);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(buttonOfuserliulan);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(buttonOfRental);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(label5);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(field4);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(buttonOfUdelete);		
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(buttonOfuserxiugai);
		
		box1.add(Box.createVerticalStrut(15));
		box1.add(label2);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field);
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfDelete);
		box1.add(Box.createVerticalStrut(25));
		box1.add(label3);
		box1.add(Box.createVerticalStrut(5));
		box1.add(field2);
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfXiugai);
		box1.add(Box.createVerticalStrut(25));
		box1.add(label4);
		box1.add(Box.createVerticalStrut(5));
		box1.add(field3);
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfXiangXi);
		box1.add(Box.createVerticalStrut(40));
		box1.add(buttonOfLogout);
		
		box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalStrut(10));
		box2.add(box1);   //左边的按钮部分用 box布局
		
		jPanel4 = new JPanel();
		jPanel5 = new JPanel();
		jPanel4.setLayout(new BorderLayout());
		jPanel4.add(box2,BorderLayout.NORTH);//把左边的按钮部分放到jpanel4中。
		jPanel5.setLayout(new BorderLayout());
		jPanel5.add(label1,BorderLayout.NORTH);
		jPanel5.add(scrollPane,BorderLayout.CENTER);//把表格 放jpanel5里
	
		this.setLayout(new BorderLayout());
		add(jPanel5,BorderLayout.EAST);
		add(jPanel4,BorderLayout.WEST);//把两个大的panel放到窗口里面				
	}
	
	
	public void connDB() {
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

	public void closeDB() 
	{
		try {
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void xinXiLiuLan()//信息浏览的方法，因为删除数据后会刷新一下，自动调用此函数。
	{
		int i=0;
		 while(i<50)
		 {
			 a[i][0]=" ";
			 a[i][1]=" ";
			 a[i][2]=" ";
			 a[i][3]=" ";
			 a[i][4]=" ";
			 a[i][5]=" ";
			 a[i][6]=" "; 
			 i++;
		 }
		 i=0;
		 this.connDB();
		 try {
			stmt = con.createStatement();
			 String sql= "select * from car";
			 rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 String number = rs.getString("carnum");
				 String cartype = rs.getString("cartype");
				 String carower = rs.getString("num");
				 String price = rs.getString("price");
				 String color = rs.getString("color");
				 String  hire= rs.getString("hire");
				 String username= rs.getString("username");
				 a[i][0]=number;
				 a[i][1]=cartype;
				 a[i][2]=carower;
				 a[i][3]=price;
				 a[i][4]=color;
				 a[i][5]=hire;
				 a[i][6]=username;
				 i++;
				 
			 }
			 this.closeDB();
			 repaint();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 this.closeDB();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == buttonOfXinxiluru)
		{
			this.dispose();
			new Input();
		}
		else if(source == buttonOfXinxiliulan)
		{
			xinXiLiuLan();
			
		}
		else if (source == buttonOfUdelete) {
			if(field4.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null, "输入用户名！");
			}else {
				vo.User user = new User();
				UserService us = new UserService();
				user.setUsername(field4.getText());
				if (us.showUser(user).getUsername().equals(field4.getText())) {
					us.delete(user);
					JOptionPane.showMessageDialog(null, "删除成功！");
				}else {
					JOptionPane.showMessageDialog(null, "用户名不存在！");
				}
			}
		}
		else if(source == buttonOfXiugai)
		{
			
			if(field2.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null, "输入修改车型的编号！");
			}
			else
			{
				this.dispose();
				new InfoMod(field2.getText());
			}
		}
		else if(source == buttonOfXiangXi)//点击详细信息按钮
		{
			this.dispose();
			new Info(field3.getText());
		}
		else if(source == buttonOfuserliulan)
		{
			this.dispose();
			new UserAll();
		}
		else if(source == buttonOfDelete)//点击删除按钮
		{
			if(field.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "请输入删除车辆的编号！");
			}
			else
			{
				this.connDB();
				String sql;
				try {
					stmt = con.createStatement();
					sql = "select * from car_information  where number='"+field.getText()+"'";//表里找到需要删除的车信息
					rs = stmt.executeQuery(sql);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					if(rs.next())//判断是否有 输入编号的 车辆
					{
						
						int n = JOptionPane.showConfirmDialog(this, "确定删除此车辆信息？","确认对话框",JOptionPane.YES_NO_OPTION);//确认文本框
						if(n == JOptionPane.YES_OPTION)
						{	
							String hire2 = rs.getString("hire");
							if(hire2.equals("是"))
							{
								int m = JOptionPane.showConfirmDialog(this, "此车辆正在被租用，是否删除？","确认对话框",JOptionPane.YES_NO_OPTION);//确认文本框
								if(m == JOptionPane.YES_OPTION)
								{
									try
									{
										stmt = con.createStatement();
										String sql2 = "delete from car_information where number='"+field.getText()+"';";
										stmt.executeUpdate(sql2);
									}
									catch (SQLException e1)
									{
										e1.printStackTrace();
									}
									this.closeDB();
									repaint();
									field.setText("");
									JOptionPane.showMessageDialog(null,"删除成功！");
									xinXiLiuLan();
									return;
								}
								else 
								{
									return;				
								}
							}
							try
							{
								stmt = con.createStatement();
								String sql2 = "delete from car where carnum='"+field.getText()+"';";
								stmt.executeUpdate(sql2);
							}
							catch (SQLException e1)
							{
								e1.printStackTrace();
							}
							this.closeDB();
							repaint();
							field.setText("");
							JOptionPane.showMessageDialog(null,"删除成功！");
							xinXiLiuLan();
							
						}
						else if(n == JOptionPane.NO_OPTION)
						{
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "没有此编号的车辆信息！");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}												
			}
			
		}
		
		else if (source == buttonOfuserxiugai) {
			new AdminUserRevise(field4.getText());
		}
		
		else if (source == buttonOfRental) {
			new Rental();
		}
		else if(source == buttonOfLogout)//退出
		{
			this.dispose();
			new Login();
			
		}
		
	}

}
