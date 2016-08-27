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
		synchronized (this) {   //这里加上同步块避免了出现不一致的情况，因为可以出现设置颜色的值还么有完成，就已经来时调用该对象的字段了
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
 * 使用的情况：
 * 使用SynchronizedRGB类的时候，要注意，避免出现不一致的情况。
 * 
 * 例如：
 * SynchronizedRGB color = new SynchronizedRGB (0,0,0, " pic black");
 * int myColor = color.getRGB();  //1
 * String myName = color.getName(); //2
 * 
 * 上面1、2两个步骤应该放在一个同步块中进行执行。因为如果在1执行完之后，可能可以出现set方法，这样，在执行2的时候，对象中的字段值就前后不一了。
 * 
 * */
