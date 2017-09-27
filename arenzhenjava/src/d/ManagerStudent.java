package d;
import java.util.Scanner;
//方法重构
public class ManagerStudent {
	Student[] stus; //Student[] stus=null;
	Scanner sc = new Scanner(System.in);
	int index;
	public void inPutStudent() {
		System.out.println("请录入学生数量(注意只能是数字)");
		int length = sc.nextInt();
		if(stus==null){// if{}代码行的功能是能能够存储刚开始输入的数据，
			stus = new Student[length];//第一次循环只执行这一步直接跳到下次for循环实现
		}
		else{
			//新建立一个数组，扩容，并转换。
			Student[] temps=new Student[stus.length+length];
//			把原数组的数据赋值给新数组
			for(int i=0;i<stus.length;i++){
				temps[i]=stus[i];//这是最巧妙的一般
			}
			stus=temps;	//记录数据并扩容	
		}
		for (int i = 0; i <length; i++) {
			System.out.println("请输入学生姓名第" + (index + 1) + "个学生的名字");
			String name = sc.next();
			System.out.println("请输入学生姓名第" + (index + 1) + "个学生的性别");
			String sex = sc.next();
			System.out.println("请输入学生姓名第" + (index + 1) + "个学生的年龄");
			int age = sc.nextInt();
			// 开始创建对象与Student类联立
			Student stu = new Student();
			stu.setName(name);
			stu.setSex(sex);
			stu.setAge(age);
			stus[index] = stu;// 放入数组里面
			index++;
		}
	}

	public void showStudent(){
		if(stus!=null){
		for(int i=0;i<stus.length;i++){
			System.out.println(" 姓名："+stus[i].getName()+" 性别："
					+ ""+stus[i].getSex()+" 年龄："+stus[i].getAge());
		}
		}
		else{
			System.out.println("没有学生数据");
	}
	}
	public void searchStudent() {
		if(stus!=null){
		for (int j = 0; ; j++) {// 死循环让其可以一直查找
			System.out.println("请输入要查找的条件   1 姓名  2 性别  3 年龄");
			int type = sc.nextInt();
			if (type == 1) {
				searchByName();
			} else if (type == 2) {
				searchBySex();
			} else if (type == 3) {
				searchByAge();
			} else {
				System.out.println("请输入1-3的数字");
			}
		}
		}
		else{
			System.out.println("没有学生数据");
		}

	}
	public void searchByName() {
		System.out.println("请输入要查找学生的姓名");
		String name = sc.next();
		boolean flag = true;
		for (int i = 0; i < stus.length; i++) {// 这个for循环用来查看是否有相同的
			if (stus[i].getName().equals(name)) {
				flag = false;
				System.out.println(" 姓名：" + stus[i].getName() + " 性别：" + ""
						+ stus[i].getSex() + " 年龄：" + stus[i].getAge());
			}
			break;
		}
		if (flag == true) {
			System.out.println("查无此人");
		}
		}
	public void searchBySex() {
		System.out.println("请输入要查找学生的性别");
		String sex = sc.next();
		boolean flag = true;
		for (int i = 0; i < stus.length; i++) {// 这个for循环用来查看是否有相同的
			if (stus[i].getSex().equals(sex)) {
				flag = false;
				System.out.println(" 姓名：" + stus[i].getName() + " 性别：" + ""
						+ stus[i].getSex() + " 年龄：" + stus[i].getAge());
			}
			break;
		}
		if (flag == true) {
			System.out.println("查无此人");
		}

	}
	public void searchByAge() {
		System.out.println("请输入要查找学生的年龄");
		int age = sc.nextInt();
		boolean flag = true;
		for (int i = 0; i < stus.length; i++) {// 这个for循环用来查看是否有相同的
			if (stus[i].getAge() == age) {
				flag = false;
				System.out.println(" 姓名：" + stus[i].getName() + " 性别：" + ""
						+ stus[i].getSex() + " 年龄：" + stus[i].getAge());
			}
			break;
		}
		if (flag == true) {
			System.out.println("查无此人");
		}
	}
//	public void xunhuan(){
//		System.out.println("欢迎来到学生管理系统！");
//		for(int j=0;;j++){
//			System.out.println("1 录入 2 展示 3 查询 ");
//			int type=sc.nextInt();
//		if(type==1){
////			
//			for(int i=0;i<1;i++){
//				inPutStudent();
////				
//				continue;
//				}
//			
//			}
//		if(type==2){
//			boolean flag=true;
//			for(int i=0;i<2;i++){
//				if(i==0){
//					System.out.println("请您先输入学生数据!");
//					flag=false;
//					continue;	
//				}
//				if(flag){
//					showStudent();
//				}
//			}
//			}	
//		else if(type==3){
//			boolean flag=true;
//			for(int i=0;i<2;i++){
//				if(i==0){
//					System.out.println("请您先输入学生数据");
//					flag=false;
//					continue;
//				}
//				if(flag){
//				searchStudent();
//				}
//			}
//		}	
//	}
//	}
	public static void main(String[] args) {
		// 门面模式
		ManagerStudent ms=new ManagerStudent();
		while(true){
			System.out.println("1录入  2展示  3查询  0退出");
	    int type=ms.sc.nextInt();
	    if(type==0){
	    	break;
	    }
	    else if(type==1){
	    	 ms.inPutStudent();
	    }
	    else if(type==2){
	    	 ms.showStudent();
	    }
	    else if(type==3){
	    	 ms.searchStudent();
	    }
		}
	    
	   
	   
	}
}

