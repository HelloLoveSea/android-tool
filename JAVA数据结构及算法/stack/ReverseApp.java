package stack;
import java.io.IOException;
public class ReverseApp {
	public static void main(String[] args) throws IOException{
		String input, output;
		while (true){
			System.out.print("Enter a string: ");
			System.out.flush();//ˢ�»�����
			input = Util.getString();
			if (input.equals("q")){// read a string from kbd
				System.out.println("exit main");
				break;// quit if input q
			}
			Reverser reverser = new Reverser(input);
			//����ջ�ĺ���ȳ�ԭ���Ƚ��ַ����е��ַ���ջ��Ȼ���ٽ��ַ����е��ַ���ջ��ʵ���ַ�������
			output = reverser.doRev();
			System.out.println("reversed: " + output);
		}//end while
	}// end main
}
