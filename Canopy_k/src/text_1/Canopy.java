package text_1;

import io.LineListener;
import io.OptionListener;
import io.StructDataReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Canopy {
	public static double[][] liucun=new double [9][5];
	private static int knumber = 0;

	/**************************************
	 * 计算聚类中心
	 * @param arg
	 * @throws Exception
	 */
	public static double[][] getCenters(double data[][],int log[],int row,int col,int k){
		int i=0;
		double centers[][] = new double[k][col+1];
		for(int m=0;m<k;m++){
			for(int n=0;n<col;n++){
				centers[m][n] = 0.0;
			}
		}
		while(i<k){
			int count=0;
			for(int j=0;j<row;j++){
				if(log[j]==i){
					count=count+1;
					for(int m=0;m<col;m++){
						centers[i][m]=centers[i][m]+data[j][m];
					}
				}
			}
			centers[i][col]=count;
			for(int n=0;n<col;n++){
				centers[i][n]=centers[i][n]/count;
			}
			i++;
		}
		return centers;
	}

	public static void main(String arg[]) throws Exception {
		PCA pp = new PCA();
		pp.pca();
		pp.write(pp.ZFF, pp.row, pp.count);
		int pointNum = pp.row;
		int pointLength = pp.count;
		double[][] ff = pp.ZFF;

		System.out.println("Canopy");
		System.out.println("Memory Consuming:"+(float)(Runtime.getRuntime().totalMemory() -
				Runtime.getRuntime().freeMemory())/1000000 + "MB");

		CanopyMatrix cm = new CanopyMatrix(0.07, 0.22);
//		try {
//			cm.readMatrix("d:\\126.txt");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//System.out.println(pp.ZFF[1][2]);
		//System.out.println(ff);
		System.out.println(ff[0].length);
		cm.readData(ff);
		cm.start();
		cm.outt("d:\\1239.txt");

		/***********************
		 * k-means
		 **********************/


		String initialPath = "D:\\1239.txt";
		final StructDataReader sdrc = new StructDataReader(initialPath, true);

		//读初始中心
		sdrc.setLineListener(new LineListener() {

			//	@Override
			public void opt(String line) {
			}

			@Override
			public void opt(String[] strs) {}

			@Override
			public void setReader(StructDataReader sdReader) {}
		}).setStopListener(new OptionListener() {
			@Override
			public void opt() {
				knumber = (int) sdrc.getPostion();
			}
		}).read();
		sdrc.close();
		K_Means2 app = new K_Means2(pointNum, pointLength, knumber);// 创建一个类实例
		app.train = pp.ZFF;
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
		app.WrietTxt("D:\\11239cluster.txt");


		//聚类中心
		double centers[][] = new double [app.getK()][pp.col+1];
		centers = getCenters(pp.ZFdata, app.logo, pp.row, pp.col, app.getK());
		for(int i=0;i<app.getK();i++){
			for(int j=0;j<pp.col+1;j++){
				System.out.print(centers[i][j]+"\t");
			}
			System.out.println();
		}

		try {
			FileWriter output = new FileWriter("D://test.txt");
			BufferedWriter bf = new BufferedWriter(output);
			for(int i=0;i<app.getK();i++){
				for(int j=0;j<=pp.col;j++){
					bf.write(String.valueOf(centers[i][j])+"\t");
				}
				bf.write("\r\n");
			}
			bf.flush();// 此处很关键，如果不写该语句，是不能从缓冲区写到文件里的
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		System.out.println("Total Time:"+ (endTime - startTime)/1000+"s");
		System.out.println("Memory Consuming:"+(float)(Runtime.getRuntime().totalMemory() -
				Runtime.getRuntime().freeMemory())/1000000 + "MB");
		System.out.println("number of cluster:" + app.getK());
		System.out.println("pointNum:"+pointNum);//String.valueOf(app.centers[3][2]));
		for(int i=0;i<app.getK();i++){
			for(int j=0;j<=pp.col;j++){
				liucun[i][j]=centers[i][j];
			}
		}

	}

}
