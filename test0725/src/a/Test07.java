package a;

public class Test07 {
public static void main(String[] args) {
	int year=2016;//闰年的条件：1、能被4整除且不能被100整2、能被400整除
	if(year%4==0&&year%100!=0||year%400==0){
		System.out.println(year+"是闰年");
	}else{
		System.out.println(year+"是平年");
	}
}
}
