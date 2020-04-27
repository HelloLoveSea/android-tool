package queue;

public class QueueImp<E> implements Queue<E>{
	private int maxSize;//�����������
	private Object[] queArray;//������е�����
	private int front;//����ͷ�±�
	private int rear;//����β�±�
	private int nItems;//���е�ǰԪ�ظ���
	//��ʼ�����г�Ա����
	public QueueImp(int s) {
		maxSize = s;
		queArray = new Object[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	//�Ӷ���β�����Ԫ��
	public boolean add(E e) throws Exception{
		if (isFull())
			throw new Exception("queue is full");
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = e;
		nItems++;
		return true;
	}

	//��ȡ����ͷԪ�ز��ҴӶ�����ɾ����Ԫ��
	public E remove() throws Exception{
		if (isEmpty())
			throw new Exception("queue is empty");
		E e = (E) queArray[front++];
		if (front == maxSize)
			front = 0;
		nItems--;
		return e;
	}
	
	//��ȡ����ͷԪ��
	public E peek() throws Exception{
		if (isEmpty())
			throw new Exception("queue is empty");
		return (E) queArray[front];
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return nItems == 0;
	}
	//�ж϶����Ƿ����
	public boolean isFull(){
		return nItems == maxSize;
	}
	//��ȡ���г���
	public int size(){
		return nItems;
	}
	//��ӡ����
	public String toString() {
		if (isEmpty())
			return "";
		String str = "queue: [ ";
		for (int i = front; i < maxSize; i++)
			str += queArray[i] + " ";
		str += "]";
		return str;
	}
}
