package text_1;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileOut {
	//	private Vector<Float> output = new Vector<Float>();
	File myFilePath = new File("d:\\123.txt");
	public void outt(String outdata){
//		File myFilePath = new File("d:\\123.txt");
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter output = new PrintWriter(resultFile);
			output.println("123456");
			output.flush();
			resultFile.close();
		}
		catch (Exception e) {
			System.out.println("新建文件操作出错");
			e.printStackTrace();
		}
	}

}
