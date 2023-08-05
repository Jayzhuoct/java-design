package controller;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import service.AdminService;
import service.UserService;
import vo.Stores;
import vo.User;
@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{

	JTextField zhanghao_field;
	JPasswordField mima_field;
	JRadioButton yonghu_radioButton,guanliyuan_radioButton;
	JButton login_button,zhuce_button;
	Box box1,box2,box3,box4,basebBox;//账号，密码，两个radiobutton，两个按钮都是用行式盒子布局。 basebox用列式把他们包裹起来。
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	public Login()
	{
		setLayout(new FlowLayout());
		init();
		setVisible(true);
		setBounds(500, 200, 500, 500);
		setTitle("登陆界面");
	}
	
	void init(){		
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("账号:"));
		box1.add(Box.createHorizontalStrut(8));
		zhanghao_field = new JTextField(15);
		box1.add(zhanghao_field);//登陆界面 账号和输入框的一行
		
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("密码:"));
		box2.add(Box.createHorizontalStrut(8));
		mima_field = new JPasswordField(15);
		box2.add(mima_field);//登陆界面密码和输入框的一行
		
		box3 = Box.createHorizontalBox();
		ButtonGroup group = new ButtonGroup();
		yonghu_radioButton = new JRadioButton("用户");
		group.add(yonghu_radioButton);
		yonghu_radioButton.addActionListener(this);
		box3.add(yonghu_radioButton);
		box3.add(Box.createHorizontalStrut(8));
		guanliyuan_radioButton = new JRadioButton("管理员");
		group.add(guanliyuan_radioButton);
		guanliyuan_radioButton.addActionListener(this);
		box3.add(guanliyuan_radioButton);//登陆界面 单选框
		
		
		box4 = Box.createHorizontalBox();
		login_button = new JButton("登陆");
		login_button.addActionListener(this);
		box4.add(login_button);
		box4.add(Box.createHorizontalStrut(8));
		zhuce_button = new JButton("注册");
		zhuce_button.addActionListener(this);
		box4.add(zhuce_button);//登陆界面两个按钮
		
		
		basebBox = Box.createVerticalBox();
		basebBox.add(Box.createVerticalStrut(50));
		basebBox.add(box1);
		basebBox.add(Box.createVerticalStrut(10));
		basebBox.add(box2);
		basebBox.add(Box.createVerticalStrut(30));
		basebBox.add(box3);
		basebBox.add(Box.createVerticalStrut(80));
		basebBox.add(box4);//把4个盒子放一个大盒子		
		add(basebBox);	
		}		

	public void actionPerformed (ActionEvent e) {
		Object source = e.getSource();
		if (source == login_button) {
			if(!yonghu_radioButton.isSelected()&&!guanliyuan_radioButton.isSelected())//radiobutton没选择
			{
				JOptionPane.showMessageDialog(null, "请选择身份！");
			}else if (zhanghao_field.getText().equals("") || mima_field.toString().equals("")) {
				JOptionPane.showMessageDialog(null, "登录名和密码不能为空！");
			}else {
				if (guanliyuan_radioButton.isSelected()) {
					vo.Stores admin = new Stores();
					  admin.setAdminname(zhanghao_field.getText());
					  AdminService adminService = new AdminService();
					  adminService.showStores(admin);
					  if (adminService.showStores(admin).getAdminname().equals(zhanghao_field.getText())) {
						if (adminService.showStores(admin).getAdmin_password().equals(String.valueOf(mima_field.getPassword()))) {
							 new AdminUI(false);
						}else {
							JOptionPane.showMessageDialog(null, "密码错误！");
							mima_field.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "此账号没有管理员权限！");
						zhanghao_field.setText("");
						mima_field.setText("");
					}
				}else {
					UserService userService = new UserService();				  
					vo.User user = new User();
					user.setUsername(zhanghao_field.getText());
					userService.showUser(user);
					if (userService.showUser(user).getUsername().equals(zhanghao_field.getText())) {
						if (userService.showUser(user).getUser_password().equals(String.valueOf(mima_field.getPassword()))) {
							new UserUI(zhanghao_field.getText());
						}else {
							JOptionPane.showMessageDialog(null, "密码错误！");
							mima_field.setText("");
						}
					}else {
						JOptionPane.showMessageDialog(null, "不存在此账号，请注册！");
						zhanghao_field.setText("");
						mima_field.setText("");
					}
				}
			}
			
	}//if (source == login_button)
    else if(source == zhuce_button){
		new Enrol();
	}
	}//action
}	