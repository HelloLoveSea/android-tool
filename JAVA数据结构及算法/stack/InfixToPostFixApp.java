package stack;

import java.io.IOException;


public class InfixToPostFixApp {
	public static void main(String[] args) throws IOException {
		
		String infixInput, infixOutput;
		Integer postfixOutput;//��������ĺ�׺���ʽ��ֵ
		while(true){
			System.out.print("������׺���ʽ��");
			System.out.flush();
			infixInput = Util.getString();
			if (infixInput.equals(""))
				break;
			InToPost trans = new InToPost(infixInput);//��׺���ʽת���ɺ�׺���ʽ
			infixOutput = trans.doTrans();
			System.out.println("��׺���ʽ�� " + infixOutput);
			
			ParsePost parsePost = new ParsePost(infixOutput);
			postfixOutput = parsePost.doParse();//��׺���ʽ��ֵ
			System.out.println("������׺���ʽ��ֵ�� " + postfixOutput);
		}
	}

}
