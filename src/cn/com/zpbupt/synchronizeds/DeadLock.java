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
		
		public synchronized void bowBack(Friend bower) {����
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
		} ).start(); /*����߳̽����е���˼��������̣�ʹ�õ��Ǹ�Ϊ���õķ���������һ���߳�ʵ����ͬʱ��һ�������еĶ��󴫸�Thread�Ĺ��캯��*/
		
		new Thread(new Runnable() {
			public void run() {
				bbb.bow(alp);
			}
		} ).start();
	}

}
