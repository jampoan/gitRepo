package cn.com.zpbupt.threads;
/*
 * @author  zpbupt
 * ����������̵߳ķ�����
 * 1������Threadʵ�������ṩһ�������еĶ����Threadʵ����
 * 2�������߳� �� ��ʽ��  ����һ��Thread���࣬���Ҹ�����ʵ��һ��Runnable������
 * */

/*public class HelloRunnable implements Runnable{
	
	public void run() {
		System.out.println(" Hello out from a thread ...");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		(new Thread(new HelloRunnable())).start();

	}

}*/

public class HelloRunnable extends Thread {
	
	public void run() {
		System.out.println(" Hello out from a thread SubClass ...");
	}
	
	public static void main(String[] args) {
		(new HelloRunnable()).start();
	}
}
