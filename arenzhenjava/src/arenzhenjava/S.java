package arenzhenjava;

import java.util.ArrayList;
import java.util.List;

public class S {
public static void main(String[] args) {
	List<Integer> list=new ArrayList<Integer>();
	int length=6;
	for(int i=0;i<length;i++){
	int qiu=(int)(Math.random()*33+1);//先输出六个随机的数
	//定义一个变量qiu 用于在后面去重的时候利用boolean来判断是去掉还是留下
//		System.out.print(" "+hongs[i]);
		//去重复
		boolean flag=true;
	for( int j=0;j<i;j++){
		if(qiu==list.get(j)){
			flag=false;
			i--;
			break;
		}	
	}if(flag==true){
		list.add(qiu);
//		System.out.print(" "+list.get(i));已经输出了六个不重复的数
	}
	}
	//已经输出了六个不重复的数
	for(int i=0;i<length-1;i++){
		for(int j=0;j<length-i-1;j++){
	if(list.get(j)>list.get(j+1)){
		list.add(j, list.get(j+1));	
	}
	}	
	}
	for(int i=0;i<length;i++){
		System.out.print(" "+list.get(i));
	}
}
}
