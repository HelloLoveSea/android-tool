package stack;
/**
 * ͨ��Object������ʵ���Զ����ջ
 *
 */
public class StackE<E> {
	private int maxSize;//size of stack array
	private Object[] stackArray;
	private int top; //top of stack
	
	//��ʼ��ջ��s��ջ�Ĵ�С
	public StackE(int s){
		maxSize = s;//set array size
		stackArray = new Object[maxSize]; //create array
		top = -1;// no items yet
	}
	
	//��itemѹ��ջ��
	public void push(E item) {// put item on top of stack
		stackArray[++top] = item; //increment top, insert item
	}
	
	//��ջ��Ԫ�ص�����ɾ��ջ��Ԫ��
	public E pop() {//take item from top of stack
		return (E) stackArray[top--];//access item, decrement top
	}
	//��ջ��Ԫ�ص���,����ɾ��ջ��Ԫ��
	public E peek(){//peek at top of stack
		return (E) stackArray[top];
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){//true if stack is empty
		return top == -1;
	}
	
	//�ж�ջ�Ƿ�����
	public boolean isFull(){//true if stack is full
		return top == maxSize - 1;
	}
	//����ջ��λ��
	public int getTop(){
		return top;
	}
	
	//��ջ�еĵ�n��Ԫ�ص���,����ɾ����Ԫ��
	public E peekN(int n){//peek at top of stack
		return (E) stackArray[n];
	}
	
	//��ȡջ��Ԫ�ظ���
	public int size(){
		return top+1;
	}
	
	public void displayStack(String s){
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for (int i = 0; i < size(); i++) {
			System.out.print(peekN(i));
			System.out.print(' ');
		}
		System.out.println();
	}
}
