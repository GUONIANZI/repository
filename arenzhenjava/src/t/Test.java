package t;

public class Test {
public static void main(String[] args) {
	Student stu=new Student("小明","男",15,"20142807");
	stu.show();
	stu.study();
	stu.eat();
	Teacher tea=new Teacher("赵老师","男",28,"语文");
	tea.show();
	tea.teach();
	tea.eat();
	Person per=new Student("小刚","男",16,"1111");
	per.show();
	
	
	
	
}
}
