package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * ����Ա�޸ĳ�������ϸ��Ϣ
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
		setTitle("��ϸ��Ϣ�༭����");
	}
	
	@SuppressWarnings("static-access")
	void init()
	{
		JLabel label = new JLabel("��������ϸ��Ϣ��");
		area = new JTextArea(10, 10);
		buttonOfTijiao = new JButton("�ύ");
		buttonOfFanHui = new JButton("����");
		
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
