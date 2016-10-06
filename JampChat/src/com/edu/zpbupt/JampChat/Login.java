package com.edu.zpbupt.JampChat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {//登录类名
	boolean f=false;//按登录时设置的一个标志	
	private JFrame frame = new JFrame("Welcome To MLDN") ; //设置窗体
	private JButton submit = new JButton("登陆");//设置登录按钮
	private JButton reset = new JButton("重置");//设置重置按钮
	private JLabel nameLab = new JLabel("服务器：") ;//标签实例化
	private JLabel passLab = new JLabel("密   码：") ;//标签实例化
	private JLabel infoLab = new JLabel("服务器登陆系统") ;//标签实例化
	private JTextField nameText = new JTextField(10) ;//单行文本输入条
	private JPasswordField passText = new JPasswordField() ;//单行密码文本输入条	
	public Login(){//登录窗口构造方法
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,12) ;//设置字体
		infoLab.setFont(fnt) ;	// 设置标签的显示文字
		submit.addActionListener(new ActionListener(){  //采用内部匿名类
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==submit){   //判断触发器源是否是提交按钮
					String tname = nameText.getText() ; //得到输入的用户名
					String tpass = new String(passText.getPassword()) ;//得到输入的密码,此时通过getPassageword()方法返回的是字符数组
					LoginCheck log = new LoginCheck(tname,tpass) ;//实例化LoginCheck对象,传入输入的用户名和密码
					if(log.validate()){//对用户名和密码进行验证
						try{            //线程异常处理try
							Thread.sleep(2000);  //2秒后打开聊天窗口
						    f=true;                 //登录成功后的表示项为true
							frame.dispose();    //关闭本窗口
						}catch(Exception ee){//异常获取			
						}
					}else{
						infoLab.setText("登陆失败，错误的用户名或密码！") ;//登录失败
					}
				}
			}
		}) ;
		reset.addActionListener(new ActionListener(){ //采用内部匿名类
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==reset){ //判断触发器源是否是提交按钮
					nameText.setText("") ;//设置文本框中的内容
					passText.setText("") ;//设置文本框中的内容
					infoLab.setText("服务器登陆系统") ;//恢复标签显示
				}
			}
		}) ;	
		frame.addWindowListener(new WindowAdapter(){//加入窗口监听
			public void windowClosing(WindowEvent e){
			}
		}) ;	// 加入事件
		frame.setLayout(null) ;//使用绝对定位
		nameLab.setBounds(5,5,60,20) ;//设置标签的位置及大小
		passLab.setBounds(5,30,60,20) ;//设置标签的位置及大小
		infoLab.setBounds(5,65,220,30) ;//设置标签的位置及大小
		nameText.setBounds(65,5,100,20) ;//设置文本域的位置及大小
		passText.setBounds(65,30,100,20) ;//设置密码域的位置及大小
		submit.setBounds(165,5,60,20) ;//设置按钮的位置及大小
		reset.setBounds(165,30,60,20) ;//设置按钮的位置及大小
		frame.add(nameLab) ;//向窗体加入标签
		frame.add(passLab) ;//向窗体加入标签
		frame.add(infoLab) ;//向窗体加入标签
		frame.add(nameText) ;//向窗体加入文本框
		frame.add(passText) ;//向窗体加入密码框
		frame.add(submit) ;//向窗体加入按钮
		frame.add(reset) ;//向窗体加入按钮
		frame.setSize(280,130) ;//设置窗体大小
		frame.getContentPane().setBackground(Color.green) ;//设置窗体的背景颜色
		frame.setLocation(300,200) ;//设置窗体在电脑桌面上的位置
		frame.setVisible(true) ;//显示窗口
		while(f==false){  //当登录失败时,一直循环运行,			
		}
		new MyServer();//显示窗体页面
	}	


}
