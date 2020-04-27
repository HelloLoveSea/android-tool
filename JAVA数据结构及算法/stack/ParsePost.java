package stack;
/**
 * 						��׺���ʽ��ֵ
 * |----------------------------------------------------------|
 * |�Ӻ�׺���ʽ�ж�ȡ��Ԫ��  |          ִ�еĶ���                                                                 |
 * |-----------------|----------------------------------------|
 * |     ������                      |           ��ջ                                                                          |
 * |     ������                      |��ջ����ȡ�������������ò���������ִ�����㡣�����ջ             |
 * |----------------------------------------------------------|
 */
public class ParsePost {
	private StackE<Integer> stack;
	private String input;
	
	public ParsePost(String s){
		input = s;
	}
	/**
	 * ����׺���ʽ��ֵ��Ŀǰֻ������λ����ֵ
	 * @return ���ؼ�����
	 */
	public Integer doParse(){
		stack = new StackE<Integer>(20);//��ʼ��һ����СΪ20��ջ
		char ch;
		Integer num1, num2, tmpSum;
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);//�Ӻ�׺���ʽ�л�ȡһ���ַ�
			stack.displayStack("" + ch + " ");//��ӡ��ǰ���ַ�
			if (ch > '0' && ch <= '9'){
				stack.push(Integer.parseInt(ch+""));//��������־���ջ
			}else{//����ǲ��������ʹ�ջ����ʼ��������ȡ����ջԪ��
				num2 = stack.pop();//��ȡ��һ��ջԪ��
				num1 = stack.pop();//��ȡ�ڶ���ջԪ��
				switch (ch) {
				case '+'://������chΪ�ӣ�������num1��num2���мӷ����У����������浽tmpSum��
					tmpSum = num1 + num2;
					break;
				case '-':
					tmpSum = num1 - num2;
					break;
				case '*':
					tmpSum = num1 * num2;
					break;
				case '/':
					tmpSum = num1 / num2;
					break;
				default:
					tmpSum = 0;
					break;
				}//end switch
				stack.push(tmpSum);//��������tmpSum��ջ
			}//end else
		}//end for
		tmpSum = stack.pop();//��׺���ʽ�е�Ԫ�ض�ȡ��󣬽���������ջ
		return tmpSum;
	}
	
}
