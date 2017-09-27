package arenzhenjava;

public class Q {
	public static String str( ){
		String a="郭念字";
		String b="的学号";
		String c="是";
		String d=a.concat(b);//字符串的拼接
		String sum=d.concat(c);
     return sum;
	}
	public static int str1( ){
		int a =20142806;
		int b=1;
		int sum=a+b;
		String c="af";
		return sum; //返回值必须是方法定义的返回值
		            //int类型的方法只能返回int，return c；就不对了
	}
	public static void main(String[] args) {
		str();
		str1();
		System.out.println(str()+str1());
	}
}

