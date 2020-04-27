package stack;
/**
 * ͨ��long������ʵ���Զ����ջ
 *
 */
public class StackX {
	private int maxSize;//size of stack array
	private long[] stackArray;
	private int top; //top of stack
	
	//��ʼ��ջ��s��ջ�Ĵ�С
	public StackX(int s){
		maxSize = s;//set array size
		stackArray = new long[maxSize]; //create array
		top = -1;// no items yet
	}
	
	//��itemѹ��ջ��
	public void push(long item) {// put item on top of stack
		stackArray[++top] = item; //increment top, insert item
	}
	
	//��ջ��Ԫ�ص�����ɾ��ջ��Ԫ��
	public long pop() {//take item from top of stack
		return stackArray[top--];//access item, decrement top
	}
	//��ջ��Ԫ�ص���,����ɾ��ջ��Ԫ��
	public long peek(){//peek at top of stack
		return stackArray[top];
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
}
