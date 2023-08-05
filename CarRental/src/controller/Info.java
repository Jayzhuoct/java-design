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


@SuppressWarnings("serial")
public class Info extends JFrame implements ActionListener{
	JTextArea area;
	Box box1,baseBox,box2,baseBox2;
	JButton buttonOfBianJi,buttonOfFanHui,buttonOfTi;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String number=null;
	int setEnable =0;
	String information;
/*	
 * ����Ա��ѯ��������ϸ��Ϣ
 */
	public Info(String number)
	{
		
		init();
		setVisible(true);
		setBounds(500, 200, 620, 360);
		setTitle("����Ա��ϸ��Ϣ����");
		this.number = number;
		setArea();
		
	}
	public  void setArea()//�򿪽���Ͱ� ���ݿ��е���ϸ��Ϣд�뵽area��
	{
		this.connDB();
		try {
			stmt = con.createStatement();
			String sql = "select * from car where carnum='"+number+"'; ";
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
				JOptionPane.showMessageDialog(null,"û�д˱�ŵĳ�������ϸ��Ϣ��");
				new AdminUI(true);
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
		JLabel label = new JLabel("��������ϸ��Ϣ��");
		area = new JTextArea(10, 10);
		buttonOfBianJi = new JButton("�༭");
		buttonOfBianJi.addActionListener(this);
		buttonOfFanHui = new JButton("����");
		buttonOfFanHui.addActionListener(this);
		buttonOfTi = new JButton("�ύ");
		buttonOfTi.addActionListener(this);
		
		box1 = Box.createVerticalBox();
		box1.add(box1.createVerticalStrut(8));
		box1.add(label);
		box1.add(area);
		
		
		box2 = Box.createHorizontalBox();
		box2.add(box2.createHorizontalStrut(8));
	    box2.add(buttonOfBianJi);
		box2.add(box2.createHorizontalStrut(8));
		box2.add(buttonOfTi);
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
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == buttonOfBianJi)
		{
			area.setEnabled(true);
			setEnable = 1;
			
		}
		else if (source == buttonOfFanHui)
		{
			this.dispose();
			new AdminUI(false);
		}
		else if(source == buttonOfTi)
		{
			if(setEnable == 1)
			{
				String areaString = area.getText();
				this.connDB();
				try 
				{
					stmt = con.createStatement();		
					String sqlString ="update car_information set information='"+areaString+"'where number = '"+number+"';";
					stmt.executeUpdate(sqlString);
				} catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "�ύ�ɹ���");
				this.closeDB();
				this.dispose();
				new AdminUI(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "�����༭�任�ɱ༭״̬��");
			}
			
		}
		
	}

}
