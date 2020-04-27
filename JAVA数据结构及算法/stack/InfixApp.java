package stack;

import java.io.IOException;

public class InfixApp {
	public static void main(String[] args) throws IOException {
		String input, output;
		while(true){
			System.out.print("������׺���ʽ��");
			System.out.flush();
			input = Util.getString();
			if (input.equals(""))
				break;
			InToPost trans = new InToPost(input);
			output = trans.doTrans();
			System.out.println("��׺���ʽ�� " + output);
		}
	}

}
