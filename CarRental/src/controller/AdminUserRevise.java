
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.DbUtil;

	@SuppressWarnings("serial")
	public class AdminUserRevise extends JFrame implements ActionListener {
		JTextField field1,field4,field5;
		JPasswordField field2,field3;
		JButton buttonOfZhuce,buttonOfFanhui;
		Box box1,box2,box3,box4,box5,box6,baseBox;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		public AdminUserRevise(String username)
		{
			
			init();
			setVisible(true);
			setBounds(500, 200, 500, 450);
			setTitle("管理员修改用户界面");
		}
		@SuppressWarnings("static-access")
		void init()
		{			
			box1= Box.createHorizontalBox();
			box1.add(new JLabel("新用户名:"));
			box1.add(Box.createHorizontalStrut(8));
			field1 = new JTextField(15);
			box1.add(field1);
			
			box2= Box.createHorizontalBox();
			box2.add(new JLabel("密         码:"));
			box2.add(Box.createHorizontalStrut(8));
			field2 = new JPasswordField(15);
			box2.add(field2);
			
			box3= Box.createHorizontalBox();
			box3.add(new JLabel("再次输入:"));
			box3.add(Box.createHorizontalStrut(8));
			field3 = new JPasswordField(15);
			box3.add(field3);
			
			box5= Box.createHorizontalBox();
			box5.add(new JLabel("驾驶证号:"));
			box5.add(Box.createHorizontalStrut(8));
			field4 = new JTextField(15);
			box5.add(field4);
			
			box6= Box.createHorizontalBox();
			box6.add(new JLabel("手  机  号:"));
			box6.add(Box.createHorizontalStrut(8));
			field5 = new JTextField(15);
			box6.add(field5);
			
			box4= Box.createHorizontalBox();
			buttonOfZhuce = new JButton("修改");
			buttonOfZhuce.addActionListener(this);
			buttonOfFanhui = new JButton("返回");
			buttonOfFanhui.addActionListener(this);
			box4.add(buttonOfZhuce);
			box4.add(box4.createHorizontalStrut(5));
			box4.add(buttonOfFanhui);
								
			baseBox = Box.createVerticalBox();
			baseBox.add(Box.createVerticalStrut(50));
			baseBox.add(box1);
			baseBox.add(Box.createVerticalStrut(10));
			baseBox.add(box2);
			baseBox.add(Box.createVerticalStrut(10));
			baseBox.add(box3);
			baseBox.add(Box.createVerticalStrut(10));
			baseBox.add(box5);
			baseBox.add(Box.createVerticalStrut(10));
			baseBox.add(box6);
			baseBox.add(Box.createVerticalStrut(20));
			baseBox.add(box4);
			
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
				stmt = con.createStatement();
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
		
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();			
			if(source == buttonOfZhuce)
			{
			 if (field1.getText().equals("")||field4.getText().equals("")||field5.getText().equals("")
					 ||String.valueOf(field2.getPassword()).equals("")||String.valueOf(field3.getPassword()).equals("")
				 )
				{
					JOptionPane.showMessageDialog(null, "请填写完整！");
				}				
					else 
						{
							if(String.valueOf(field2.getPassword()).equals(String.valueOf(field3.getPassword())))
							{
								String str ="update user set username='"+field1.getText()+"', user_password='"+String.valueOf(field2.getPassword())+
										"',user_cardid='"+field4.getText()+"',user_phone='"+field5.getText()+"';";
								try {
									stmt.executeUpdate(str);
									rs.close();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "修改成功！");
								this.dispose();
							}
							else {
								JOptionPane.showMessageDialog(null,"两次输入的密码不匹配!" );
							}
						}
					}																																			 												
			else if(source == buttonOfFanhui)
			{
				this.dispose();				
			}						
		}
	
	}
