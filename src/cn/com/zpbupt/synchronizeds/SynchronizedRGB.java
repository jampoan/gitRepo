package cn.com.zpbupt.synchronizeds;

public class SynchronizedRGB {
	private int red;
	private int green;
	private int blue;
	private String name;
	
	private void check(int red, int green, int blue ){
		if(red < 0 || red > 255
				|| green < 0 || green > 255
				|| blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}
	
	public SynchronizedRGB(int red, int green, int blue, String name) {
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
	public void set(int red, int green, int blue, String name) {
		check(red, green, blue);
		synchronized (this) {   //�������ͬ��������˳��ֲ�һ�µ��������Ϊ���Գ���������ɫ��ֵ��ô����ɣ����Ѿ���ʱ���øö�����ֶ���
			this.red = red;
			this.green = green;
			this.blue = blue;
			this.name = name;
		}		
	}
	
	public synchronized int getRGB() {
		return((red << 16) | (green << 8) | blue);
	}
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized void invert() {
		red = 255 - red;
		green = 255 - green;
		blue = 255 - blue;
		name = "Inverse of" + name;
	}
	
}

/*
 * ʹ�õ������
 * ʹ��SynchronizedRGB���ʱ��Ҫע�⣬������ֲ�һ�µ������
 * 
 * ���磺
 * SynchronizedRGB color = new SynchronizedRGB (0,0,0, " pic black");
 * int myColor = color.getRGB();  //1
 * String myName = color.getName(); //2
 * 
 * ����1��2��������Ӧ�÷���һ��ͬ�����н���ִ�С���Ϊ�����1ִ����֮�󣬿��ܿ��Գ���set��������������ִ��2��ʱ�򣬶����е��ֶ�ֵ��ǰ��һ�ˡ�
 * 
 * */
