package queue;
/**
 * ���еĲ����ӿڶ���
 * @param <E> ���ͣ�ƥ�����������Ķ���
 */
public interface Queue<E> {
	
	boolean add(E e) throws Exception;
	
	E remove() throws Exception;
	 
	E peek() throws Exception;
	
	int size();
	
	String toString();
}
