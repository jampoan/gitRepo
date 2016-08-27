package cn.com.zpbupt.threads;
/*
 * @author  zpbupt
 * 定义和启动线程的方法：
 * 1、创建Thread实例，再提供一个可运行的对象给Thread实例；
 * 2、子类线程 的 方式，  构建一个Thread子类，并且该子类实现一个Runnable方法。
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
