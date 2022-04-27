package hrmsXLRead;

import java.io.IOException;



public class HrmsXLMain {

	public static void main(String[] args) throws IOException {
		String value1 = HrmsXLCode.stringDataRead(1, 0);
		System.out.println(value1);
		String value2 = HrmsXLCode.integerDataRead(1, 1);
		System.out.println(value2);
	}

}
