package arenzhenjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cnm {
public static void main(String[] args) {
	List list=new ArrayList();
	Scanner sc=new Scanner(System.in);
	System.out.println("������6����");
	int a=sc.nextInt();
	int m = 0;
	for(int i=0;i<6;i++){
		System.out.println("�������"+(i+1)+"����");
		 m=sc.nextInt();
	list.add(m); 
	}	
	for(int i=0;i<list.size();i++){
		System.out.print(" "+list.get(i));
	}
	
}
}
