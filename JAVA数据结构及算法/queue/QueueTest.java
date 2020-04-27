package queue;
public class QueueTest {
	public static void main(String[] args) {
		Queue<String> queue = new QueueImp<String>(5);
		try {
			//�����β���Ԫ��
			queue.add("1");//�����β���Ԫ��1
			queue.add("2");//�����β���Ԫ��2
			queue.add("4");//�����β���Ԫ��4
			queue.add("6");//�����β���Ԫ��6
			queue.add("9");//�����β���Ԫ��9
			System.out.println("queue size: " + queue.size());//��ӡ���г���
			System.out.println(queue.toString());////��ӡ����
			//��ȡ����ͷԪ�أ�����Ӷ�����ɾ����Ԫ��
			String peekTop = queue.peek();
			System.out.println("queue size after peek: " + queue.size() + " ,peekTop = " + peekTop);
			System.out.println(queue.toString());////��ӡ����
			//��ȡ����ͷԪ�ز��ҴӶ�����ɾ����Ԫ��
			String removeTop = queue.remove();//ɾ�������еĶ�ͷԪ��1��2����µĶ�ͷԪ��
			System.out.println("queue size after remove: " + queue.size() + " ,removeTop = " + removeTop);
			System.out.println(queue.toString());////��ӡ����
			removeTop = queue.remove();//ɾ�������еĶ�ͷԪ��2��4����µĶ�ͷԪ��
			System.out.println("queue size after remove: " + queue.size() + " ,removeTop = " + removeTop);
			System.out.println(queue.toString());////��ӡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
