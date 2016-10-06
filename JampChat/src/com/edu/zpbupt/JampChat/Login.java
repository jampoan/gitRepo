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

public class Login {//��¼����
	boolean f=false;//����¼ʱ���õ�һ����־	
	private JFrame frame = new JFrame("Welcome To MLDN") ; //���ô���
	private JButton submit = new JButton("��½");//���õ�¼��ť
	private JButton reset = new JButton("����");//�������ð�ť
	private JLabel nameLab = new JLabel("��������") ;//��ǩʵ����
	private JLabel passLab = new JLabel("��   �룺") ;//��ǩʵ����
	private JLabel infoLab = new JLabel("��������½ϵͳ") ;//��ǩʵ����
	private JTextField nameText = new JTextField(10) ;//�����ı�������
	private JPasswordField passText = new JPasswordField() ;//���������ı�������	
	public Login(){//��¼���ڹ��췽��
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,12) ;//��������
		infoLab.setFont(fnt) ;	// ���ñ�ǩ����ʾ����
		submit.addActionListener(new ActionListener(){  //�����ڲ�������
		public void actionPerformed(ActionEvent e){
				if(e.getSource()==submit){   //�жϴ�����Դ�Ƿ����ύ��ť
					String tname = nameText.getText() ; //�õ�������û���
					String tpass = new String(passText.getPassword()) ;//�õ����������,��ʱͨ��getPassageword()�������ص����ַ�����
					LoginCheck log = new LoginCheck(tname,tpass) ;//ʵ����LoginCheck����,����������û���������
					if(log.validate()){//���û��������������֤
						try{            //�߳��쳣����try
							Thread.sleep(2000);  //2�������촰��
						    f=true;                 //��¼�ɹ���ı�ʾ��Ϊtrue
							frame.dispose();    //�رձ�����
						}catch(Exception ee){//�쳣��ȡ			
						}
					}else{
						infoLab.setText("��½ʧ�ܣ�������û��������룡") ;//��¼ʧ��
					}
				}
			}
		}) ;
		reset.addActionListener(new ActionListener(){ //�����ڲ�������
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==reset){ //�жϴ�����Դ�Ƿ����ύ��ť
					nameText.setText("") ;//�����ı����е�����
					passText.setText("") ;//�����ı����е�����
					infoLab.setText("��������½ϵͳ") ;//�ָ���ǩ��ʾ
				}
			}
		}) ;	
		frame.addWindowListener(new WindowAdapter(){//���봰�ڼ���
			public void windowClosing(WindowEvent e){
			}
		}) ;	// �����¼�
		frame.setLayout(null) ;//ʹ�þ��Զ�λ
		nameLab.setBounds(5,5,60,20) ;//���ñ�ǩ��λ�ü���С
		passLab.setBounds(5,30,60,20) ;//���ñ�ǩ��λ�ü���С
		infoLab.setBounds(5,65,220,30) ;//���ñ�ǩ��λ�ü���С
		nameText.setBounds(65,5,100,20) ;//�����ı����λ�ü���С
		passText.setBounds(65,30,100,20) ;//�����������λ�ü���С
		submit.setBounds(165,5,60,20) ;//���ð�ť��λ�ü���С
		reset.setBounds(165,30,60,20) ;//���ð�ť��λ�ü���С
		frame.add(nameLab) ;//��������ǩ
		frame.add(passLab) ;//��������ǩ
		frame.add(infoLab) ;//��������ǩ
		frame.add(nameText) ;//��������ı���
		frame.add(passText) ;//������������
		frame.add(submit) ;//������밴ť
		frame.add(reset) ;//������밴ť
		frame.setSize(280,130) ;//���ô����С
		frame.getContentPane().setBackground(Color.green) ;//���ô���ı�����ɫ
		frame.setLocation(300,200) ;//���ô����ڵ��������ϵ�λ��
		frame.setVisible(true) ;//��ʾ����
		while(f==false){  //����¼ʧ��ʱ,һֱѭ������,			
		}
		new MyServer();//��ʾ����ҳ��
	}	


}
