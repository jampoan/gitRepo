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
	protected JLabel lab10;//ȫ�����,�����ݵ�һ�����   
	String s="�ٺ�~~���ӳɹ�~~~";//��ʼ�ַ���,���������촰�����ӳɹ�ʱ���,ͬʱ��Ϊ�������ڴ����ַ���һ������
	
	//���췽��  
	public MyClient(){		
		JFrame frame=new JFrame("�û��˴���");  //���ô���
		frame.setLayout(null);    //�ò��ֹ�����Ϊ�� ,ʹ�þ��Զ�λ
		Font fnt=new Font("Serief",Font.PLAIN,40);//��������
		Font fnt1=new Font("Serief",Font.PLAIN,20);//��������
		
		//�ҵ��û�����ʾ
		JLabel lab1=new JLabel("��������:",JLabel.LEFT);   //��ǩʵ����,�ı������
		lab1.setBounds(8, 10, 100, 20);  //�������λ�ü���С
		frame.add(lab1);     //������
		JTextField text2=new JTextField(30); //�����ı��������
		text2.setBounds(150, 10, 200, 20);//�������λ�ü���С
		text2.setEnabled(false);//�ı������ɱ༭
		text2.setText("�ɿ�������");//��������
		text2.setFont(fnt1);//��������
		frame.add(text2);//������
		
		//������IP��ʾ
		JLabel lab2=new JLabel("��ǰ������IP:",JLabel.LEFT);  //��ǩʵ����,�ı������
		lab2.setBounds(8, 45, 100, 20);//�������λ�ü���С
		frame.add(lab2);//������
		JTextField text3=new JTextField(30);//�����ı��������
		text3.setBounds(150, 45, 200, 20);//�������λ�ü���С
		text3.setEnabled(false);   //�ı����ɱ༭
		text3.setText("127.0.0.1");//��������
		text3.setFont(fnt1);//��������
		frame.add(text3);  //������
		
		//�������˿���ʾ
		JLabel lab3=new JLabel("��ǰ�������˿�:",JLabel.LEFT);  //��ǩʵ����,�ı������
		lab3.setBounds(8, 80, 100, 20);//�������λ�ü���С
		frame.add(lab3);//������
		JTextField text4=new JTextField(30);//�����ı��������
		text4.setBounds(150, 80, 200, 20);//�������λ�ü���С
		text4.setEnabled(false);//�ı����ɱ༭
		text4.setText("8888");//��������
		text4.setFont(fnt1);//��������
		frame.add(text4);//������
		
		//�����¼��ʾ
		JLabel lab4=new JLabel("�����¼����:",JLabel.LEFT);  //��ǩʵ����,�ı������
		lab4.setBounds(8, 115, 100, 20);//�������λ�ü���С
		frame.add(lab4);//������
		final JTextArea text1=new JTextArea();//�����ı��������
		text1.setEnabled(false);//�ı����ɱ༭
		text1.setLineWrap(true);//�Զ�����		
		JScrollPane scr=new JScrollPane(text1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  //���ù�����,ˮƽ�ʹ�ֱ������ʼ����ʾ
		scr.setBounds(8, 150, 450, 350);//�������λ�ü���С
		frame.add(scr);//������
		
		//�������봰�ڼ�ȷ��
		JLabel lab5=new JLabel("��������������:",JLabel.LEFT);  //��ǩʵ����,�ı������
		lab5.setBounds(8, 500, 100, 20);//�������λ�ü���С
		frame.add(lab5);//������
		final JTextArea text5=new JTextArea();//�����ı��������
		text5.setLineWrap(true);//�Զ�����
		JScrollPane scr2=new JScrollPane(text5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//���ù�����,ˮƽ�ʹ�ֱ������ʼ����ʾ
		scr2.setBounds(150, 500, 300, 50);//�������λ�ü���С
		frame.add(scr2);//������
	    final JButton but=new JButton("ȷ��");//����ȷ����ť
		but.setFont(fnt);//�����������	
		but.setBounds(480, 500, 200, 50);//�������λ�ü���С
		but.addActionListener(new ActionListener(){ //�����ڲ�������
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==but){ //�жϴ�����Դ�Ƿ����ύ��ť	
					text1.append("�ɿ�: "+lab10.getText()+"\n  ");//�������¼������ı�
					text1.append(text5.getText()+"\n");//�������������������������¼��   
		  		    s=text5.getText();	  //�õ���������
		  		    text5.setText("");     // �����촰����������Ϊ�� 
				}
			}
		}) ;
		frame.add(but);//������	

		//��ǰʱ����ʾ
		JLabel lab7=new JLabel("ʱ����ʾ:",JLabel.LEFT);//��ǩʵ����,�ı������
		lab7.setBounds(450, 20, 100, 20);//�������λ�ü���С
		frame.add(lab7);//������				
		DateFormat df=DateFormat.getDateTimeInstance();//ȡ��ϵͳʱ��
		String df2= df.format(new Date());				//��ʱ��ת�����ַ���	
		JLabel lab8=new JLabel(df2,JLabel.LEFT);//��ǩʵ����,�ı������
		lab8.setBounds(520, 20, 130, 20);//�������λ�ü���С
		frame.add(lab8);//������
		lab10=lab8; //����ʱ����ʾ,�Ա����������¼����ʾ��¼ʱ��
		new Time(lab8);  //ʹʱ�䶯̬��ʾ	
		
		//�û��б���ʾ	
		JLabel lab6=new JLabel("�û��б�:",JLabel.LEFT);//��ǩʵ����,�ı������
		lab6.setBounds(500, 40, 100, 20);//�������λ�ü���С
		frame.add(lab6);//������
		JTextArea text6=new JTextArea();//��ǩʵ����,�ı������
		text6.setEnabled(false);//�ı����ɱ༭		
		text6.setLineWrap(true);//�Զ�����
		JScrollPane scr3=new JScrollPane(text6,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//���ù�����,ˮƽ�ʹ�ֱ������ʼ����ʾ
		scr3.setBounds(460, 70, 220, 420);//�������λ�ü���С
		frame.add(scr3);//������				

		//���ڵ�����
		frame.setSize(700,600);//���ڴ�С
		frame.getContentPane().setBackground(Color.pink);//���ڵı�����ɫ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���ʱ�رճ���
		frame.setLocation(10,10);//�ڵ��������ϳ��ֵ�λ��
		frame.setVisible(true);//��ʾ����	
		try{  //try�쳣����
	        Socket socket=new Socket("127.0.0.1",8889);    //������������
		    //�������ӣ�ͨ��Socket��������ϵ�����/�����
		    PrintWriter out =new PrintWriter(socket.getOutputStream());
	        BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
		    //�ӱ�׼�����ж�ȡһ�У�����Server�ˣ����û�����byeʱ��������
		    do{  
		    	    while(s.equals("")||s.equals(null)){//�����ݵ��ַ���Ϊ��ʱ�ȴ��û�������������        		    		  
		    	    }		    	  
		  		    if(!s.equals("")&&!s.equals(null)){//s��Ϊ��ʱ��		  		    
		            out.println(s);	 //��������������ַ���       	            
		            s="";		     //�������촰���еõ����ַ�����Ϊ��          		           		           
		  		    }		  		    			  		    		           		  	  		  	    				  	   		  	    		           
		            out.flush();//�����������			   
		            if(!s.equals("bye")){ //�ж������Ƿ����				           
                         String s3;  //�õ��������ڴ������ַ���
                         while( (s3=in.readLine()).equals("\n")&&s3.equals(null)&&s3.equals("")){//�ж�s3�Ƿ�Ϊ��   ,Ϊ��ʱ�ȴ�        	
                         }
                         text6.setText("ЦЦ����"); //�����ӳɹ������û��б��� ����û�����		            		           
		                 if(!s3.equals("\n")&&!s3.equals(null)&&!s3.equals("")){//s3��Ϊ��ʱ��
				    	    text1.append("ЦЦ: "+lab10.getText()+"\n  ");//�������¼������ı�
		                    text1.append(s3+"\n");      //�������������������������¼��    
		                 }
		            }
		            

		      }while(!s.equals("bye"));//�ж��Ƿ����
		      //�ر�����
		      out.close();
		      in.close();
		      socket.close();
		    }catch(Exception e){		  
		    }		     			
	}
	
	//main����
	public static void main(String args[]){
		new Login();//��¼ʵ��	
	}


}
