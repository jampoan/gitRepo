package com.edu.zpbupt.JampCharClient;

public class LoginCheck {//���õ�¼����
	private String name ;//�û���
	private String password ;//����
	//���췽��
	public LoginCheck(String name,String password){
		this.name = name ;//�����û���
		this.password = password ;//��������
	}
	//��֤�û���������
	public boolean validate(){//��֤����
		if("y".equals(name)&&"1".equals(password)){  //�ж��û����������Ƿ���ȷ
			return true ;//����true
		}else{
			return false ;//����false
		}
	}

}
