package cn.com.zpbupt.threads;

/*
 * @author:  zpbupt
 * @time: created at 2016/08/28 11:46
 * @description: just a test for the parameter of main function
 * 
 * @result: ���յĽ��˵����main������ʵ����һ�����飬Ԫ�صĸ���������0.
 * */

public class TestForMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args == null) {
			System.out.println("null");
		}
		else if (args.length == 0) {
			System.out.println(" the length = 0");
		}

	}

}
