package text_1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
//import java.io.BufferedReader;
//import java.io.FileWriter;


public class CanopyMatrix {
	public Vector<CanopyVector> cm = new Vector<CanopyVector>();//数据集
	public Vector<CanopyVector> out = new Vector<CanopyVector>();//输出
	public static Float T1 = null;
	public static Float T2 = null;
	public int beforep;
	public int lengthofdata = 0;
	float[][] ZZF;
	//public int ctp;
	private Integer steps = 0;

	//CanopyMatrix(Float T1, Float T2) {
	//	this.setTValue(T1, T2);
//	}

	CanopyMatrix(Double T1, Double T2) {
		this.setTValue(T1.floatValue(), T2.floatValue());
	}

	public void setTValue(Float T1, Float T2) {
		if(T1.compareTo(T2) <= 0) {
			CanopyMatrix.T1 = T1;
			CanopyMatrix.T2 = T2;
			//CanopyMatrix.kc = kc;
			System.out.println("Set T1: " + T1 + ", T2: " + T2 );
		} else {
			System.out.println("Error: T1 > T2. ");
		}
	}//T1,T2set

	@SuppressWarnings("resource")
	public void readMatrix(String path) throws IOException {
		File file = new File(path);
		if(!file.exists() || file.isDirectory()) {
			System.out.println("Not found path.");
		} else {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;

			do {
				line = br.readLine();
				if(line != null && !line.isEmpty())cm.add(new CanopyVector(line, "\t"));
			} while(line != null);
			this.lengthofdata = cm.size();
			//System.out.println(cm);
		}
//		for(int index = 0; index < cm.size(); index++) {
//			System.out.println("cm: " + cm.elementAt(index).getVector());
//		}
	} //导入数据文件  
	public void readData(double[][] ff){
		System.out.println(ff.length + ":");
		System.out.println(ff[0].length + ":");
		for (int i = 0; i < ff.length; i++) {
			cm.add(new CanopyVector(ff[i]));
		}
		//System.out.println(cm);
		this.lengthofdata = cm.size();
	}
	public void outt(String outdata){
		File myFilePath = new File("d:\\1239.txt");
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			for(int index = 0; index < out.size(); index++) {
				if(this.out.elementAt(index).PNum > (lengthofdata/50)) {
					myFile.println(" " + this.out.elementAt(index));
					myFile.flush();
				}
				else {
					System.err.println(this.out.elementAt(index));
				}
			}
			myFile.flush();
			resultFile.close();
		}
		catch (Exception e) {
			System.out.println("新建文件操作出错");
			e.printStackTrace();
		}
	}

	public void start() {
		while(this.step());
		for(int index = 0; index < out.size(); index++) {
			System.out.print(" " + this.out.elementAt(index).getVector());

		}
	}

	//在最后输出选到的中心

	public Boolean step() {
		steps++;
		System.out.println("Step " + steps + " :");
		int ctp = 0;
		Vector<CanopyVector> tmpCm = new Vector<CanopyVector>();//存储剩余点的数据集
		Vector<CanopyVector> cCm = new Vector<CanopyVector>();//存储中心点的数据集
		CanopyVector firstVector = cm.firstElement();
//		Random r = new Random();
//		CanopyVector firstVector = cm.elementAt(r.nextInt(cm.size()));
		Float tmpDistance = null;
		for(int index = 0; index < cm.size(); index++) {
			CanopyVector tmpVector = cm.elementAt(index);
			tmpDistance = tmpVector.setDistance(firstVector.getVector());
			if(tmpDistance != null) {
				if(tmpDistance.floatValue() < T1.floatValue()) {
					beforep = cm.size();
				} else if(tmpDistance.floatValue() < T2.floatValue()) {
					tmpCm.add(tmpVector);
					cCm.add(tmpVector);
				} else {
					tmpCm.add(tmpVector);
				}
			}
		}
		cm = tmpCm;
		ctp = beforep - cm.size();
		this.outVecter(cCm, ctp);
		if(cm.isEmpty()) {
			System.out.println("There are " + cm.size() + " vectors left.");
			return false;
		} else {
			System.out.println("There are " + cm.size() + " vectors left.");
			System.out.println("This cluster contains " + ctp + " vectors left.");
			return true;
		}
	}

	public void outVecter(Vector<CanopyVector> cCm, int ctp) {
		if(cCm.size() != 0) {
			CanopyVector cv = new CanopyVector(cCm.firstElement().size(), (float) 0);
			cv.PNum = ctp;
			for(int index = 0; index < cCm.size(); index++) {
				cv.addVector(cCm.elementAt(index));
				//	System.out.println("vector: " + cCm.elementAt(index).getVector());
			}
			cv.divideVector(cCm.size());
			this.out.add(cv);
			System.out.println("Out vectors: " + cv.getVector());

		}
	}//对小于t2的数据求中心

}
