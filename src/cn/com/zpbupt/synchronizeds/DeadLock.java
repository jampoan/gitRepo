package cn.com.zpbupt.synchronizeds;

public class DeadLock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
			
		}
		
		public String getName() {
			return this.name;
		}
		
		public synchronized void bow(Friend bower) {
			System.out.format("%s : %s" + " has boe back to me \n",this.name, bower.getName() );
			bower.bowBack(this); 
		}
		
		public synchronized void bowBack(Friend bower) {】、
			System.out.format("%s : %s" + " bowed back...", this.name, bower.getName() );
		}
	}
	
	public static void main(String[] args) {
		final Friend alp = new Friend( "alp" );
		final Friend bbb = new Friend( "BBb" );
		
		new Thread(new Runnable() {
			public void run() {
				alp.bow(bbb);
			}
		} ).start(); /*这个线程建立有点意思，看清过程：使用的是更为常用的方法：建立一个线程实例，同时将一个可运行的对象传给Thread的构造函数*/
		
		new Thread(new Runnable() {
			public void run() {
				bbb.bow(alp);
			}
		} ).start();
	}

}
