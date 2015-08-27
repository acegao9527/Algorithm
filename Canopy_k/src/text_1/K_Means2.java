package text_1;


import io.LineListener;
import io.StructDataReader;

import java.io.BufferedWriter;
import java.io.FileWriter;



public class K_Means2 {

	int Flags = 0;
	int rows, columns;
	static int k;
	int[] logo; // 标志位
	double[][] train;// 将对象实体化
	double[][] centers;// k个中心点数
	double[][] tempCenters;// k个新中心点

	public K_Means2(int pointNum, int pointLength, int centerNum) {
		rows = pointNum;
		columns = pointLength;
		k = centerNum;

		logo = new int[rows];
		train = new double[rows][columns];
		centers = new double[k][columns];
		tempCenters = new double[k][columns];

		// 初始化标志位
		for (int i = 0; i < rows; i++) {
			logo[i] = 0;
		}
		// 初始化所有点
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				train[i][j] = 0.0;
			}
		}
	}

	/***************************************************************************
	 * 读文件data0.txt中数据，保存至train[][]二维数组中
	 **************************************************************************/
//	public void readtxt(String filename) throws Exception {
//		final StructDataReader sdr = new StructDataReader(filename, true);
//		sdr.setLineListener(new LineListener() {
//
//			@Override
//			public void opt(String line) {}
//
//			@Override
//			public void opt(String[] strs) {
//				int i = (int) (sdr.getPostion() - 1);
//				for (int j = 0; j < strs.length; j++) {
//					train[i][j] = Double.valueOf(strs[j]);
//				}
//			}
//
//			@Override
//			public void setReader(StructDataReader sdReader) {}
//		}).readBySplits("\t");
//		sdr.close();
//	}
	/*public void readtxt(){
		PCA pp_1 = new PCA();
		pp_1.pca();
		train = pp_1.ZFF;
	}*/

	/***************************************************************************
	 * 初始化新旧中心点
	 **************************************************************************/
	/*public void initial() {
		// 初始化旧中心点，不妨以前k个为中心点
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < columns; j++) {
				centers[i][j] = train[i][j];
			}
		}
		// 初始化新中心点
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < columns; j++) {
				tempCenters[i][j] = 0.0;
			}
		}
	}*/

	public void initial(String path) {
		final StructDataReader sdr = new StructDataReader(path, true);
		sdr.setLineListener(new LineListener() {
			@Override
			public void opt(String line) {}

			@Override
			public void opt(String[] strs) {
				int i = (int) (sdr.getPostion() - 1);
				for (int j = 0; j < strs.length; j++) {
					centers[i][j] = Double.valueOf(strs[j]);
				}
			}
			@Override
			public void setReader(StructDataReader sdReader) {}
		}).readBySplits("\t");
		sdr.close();

		// 初始化新中心点
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < columns; j++) {
				tempCenters[i][j] = 0.0;
			}
		}
	}

	/***************************************************************************
	 * 比较差值，确定所属类
	 **************************************************************************/
	public void plus()// 求方差
	{
		double dis[] = new double[k];

		for (int i = 0; i < rows; i++) {
			for (int m = 0; m < k; m++) {
				dis[m] = 0.0;
				for (int j = 0; j < columns; j++) {
					dis[m] += Math.pow((train[i][j] - centers[m][j]), 2);
				}
			}
			token(dis, i);// 标记logo[i] ，以logo=1,2,3表示所属类
		}
	}

	/***************************************************************************
	 * 求数组中最小值的索引
	 **************************************************************************/
	public int minIndex(double[] dis) {
		int index = 0;
		double tempMin = dis[0];
		for (int i = 0; i < dis.length; i++) {
			if (tempMin > dis[i]) {
				tempMin = dis[i];
				index = i;
			}
		}
		return index;
	}

	/***************************************************************************
	 * 更改标志位(重新分配，看点属于那个簇),用1--k标记，分别表示k个类别
	 **************************************************************************/
	public void token(double[] dis, int i) {
		int index = minIndex(dis);
		logo[i] = index;// 将第i个元素归为第index类
	}

	/***************************************************************************
	 * 每聚类一次，求一次新的中心点
	 **************************************************************************/
	public void center() {
		int num[] = new int[k];
		for (int i = 0; i < k; i++)
			num[i] = 0;
		for (int m = 0; m < k; m++) {
			for (int i = 0; i < rows; i++) {
				if (logo[i] == m) {
					arraryAdd(tempCenters[m], train[i], columns);
					num[m]++;
				}
			}
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < columns; j++) {
				tempCenters[i][j] = tempCenters[i][j] / (double) num[i];
			}
		}
	}

	/***************************************************************************
	 * 求两个数组（向量）的和
	 **************************************************************************/
	public void arraryAdd(double[] a, double[] b, int length) {
		for (int i = 0; i < length; i++) {
			a[i] = a[i] + b[i];
		}
	}

	/***************************************************************************
	 * 判断聚类运算是否结束
	 **************************************************************************/
	public void compare()// 新旧中心点
	{
		double[] errors;
		errors = new double[k];
		for (int i = 0; i < k; i++) {
			errors[i] = 0.0;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < columns; j++) {
				errors[i] += Math.pow((tempCenters[i][j] - centers[i][j]), 2);
			}
		}
		// 符合要求
		for (int i = 0; i < k; i++) {
			if (errors[i] > 0.0001) {
				Flags = 0;
				break;
			} else
				Flags = 1;
		}
	}

	/***************************************************************************
	 * 用新的簇中心替换旧的簇中心
	 **************************************************************************/
	public void DuplicateCenter() {
		if (Flags == 0) {
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < columns; j++) {
					centers[i][j] = tempCenters[i][j];
				}
			}
		}
	}

	/***************************************************************************
	 * 写文件到cluster_result.txt中
	 **************************************************************************/
	public void WrietTxt(String writeFilename) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(writeFilename));
		int index = 0;
//		if(index <= k){
//		for(int i=0; i < k ; i++){
//			for(int j = 0; j < columns; j++){
//				String s = "";
//				s += " " + String.valueOf(centers[i][j]) + " ";
//			bw.write( s );// 输出聚类中心
//			}
//			bw.newLine();
//		}
//		}
//		bw.newLine();
//		index = 0;
		while(index < train.length){
			String si = "";
			si += " " + String.valueOf(index) + "\t";
			bw.write(si + String.valueOf(logo[index]));// 加入标志位
			bw.newLine();
			index++;
		}
		bw.close();
	}
	public static int getK(){
		return k;
	}
//	private static int pointNum = 0;
//	private static int pointLength = 0;
//	private static int knumber = 0;
	//private static String path = "D:\\126.txt";
//	private static String initialPath = "D:\\123.txt";
	
	/*public static void main(String args[]) throws Exception {
		 
		//final StructDataReader sdr = new StructDataReader(path, true);
		final StructDataReader sdrc = new StructDataReader(initialPath, true);
		//读数据
//		sdr.setLineListener(new LineListener() {
//
//			@Override
//			public void opt(String line) {
//					if (sdr.getPostion() == 1) {
//					String[] strs = line.split("\t");
//					pointLength = strs.length;
//				}
//			}
//
//			@Override
//			public void opt(String[] strs) {}
//
//			@Override
//			public void setReader(StructDataReader sdReader) {}
//			
//		}).setStopListener(new OptionListener() {
//			@Override
//			public void opt() {
//				pointNum = (int) sdr.getPostion();
//				//knumber = (int) sdr.getPostion(); 
//			}
//		}).read();
//		sdr.close();
		//读初始中心
		sdrc.setLineListener(new LineListener() {

			@Override
			public void opt(String line) {
					if (sdrc.getPostion() == 1) {
					String[] strs = line.split("\t");
					pointLength = strs.length;
				}
			}

			@Override
			public void opt(String[] strs) {}

			@Override
			public void setReader(StructDataReader sdReader) {}
			
		}).setStopListener(new OptionListener() {
			@Override
			public void opt() {
				//pointNum = (int) sdr.getPostion();
				knumber = (int) sdrc.getPostion(); 
			}
		}).read();
		sdrc.close();
		
		K_Means2 app = new K_Means2(pointNum, pointLength, knumber);// 创建一个类实例

		//app.readtxt(path);
		// app.set();
		app.initial(initialPath);
		app.plus();
		app.center();
		// 不停的循环
		while (app.Flags == 0) {
			app.DuplicateCenter();
			app.plus();
			app.center();
			app.compare();
		}
		app.WrietTxt("D:\\239cluster.txt");
		long endTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
	       System.out.println("Total Time:"+ (endTime - startTime)/1000+"s");
	       System.out.println("Memory Consuming:"+(float)(Runtime.getRuntime().totalMemory() -
	          Runtime.getRuntime().freeMemory())/1000000 + "MB");
	       System.out.println("number of cluster" + k);
		//
		// for(int i=0;i<app.train.length;i++)//显示结果－测试用
		// {
		// // System.out.println(i+"----"+ app.logo[i]);
		// // };
		// // new MainFrame(app);
		// }
	}*/
}
