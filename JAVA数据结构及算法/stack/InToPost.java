package stack;
/**
 * ��׺���ʽת���ɺ�׺���ʽ
 */
public class InToPost {
	private StackE<String> stack;
	private String input;//������׺���ʽ
	private String output = "";//�����׺���ʽ
	//�Ӽ���+-��������Ȩ
	private static final int PRECEDENCE_1 = 1;
	//�˳���*/��������Ȩ
	private static final int PRECEDENCE_2 = 2;
	
	public InToPost(String in){
		input = in;
		int stackSize = input.length();
		stack = new StackE<String>(stackSize);
	}
	//��׺���ʽת���ɺ�׺���ʽ
	public String doTrans(){
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);//��׺���ʽ�е��ַ�
			stack.displayStack("For " + ch + " ");
			switch (ch) {
			case '+':
			case '-':	
				getOper(ch, PRECEDENCE_1);//�жϼӼ���+-��������ջ������ֱ����ӵ��ַ���output��
				break;
			case '*':
			case '/':
				getOper(ch, PRECEDENCE_2);//�жϳ˳���*/��������ջ������ֱ����ӵ��ַ���output��
				break;
			case '(':
				stack.push(ch+"");//�������ַ���������'('����ֱ��ѹ��ջ��
				break;
			case ')':
				//��ջ��Ԫ�ص���ջ�����뵽�ַ���output�У�ֱ��������Ԫ����������')'Ϊֹ��������󵯳��������Ų������ַ���output��
				getParen(ch);
				break;
			default:
				output += ch;
				break;
			}//end switch
		}//end for
		while (!stack.isEmpty()){
			stack.displayStack("while ");
			output += stack.pop();
		}
		stack.displayStack("End ");
		return output;
	}
	/**
	 * ������opThis�ǼӼ��˳�ʱ��ͨ����ջ��Ԫ��opTop�Ա�����Ȩ�����opThis������Ȩ����opTop��
	 * ��ôֱ�ӽ�opThisѹ��ջ���������Ƚ�opTop����ջ����Ȼ���ٽ�opThisѹ��ջ��
	 * @param opThis ����Ĳ�����
	 * @param prec1  opThis������Ȩ��1����Ӽ���2����˳�
	 */
	public void getOper(char opThis, int prec1){
		while( !stack.isEmpty()){
			char opTop = stack.pop().charAt(0);//������ջ��Ԫ�أ����opThis������Ȩ����opTop����ô��Ҫ����ѹ��opTop��ջ��
			//���ջ��Ԫ����'('����ô����ѹ��յ�����ջ��Ԫ��'(',����ѭ�����ҽ�opThisֱ��ѹ��ջ��
			if (opTop == '('){
				stack.push(opTop+"");
				break;
			}else{//���ջ��Ԫ���ǲ���������ô�Ա�opThis��opTop������Ȩ��
				int prec2;//��������ջ��Ԫ��opTop������Ȩ
				if (opTop == '+' || opTop == '-')
					prec2 = 1;//���ջ��Ԫ��Ϊ������'+'����'-',��ô����ȨΪ1
				else
					prec2 = 2;//���ջ��Ԫ��Ϊ������'*'����'/',��ô����ȨΪ2
				if (prec2 < prec1){//����opThis������Ȩ����opTop������opTop����Ҫ����ջ�������Ҫ���°ѳ�ջ��opTop����ѹ��ջ��
					stack.push(opTop+"");//���°ѳ�ջ��opTop����ѹ��ջ����������ѭ����Ȼ����opThisѹ��ջ��
					break;
				}else{
					output += opTop;//����������ӵ������ַ���output��
				}
			}
		}//end while
		stack.push(opThis+"");//��opThisѹ��ջ��
	}
	/**
	 * �������ַ�opThis��������')'ʱ�����ջ��Ԫ��opTop����������'(',�ͽ�ջ��Ԫ��opTop��ӵ��ַ���output��
	 * @param opThis
	 */
	public void getParen(char opThis){
		while (!stack.isEmpty()){
			char opTop = stack.pop().charAt(0);//����ջ��Ԫ��opTop
			if (opThis == ')' && opTop == '(')//���ջ��Ԫ��opTop��������'('�����˳�ѭ��
				break;
			else
				output += opTop;//ջ��Ԫ��opTop����������'(',��ջ��Ԫ��opTop��ӵ��ַ���output��
		}
	}
}
