package controller;
import java.awt.BorderLayout;
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

import util.DbUtil;
@SuppressWarnings("serial")
public class UserUI extends JFrame implements ActionListener{
	/*
	 * 
	 * 用户端的界面
	 */
	JTable table;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	Object a[][];
	Object name[] = {"车牌号","车型","门店号","价格","颜色","是否被租用","备注"};
	JButton buttonOfKe,buttonOfXinxiliulan,buttonOfQyueding,buttonOfLogout,buttonOfXiangXi,buttonOfWo,buttonOfId,buttonOfWoke,buttonOfRelet,buttonOfReturn;
	Box box1,box2;
	JTextField field,field2,field3,field4,field5,field6,field7;
	JPanel jPanel4,jPanel5;
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String username =null;
	public UserUI(String username)
	{
		
		init();
		setVisible(true);
		setBounds(500, 100, 700, 900);
		setTitle("用户界面");
		this.username = username;
	}
	
	void init()
	{
		label1 = new JLabel("汽车租赁信息浏览系统");
		buttonOfKe = new JButton("   可 租 用 车 辆   ");
		buttonOfKe.addActionListener(this);
		
		buttonOfXinxiliulan = new JButton("   汽车信息浏览   ");
		buttonOfXinxiliulan .addActionListener(this);
		
		buttonOfQyueding = new JButton("    确	            定       ");
		buttonOfQyueding.addActionListener(this);
		
		buttonOfLogout = new JButton("   退   出   登   录   ");
		buttonOfLogout.addActionListener(this);
		
		buttonOfXiangXi = new JButton("   详   细   信   息   ");
		buttonOfXiangXi.addActionListener(this);
		
		buttonOfId = new JButton("   修   改   信   息   ");
		buttonOfId.addActionListener(this);
		
		buttonOfWo = new JButton("   我   租   的   车   ");
		buttonOfWo.addActionListener(this);
		
		buttonOfWoke = new JButton("   计   算   租   金   ");
		buttonOfWoke.addActionListener(this);
		
		buttonOfRelet = new JButton("   续           租      ");
		buttonOfRelet.addActionListener(this);
		
		buttonOfReturn = new JButton("   归           还      ");
		buttonOfReturn.addActionListener(this);
		
		label2 = new JLabel("输入需要租用的汽车：");
		label3 = new JLabel("输入需要租用的天数：");
		label4 = new JLabel("查询备注的车牌号码：");
		label5 = new JLabel("所      需       租     金：");
		label6 = new JLabel("输入你需要操作的车牌号：");
		label7 = new JLabel("输入你要续租的天数：");
		label8 = new JLabel("所  需  续  租  的  租  金： ");
		
		field = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		field5 = new JTextField();
		field6 = new JTextField();
		field7 = new JTextField();
		
		a = new Object[50][7];
		table = new JTable(a, name);//组件的创建
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		
		box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(20));
		box1.add(buttonOfKe);
		
		box1.add(Box.createVerticalStrut(10));
		box1.add(buttonOfXinxiliulan);
		
		box1.add(Box.createVerticalStrut(15));
		box1.add(label2);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfQyueding);
		
		box1.add(Box.createVerticalStrut(15));
		box1.add(label3);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field2);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfWoke);	
		
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(label5);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field4);
			
		box1.add(Box.createVerticalStrut(15));
		box1.add(label4);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field3);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfXiangXi);
			
		box1.add(Box.createVerticalStrut(20));		
		box1.add(buttonOfWo);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(label6);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field5);	
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(label7);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field6);
					
		box1.add(Box.createVerticalStrut(5));
		box1.add(label8);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(field7);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfRelet);
		
		box1.add(Box.createVerticalStrut(5));
		box1.add(buttonOfReturn);	
		
		box1.add(Box.createVerticalStrut(20));	
		box1.add(buttonOfId);
		
		box1.add(Box.createVerticalStrut(10));
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
	
	public void xinXiLiuLan()
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
				 String information = rs.getString("information");
				 a[i][0]=number;
				 a[i][1]=cartype;
				 a[i][2]=carower;
				 a[i][3]=price;
				 a[i][4]=color;
				 a[i][5]=hire;
				 a[i][5]=information;
				 i++;
				 
			 }
			 this.closeDB();
			 repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 this.closeDB();
	}

	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == buttonOfKe)//点击可以租用车辆的按钮
		{
			int success = 0;//用来判断有没有没被租用的车辆，如果能返回 “否” 值的集，则赋值为 1 
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
			 i=0;//i 赋值为 0，为下面的循环做准备
			 this.connDB();
			 try {
				stmt = con.createStatement();
				 String sql= "select * from car where hire= '否';";//查询表里面 没被租用的车辆
				 rs = stmt.executeQuery(sql);
				 while(rs.next())//把查询到的信息写入 table
				 {
					 String number = rs.getString("carnum");
					 String cartype = rs.getString("cartype");
					 String carower = rs.getString("num");
					 String price = rs.getString("price");
					 String color = rs.getString("color");
					 String hire = rs.getString("hire");
					 String information = rs.getString("information");
					
					 a[i][0]=number;
					 a[i][1]= cartype;
					 a[i][2]=carower;
					 a[i][3]=price;
					 a[i][4]=color;
					 a[i][5]=hire;
					 a[i][6]=information;
					 
					 
					 i++;
					 success = 1;
				 }
				 this.closeDB();
				 repaint();//刷新一下
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 if(success == 0)
			 {
				 JOptionPane.showMessageDialog(null, "都已经被租用！");
			 }
		}
		else if(source == buttonOfXinxiliulan)//点击信息浏览按钮
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
					 String hire = rs.getString("hire");
					 String information = rs.getString("information");
					 
					 a[i][0]=number;
					 a[i][1]=cartype;
					 a[i][2]=carower;
					 a[i][3]=price;
					 a[i][4]=color;
					 a[i][5]=hire;
					 a[i][6]=information;					 
					 i++;
				 }
				 this.closeDB();
				 repaint();
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			 
			
		}
		else if (source == buttonOfQyueding)//点击租用的确定键
		{
			if(field.getText().equals(""))//是否为空
			{
				JOptionPane.showMessageDialog(null, "请输入租用车辆的编号！");
				if(field2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入租用天数！");
				}
			}
			else//不为空
			{
				this.connDB();
				String sql;
				try {
					stmt = con.createStatement();
					sql = "select * from car  where carnum='"+field.getText()+"' and hire = '否'";//获取输入的序号并且没被租用的信息
					rs = stmt.executeQuery(sql);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					if(rs.next())//判断是否存在 此车辆
					{
						int n = JOptionPane.showConfirmDialog(this, "确定租用此车辆信息？","确认对话框",JOptionPane.YES_NO_OPTION);
						if(n == JOptionPane.YES_OPTION)//确认框
						{	
							try
							{
								stmt = con.createStatement();
								String sql2 = "update  car set hire = '是' ,username='"+username+"'where carnum='"+field.getText()+"';";//把租用的赋值为 是 								
								stmt.executeUpdate(sql2);
								String sql3 = "select price from car where carnum='"+field.getText()+"';";
								ResultSet rs = stmt.executeQuery(sql3);
								rs.next();
								int p,t,y;
								p=Integer.parseInt(field2.getText());
								t=Integer.parseInt(rs.getString("price"));
								y=p*t;
								rs.close();
								String allprice = String.valueOf(y);
								String sql4 ="insert into rental values("+field.getText()+","+username+","+field2.getText()+","+allprice+")";								
								stmt.executeUpdate(sql4);
								
							}
							catch (SQLException e1)
							{
								e1.printStackTrace();
							}
							this.closeDB();
							repaint();
							field.setText("");
							JOptionPane.showMessageDialog(null,"租用成功！");
							xinXiLiuLan();							
						}
						
						else if(n == JOptionPane.NO_OPTION)
						{
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "无法租用此车辆！");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		}

		else if(source == buttonOfXiangXi)
		{
			this.dispose();
			new CarRemak(field2.getText(),username);
		}

		else if(source == buttonOfWoke)
		{
			if(field.getText() == "")
			{
				JOptionPane.showMessageDialog(null, "请输入车牌号！");
				if(field2.getText() == "")
				{
					JOptionPane.showMessageDialog(null, "请输入租用天数！");
				}
			}
			else
			{
				this.connDB();				 		
				try {
					stmt = con.createStatement();					
					String sql = "select price from car where carnum = '" + field.getText() + "';";				
				    ResultSet rs = stmt.executeQuery(sql);
				    rs.next();
				    int p,t,y;
					p=Integer.parseInt(field2.getText());
					t=Integer.parseInt(rs.getString("price"));
					y=p*t;
					rs.close();
					String allprice = String.valueOf(y);		  					
					field4.setText(allprice);	
					rs.close();
		            stmt.close();		               
				}catch (SQLException e4) {
					e4.printStackTrace();
				}				
			}
		}
		
		else if(source == buttonOfRelet)
		{
			this.connDB();
			
			try {
				stmt = con.createStatement();
				String sql = "select username,price from car where carnum="+Integer.parseInt(field5.getText())+";";
				ResultSet rs = stmt.executeQuery(sql);
			    rs.next();			   			    											
				if(String.valueOf(rs.getString("username")).equals(username))
				{				
				String sql1 = "update rental set days = days + " + Integer.parseInt(field6.getText())+ " where carnum="+Integer.parseInt(field5.getText())+";";																		
			    int a,b,c;
				a=Integer.parseInt(field6.getText());
				b=Integer.parseInt(rs.getString("price"));				
				c=a*b;				
				String reprice = String.valueOf(c);		  					
				field7.setText(reprice);					
				String sql3 ="update rental set allprice = allprice + " +c+ " where carnum="+Integer.parseInt(field5.getText())+";";
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql3);
	            rs.close();
				repaint();
				field5.setText("");
				repaint();
				field6.setText("");	
				JOptionPane.showMessageDialog(null,"续租成功！");
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入你已经租用的车辆！");
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			this.closeDB();
			
		}
		
		else if(source == buttonOfReturn)
		{
			this.connDB();
			try {
				stmt = con.createStatement();
				String sql = "select username,price from car where carnum="+Integer.parseInt(field5.getText())+";";
				ResultSet rs = stmt.executeQuery(sql);
			    rs.next();			   			    											
				if(String.valueOf(rs.getString("username")).equals(username))
				{
					String sql1="update car set username = null ,hire = '否' where username = '"+username+"';";
					stmt.executeUpdate(sql1);
					rs.close();
					repaint();
					field5.setText("");
					JOptionPane.showMessageDialog(null, "归还车辆成功！");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入已经租用的车辆！");
				}
				
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		}
		
		else if (source == buttonOfId) {
			new UserRevise();
		}
		
		else if(source == buttonOfLogout)
		{
			this.dispose();
			new Login();
			
		}
		else if (source == buttonOfId) {
			new UserRevise();
		}
		else if(source == buttonOfWo)//点击我租的车辆信息
		{
			int success = 0;//用来判断有没有没自己租用的车辆
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
			 i=0;//i 赋值为 0，为下面的循环做准备
			 this.connDB();
			 try {
				stmt = con.createStatement();
				 String sql= "select * from car where username= '"+username+"';";//查询表里面 自己已经租用的车辆
				 rs = stmt.executeQuery(sql);
				 while(rs.next())//把查询到的信息写入 table
				 {
					 String number = rs.getString("carnum");
					 String cartype = rs.getString("cartype");
					 String carower = rs.getString("num");
					 String price = rs.getString("price");
					 String color = rs.getString("color");
					 String hire = rs.getString("hire");
					 String information = rs.getString("information");
					
					 a[i][0]=number;
					 a[i][1]= cartype;
					 a[i][2]=carower;
					 a[i][3]=price;
					 a[i][4]=color;
					 a[i][5]=hire;
					 a[i][6]=information;
					 i++;
					 success = 1;
				 }
				 this.closeDB();
				 repaint();//刷新一下
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 if(success == 0)
			 {
				 JOptionPane.showMessageDialog(null, "您还没有租用任何车辆！");
			 }
		}
		
		
	}

}
