package cn.com.zpbupt.synchronizeds;
/*
 * 该类是用于定义一个不可变对象  （一种策略） ；也即是，将上一个Syncronized类改成了
 * */
final public class ImmutableRGB {
	final private int red;
	final private int green;
	final private int blue;
	final private String name;
	
	private void check(int red, int green, int blue ){
		if(red < 0 || red > 255
				|| green < 0 || green > 255
				|| blue < 0 || blue > 255) {
			throw new IllegalArgumentException();
		}
	}
	
	public ImmutableRGB(int red, int green, int blue, String name) {
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}
	
	public  int getRGB() {
		return((red << 16) | (green << 8) | blue);
	}
	
	public  String getName() {
		return name;
	}
	
	public  ImmutableRGB invert() {  //设置的值得时候，新建一个新的对象，而不是修改已有的这样可以
		return new ImmutableRGB ( 255 - red,
				255 - green,
				255 - blue,
				"Inverse of" + name);
	}

}
