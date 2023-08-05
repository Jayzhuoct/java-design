package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * 管理员修改车辆的详细信息
 */
@SuppressWarnings("serial")
public class InfoEdit extends JFrame implements ActionListener{
	JTextArea area;
	Box box1,baseBox,box2,baseBox2;
	JButton buttonOfTijiao,buttonOfFanHui;	
	public InfoEdit()
	{		
		init();
		setVisible(true);
		setBounds(500, 200, 620, 360);
		setTitle("详细信息编辑界面");
	}
	
	@SuppressWarnings("static-access")
	void init()
	{
		JLabel label = new JLabel("车辆的详细信息：");
		area = new JTextArea(10, 10);
		buttonOfTijiao = new JButton("提交");
		buttonOfFanHui = new JButton("返回");
		
		box1 = Box.createVerticalBox();
		box1.add(box1.createVerticalStrut(8));
		box1.add(label);
		box1.add(area);
		
		
		box2 = Box.createHorizontalBox();
		box2.add(box2.createHorizontalStrut(8));
		box2.add(buttonOfTijiao);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
