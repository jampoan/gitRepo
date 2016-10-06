package com.edu.zpbupt.JampChat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyClient {
	protected JLabel lab10;//全体变量,做传递的一个组件   
	String s="嘿嘿~~连接成功~~~";//初始字符串,在两个聊天窗口链接成功时输出,同时作为两个窗口传递字符的一个变量
	
	//构造方法  
	public MyClient(){		
		JFrame frame=new JFrame("用户端窗口");  //设置窗体
		frame.setLayout(null);    //让布局管理器为空 ,使用绝对定位
		Font fnt=new Font("Serief",Font.PLAIN,40);//字体设置
		Font fnt1=new Font("Serief",Font.PLAIN,20);//字体设置
		
		//我的用户名显示
		JLabel lab1=new JLabel("服务器名:",JLabel.LEFT);   //标签实例化,文本左对齐
		lab1.setBounds(8, 10, 100, 20);  //设置组件位置及大小
		frame.add(lab1);     //添加组件
		JTextField text2=new JTextField(30); //单行文本输入组件
		text2.setBounds(150, 10, 200, 20);//设置组件位置及大小
		text2.setEnabled(false);//文本条不可编辑
		text2.setText("可可聊天室");//输入内容
		text2.setFont(fnt1);//设置字体
		frame.add(text2);//添加组件
		
		//服务器IP显示
		JLabel lab2=new JLabel("当前服务器IP:",JLabel.LEFT);  //标签实例化,文本左对齐
		lab2.setBounds(8, 45, 100, 20);//设置组件位置及大小
		frame.add(lab2);//添加组件
		JTextField text3=new JTextField(30);//单行文本输入组件
		text3.setBounds(150, 45, 200, 20);//设置组件位置及大小
		text3.setEnabled(false);   //文本不可编辑
		text3.setText("127.0.0.1");//输入内容
		text3.setFont(fnt1);//设置字体
		frame.add(text3);  //添加组件
		
		//服务器端口显示
		JLabel lab3=new JLabel("当前服务器端口:",JLabel.LEFT);  //标签实例化,文本左对齐
		lab3.setBounds(8, 80, 100, 20);//设置组件位置及大小
		frame.add(lab3);//添加组件
		JTextField text4=new JTextField(30);//单行文本输入组件
		text4.setBounds(150, 80, 200, 20);//设置组件位置及大小
		text4.setEnabled(false);//文本不可编辑
		text4.setText("8888");//输入内容
		text4.setFont(fnt1);//设置字体
		frame.add(text4);//添加组件
		
		//聊天记录显示
		JLabel lab4=new JLabel("聊天记录如下:",JLabel.LEFT);  //标签实例化,文本左对齐
		lab4.setBounds(8, 115, 100, 20);//设置组件位置及大小
		frame.add(lab4);//添加组件
		final JTextArea text1=new JTextArea();//多行文本输入组件
		text1.setEnabled(false);//文本不可编辑
		text1.setLineWrap(true);//自动换行		
		JScrollPane scr=new JScrollPane(text1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  //设置滚动条,水平和垂直滚动条始终显示
		scr.setBounds(8, 150, 450, 350);//设置组件位置及大小
		frame.add(scr);//添加组件
		
		//聊天输入窗口及确定
		JLabel lab5=new JLabel("请输入聊天内容:",JLabel.LEFT);  //标签实例化,文本左对齐
		lab5.setBounds(8, 500, 100, 20);//设置组件位置及大小
		frame.add(lab5);//添加组件
		final JTextArea text5=new JTextArea();//多行文本输入组件
		text5.setLineWrap(true);//自动换行
		JScrollPane scr2=new JScrollPane(text5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//设置滚动条,水平和垂直滚动条始终显示
		scr2.setBounds(150, 500, 300, 50);//设置组件位置及大小
		frame.add(scr2);//添加组件
	    final JButton but=new JButton("确定");//设置确定按钮
		but.setFont(fnt);//添加字体设置	
		but.setBounds(480, 500, 200, 50);//设置组件位置及大小
		but.addActionListener(new ActionListener(){ //采用内部匿名类
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==but){ //判断触发器源是否是提交按钮	
					text1.append("可可: "+lab10.getText()+"\n  ");//在聊天记录上添加文本
					text1.append(text5.getText()+"\n");//将输入的聊天内容输出在聊天记录上   
		  		    s=text5.getText();	  //得到聊天内容
		  		    text5.setText("");     // 将聊天窗口内容设置为空 
				}
			}
		}) ;
		frame.add(but);//添加组件	

		//当前时间显示
		JLabel lab7=new JLabel("时间显示:",JLabel.LEFT);//标签实例化,文本左对齐
		lab7.setBounds(450, 20, 100, 20);//设置组件位置及大小
		frame.add(lab7);//添加组件				
		DateFormat df=DateFormat.getDateTimeInstance();//取得系统时间
		String df2= df.format(new Date());				//将时间转换成字符串	
		JLabel lab8=new JLabel(df2,JLabel.LEFT);//标签实例化,文本左对齐
		lab8.setBounds(520, 20, 130, 20);//设置组件位置及大小
		frame.add(lab8);//添加组件
		lab10=lab8; //传递时间显示,以便能在聊天记录上显示记录时间
		new Time(lab8);  //使时间动态显示	
		
		//用户列表显示	
		JLabel lab6=new JLabel("用户列表:",JLabel.LEFT);//标签实例化,文本左对齐
		lab6.setBounds(500, 40, 100, 20);//设置组件位置及大小
		frame.add(lab6);//添加组件
		JTextArea text6=new JTextArea();//标签实例化,文本左对齐
		text6.setEnabled(false);//文本不可编辑		
		text6.setLineWrap(true);//自动换行
		JScrollPane scr3=new JScrollPane(text6,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//设置滚动条,水平和垂直滚动条始终显示
		scr3.setBounds(460, 70, 220, 420);//设置组件位置及大小
		frame.add(scr3);//添加组件				

		//窗口的属性
		frame.setSize(700,600);//窗口大小
		frame.getContentPane().setBackground(Color.pink);//窗口的背景颜色
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时关闭程序
		frame.setLocation(10,10);//在电脑桌面上出现的位置
		frame.setVisible(true);//显示窗口	
		try{  //try异常处理
	        Socket socket=new Socket("127.0.0.1",8889);    //发出连接请求
		    //建立连接，通过Socket获得连接上的输入/输出流
		    PrintWriter out =new PrintWriter(socket.getOutputStream());
	        BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
		    //从标准输入中读取一行，发送Server端，当用户输入bye时结束连接
		    do{  
		    	    while(s.equals("")||s.equals(null)){//当传递的字符串为空时等待用户输入聊天内容        		    		  
		    	    }		    	  
		  		    if(!s.equals("")&&!s.equals(null)){//s不为空时做		  		    
		            out.println(s);	 //向其他窗口输出字符串       	            
		            s="";		     //将在聊天窗口中得到的字符串设为空          		           		           
		  		    }		  		    			  		    		           		  	  		  	    				  	   		  	    		           
		            out.flush();//输出聊天内容			   
		            if(!s.equals("bye")){ //判断聊天是否结束				           
                         String s3;  //得到其他窗口传来的字符串
                         while( (s3=in.readLine()).equals("\n")&&s3.equals(null)&&s3.equals("")){//判断s3是否为空   ,为空时等待        	
                         }
                         text6.setText("笑笑在线"); //当连接成功是在用户列表中 输出用户名字		            		           
		                 if(!s3.equals("\n")&&!s3.equals(null)&&!s3.equals("")){//s3不为空时做
				    	    text1.append("笑笑: "+lab10.getText()+"\n  ");//在聊天记录上添加文本
		                    text1.append(s3+"\n");      //将输入的聊天内容输出在聊天记录上    
		                 }
		            }
		            

		      }while(!s.equals("bye"));//判断是否结束
		      //关闭连接
		      out.close();
		      in.close();
		      socket.close();
		    }catch(Exception e){		  
		    }		     			
	}
	
	//main函数
	public static void main(String args[]){
		new Login();//登录实现	
	}


}
