package stack;

import java.io.IOException;
public class PostFixApp {
	public static void main(String[] args) throws IOException {
		String input;
		Integer output;
		while (true){
			System.out.print("�����׺���ʽ�� ");
			System.out.flush();
			input = Util.getString();//�Ӽ�������
			if (input.equals(""))
				break;
			ParsePost parsePost = new ParsePost(input);
			output = parsePost.doParse();//��׺���ʽ��ֵ
			System.out.println("������׺���ʽ���ֵ�� " + output);
		}
	}

}
