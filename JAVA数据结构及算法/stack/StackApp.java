package stack;
public class StackApp {
	public static void main(String[] args) {
		StackX stackX = new StackX(5); //make new stack
		stackX.push(1);
		stackX.push(2);
		stackX.push(3);
		System.out.println("top = " + stackX.getTop());
		long vpeek = stackX.peek();//��ȡջ��Ԫ�أ����ǵ���ջ��Ԫ�أ�ջ��Ԫ�ظ����������
		System.out.println("value after peek method: " + vpeek + " , top = " + stackX.getTop());
		long vpop = stackX.pop();//����ջ��Ԫ�أ�ջ��Ԫ�ظ�����1
		System.out.println("value after pop method: " + vpop + " , top = " + stackX.getTop());
		while (!stackX.isEmpty()){
			long value = stackX.pop();//����ջ��Ԫ�أ�ջ��Ԫ�ظ�����1
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("\ntop = " + stackX.getTop());
		if (stackX.isEmpty())
			System.out.println("stack is empty after pop");
	}
}
