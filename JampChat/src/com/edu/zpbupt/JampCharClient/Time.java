package com.edu.zpbupt.JampCharClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;


public class Time {
	public Time(JLabel time){//���췽��
		this.setTimer(time);//����ʱ��
	}
	public void setTimer(JLabel time){    //����ʱ�䷽��
        final JLabel varTime = time;      //�������
        Timer timeAction = new Timer(1000, new ActionListener() {   //ʱ�����              
            public void actionPerformed(ActionEvent e) {       
                long timemillis = System.currentTimeMillis();    //�õ�ϵͳʱ��                     
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //ת��������ʾ��ʽ   
                varTime.setText(df.format(new Date(timemillis)));   //����õ���ʱ��
            }      
        });            
        timeAction.start();         //�����߳�   
    }


}
