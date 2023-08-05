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
	 * �û��˵Ľ���
	 */
	JTable table;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	Object a[][];
	Object name[] = {"���ƺ�","����","�ŵ��","�۸�","��ɫ","�Ƿ�����","��ע"};
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
		setTitle("�û�����");
		this.username = username;
	}
	
	void init()
	{
		label1 = new JLabel("����������Ϣ���ϵͳ");
		buttonOfKe = new JButton("   �� �� �� �� ��   ");
		buttonOfKe.addActionListener(this);
		
		buttonOfXinxiliulan = new JButton("   ������Ϣ���   ");
		buttonOfXinxiliulan .addActionListener(this);
		
		buttonOfQyueding = new JButton("    ȷ	            ��       ");
		buttonOfQyueding.addActionListener(this);
		
		buttonOfLogout = new JButton("   ��   ��   ��   ¼   ");
		buttonOfLogout.addActionListener(this);
		
		buttonOfXiangXi = new JButton("   ��   ϸ   ��   Ϣ   ");
		buttonOfXiangXi.addActionListener(this);
		
		buttonOfId = new JButton("   ��   ��   ��   Ϣ   ");
		buttonOfId.addActionListener(this);
		
		buttonOfWo = new JButton("   ��   ��   ��   ��   ");
		buttonOfWo.addActionListener(this);
		
		buttonOfWoke = new JButton("   ��   ��   ��   ��   ");
		buttonOfWoke.addActionListener(this);
		
		buttonOfRelet = new JButton("   ��           ��      ");
		buttonOfRelet.addActionListener(this);
		
		buttonOfReturn = new JButton("   ��           ��      ");
		buttonOfReturn.addActionListener(this);
		
		label2 = new JLabel("������Ҫ���õ�������");
		label3 = new JLabel("������Ҫ���õ�������");
		label4 = new JLabel("��ѯ��ע�ĳ��ƺ��룺");
		label5 = new JLabel("��      ��       ��     ��");
		label6 = new JLabel("��������Ҫ�����ĳ��ƺţ�");
		label7 = new JLabel("������Ҫ�����������");
		label8 = new JLabel("��  ��  ��  ��  ��  ��  �� ");
		
		field = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		field5 = new JTextField();
		field6 = new JTextField();
		field7 = new JTextField();
		
		a = new Object[50][7];
		table = new JTable(a, name);//����Ĵ���
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
		box2.add(box1);   //��ߵİ�ť������ box����
		
		jPanel4 = new JPanel();
		jPanel5 = new JPanel();
		jPanel4.setLayout(new BorderLayout());
		jPanel4.add(box2,BorderLayout.NORTH);//����ߵİ�ť���ַŵ�jpanel4�С�	
		jPanel5.setLayout(new BorderLayout());
		jPanel5.add(label1,BorderLayout.NORTH);
		jPanel5.add(scrollPane,BorderLayout.CENTER);//�ѱ�� ��jpanel5��
	
		this.setLayout(new BorderLayout());
		add(jPanel5,BorderLayout.EAST);
		add(jPanel4,BorderLayout.WEST);//���������panel�ŵ���������
				
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
		if(source == buttonOfKe)//����������ó����İ�ť
		{
			int success = 0;//�����ж���û��û�����õĳ���������ܷ��� ���� ֵ�ļ�����ֵΪ 1 
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
			 i=0;//i ��ֵΪ 0��Ϊ�����ѭ����׼��
			 this.connDB();
			 try {
				stmt = con.createStatement();
				 String sql= "select * from car where hire= '��';";//��ѯ������ û�����õĳ���
				 rs = stmt.executeQuery(sql);
				 while(rs.next())//�Ѳ�ѯ������Ϣд�� table
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
				 repaint();//ˢ��һ��
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 if(success == 0)
			 {
				 JOptionPane.showMessageDialog(null, "���Ѿ������ã�");
			 }
		}
		else if(source == buttonOfXinxiliulan)//�����Ϣ�����ť
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
		else if (source == buttonOfQyueding)//������õ�ȷ����
		{
			if(field.getText().equals(""))//�Ƿ�Ϊ��
			{
				JOptionPane.showMessageDialog(null, "���������ó����ı�ţ�");
				if(field2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "����������������");
				}
			}
			else//��Ϊ��
			{
				this.connDB();
				String sql;
				try {
					stmt = con.createStatement();
					sql = "select * from car  where carnum='"+field.getText()+"' and hire = '��'";//��ȡ�������Ų���û�����õ���Ϣ
					rs = stmt.executeQuery(sql);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					if(rs.next())//�ж��Ƿ���� �˳���
					{
						int n = JOptionPane.showConfirmDialog(this, "ȷ�����ô˳�����Ϣ��","ȷ�϶Ի���",JOptionPane.YES_NO_OPTION);
						if(n == JOptionPane.YES_OPTION)//ȷ�Ͽ�
						{	
							try
							{
								stmt = con.createStatement();
								String sql2 = "update  car set hire = '��' ,username='"+username+"'where carnum='"+field.getText()+"';";//�����õĸ�ֵΪ �� 								
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
							JOptionPane.showMessageDialog(null,"���óɹ���");
							xinXiLiuLan();							
						}
						
						else if(n == JOptionPane.NO_OPTION)
						{
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�޷����ô˳�����");
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
				JOptionPane.showMessageDialog(null, "�����복�ƺţ�");
				if(field2.getText() == "")
				{
					JOptionPane.showMessageDialog(null, "����������������");
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
				JOptionPane.showMessageDialog(null,"����ɹ���");
				}
				else {
					JOptionPane.showMessageDialog(null, "���������Ѿ����õĳ�����");
				}
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
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
					String sql1="update car set username = null ,hire = '��' where username = '"+username+"';";
					stmt.executeUpdate(sql1);
					rs.close();
					repaint();
					field5.setText("");
					JOptionPane.showMessageDialog(null, "�黹�����ɹ���");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "�������Ѿ����õĳ�����");
				}
				
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
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
		else if(source == buttonOfWo)//�������ĳ�����Ϣ
		{
			int success = 0;//�����ж���û��û�Լ����õĳ���
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
			 i=0;//i ��ֵΪ 0��Ϊ�����ѭ����׼��
			 this.connDB();
			 try {
				stmt = con.createStatement();
				 String sql= "select * from car where username= '"+username+"';";//��ѯ������ �Լ��Ѿ����õĳ���
				 rs = stmt.executeQuery(sql);
				 while(rs.next())//�Ѳ�ѯ������Ϣд�� table
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
				 repaint();//ˢ��һ��
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 if(success == 0)
			 {
				 JOptionPane.showMessageDialog(null, "����û�������κγ�����");
			 }
		}
		
		
	}

}
