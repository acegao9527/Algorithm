package text_1;
import Jama.Matrix;

import java.io.*;

//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class PCA {
	public double ZFdata[][];//***原始数据***
	public double zsdata[][];//z-score归一化后的数据
	public double Rdata[][];//相关系数矩阵
	public double ZFF[][];//***原始数据计算的主成分归一化后矩阵***
	public double mmdata[][];//最大最小值矩阵
	public int row;
	public int col;
	public int count;
	
	/*public void getData(){
		try{
        	File f=new File(System.getProperty("user.dir")+"/changshi.xlsx");
        	XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(f));
	        Sheet sheet = wb.getSheetAt(1);//读取第二个表sheet2
	        
	        row = sheet.getLastRowNum();//获取表格行数从0开始
	        Row row_array[] = new Row [row];
	        for(int i=0;i<row;i++){
	        	row_array[i] = sheet.getRow(i+1);
	        }
	        col = row_array[0].getPhysicalNumberOfCells();//获取列数
	       
	        ZFdata = new double[row][col];
	        zsdata = new double[row][col];
	        //读取excel值
	        for(int i=0;i<row;i++){
	        	for(int j=0;j<col;j++){
	        		int type=row_array[i].getCell(j).getCellType();
	        		if(type==0){
	        			ZFdata[i][j]=row_array[i].getCell(j).getNumericCellValue();
	        		}
	        		else {
	        			ZFdata[i][j]=Double.parseDouble(row_array[i].getCell(j).toString());
	        		}
	        		//System.out.print(ZFdata[i][j]);
	        		//System.out.print(" ");
	        	} 	//System.out.println();
	        }
        }
        catch(Exception ee){
			ee.printStackTrace();
		}
	} */

	public void getData(){
		try{
			FileReader fs = new FileReader(System.getProperty("user.dir")+"/126.txt");
			BufferedReader br = new BufferedReader(fs);
			FileReader fs_1 = new FileReader(System.getProperty("user.dir")+"/126.txt");
			BufferedReader br_1 = new BufferedReader(fs_1);
			String str = br.readLine();
			String ss[] = str.split("\t");
			int length = ss.length;
			System.out.println(length);
			int all = 0;
			while(str != null){
				str = br.readLine();
				all++;
			}
			System.out.println(all);
			ZFdata = new double[all][length];
			zsdata = new double[all][length];
			row = all;
			col = length;
			br.close();
			String str_1 = br_1.readLine();
			int index = 0;
			while(str_1 != null){
				String temp [] = str_1.split("\t");
				for(int i=0;i<length;i++){
					ZFdata[index][i] = Double.parseDouble(temp[i]);
				}
				index++;
				str_1 = br_1.readLine();
			}
			br_1.close();
			for(int i=0;i<count;i++){
				for(int j=0;j<length;j++){
					System.out.print(ZFdata[i][j]);
				}System.out.println();
			}

		}
		catch(Exception e){
			System.out.print(e.toString());
		}
	}

	//计算平均值
	public double Average(double d[][], int x, int y){
		double sum = 0;
		for(int i=0;i<x;i++){
			sum+=d[i][y];
		}
		double mean = sum/x;
		return mean;
	}

	//计算标准差
	public double StandardDev(double d[][], int x, int y){
		double sum = 0;
		double mean = Average(d,x,y);
		for(int i = 0;i<x;i++){
			sum += (d[i][y]-mean)*(d[i][y]-mean);
		}
		return Math.sqrt((sum / (x-1)));
	}

	//z-score数据归一化
	public void Zscore(double d[][],int x,int y){
		double mean = Average(d,x,y);
		double sd = StandardDev(d,x,y);
		for(int i=0;i<x;i++){
			zsdata[i][y] = (d[i][y]-mean)/sd;
		}
	}

	//找最大值
	public double Maxnum(double d[][],int x,int y){
		double max = d[0][y];
		for(int i=1;i<x;i++){
			if(d[i][y]>max){
				max = d[i][y];
			}
		}
		return max;
	}

	//找最小值
	public double Minnum(double d[][],int x,int y){
		double min = d[0][y];
		for(int i=1;i<x;i++){
			if(d[i][y]<min){
				min = d[i][y];
			}
		}
		return min;
	}

	//最大最小值归一化
	public double Normalize(double x,double max,double min){
		double y;
		y = (x - min)/(max - min);
		return y;
	}

	//输出文件
	public void write(double[][] d,int x,int y){
		try {
			FileWriter output = new FileWriter("D://test.txt");
			BufferedWriter bf = new BufferedWriter(output);
			for(int i=0;i<x;i++){
				for(int j=0;j<y;j++){
					bf.write(String.valueOf(d[i][j])+"\t");
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


	}
	public void pca(){
		getData();
		for(int i=0;i<col;i++){
			Zscore(ZFdata,row,i);
		}
		/*for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(zsdata[i][j]);
				System.out.print(",");
			}System.out.println();
		}*/

		//从归一化矩阵求相关系数矩阵
		Matrix Z = new Matrix(zsdata);
		Matrix tZ = Z.transpose();
		Matrix tZZ = tZ.times(Z);
		Rdata = tZZ.getArrayCopy();
		for(int i=0;i<col;i++){
			for(int j=0;j<col;j++){
				Rdata[i][j]=Rdata[i][j]/(row-1);
				//System.out.print(Rdata[i][j]);
			}//System.out.println();
		}

		//求Rdata特征值
		Matrix R = new Matrix(Rdata);
		Matrix teZ = R.eig().getD();
		Matrix teV = R.eig().getV();
		double tezarray[][] = teZ.getArrayCopy();//特征值对角矩阵
		double tevarray[][] = teV.getArrayCopy();//特征向量矩阵
		//teZ.print(4, 8);
		//teV.print(4, 8);

		//确定主成分个数
		double sumtez = teZ.trace();
		// System.out.println(sumtez);
		double tra[] = new double[col];//特征值数组
		for(int m=0;m<col;m++){
			tra[m] = tezarray[m][m];
		}
		for(int i=1;i<=row;i++){
			double tesum = 0.0;
			for(int j=0;j<i;j++){
				tesum+=tra[col-1-j];
			}
			double panding = tesum/sumtez;
			if(panding>=0.85){
				count = i;
				break;
			}
		}
		//System.out.println(count);

		//计算主成分
		ZFF = new double[row][count];//原始数据计算的主成分矩阵
		for(int i=0;i<count;i++){
			for(int j=0;j<row;j++){
				for(int m=0;m<col;m++){
					ZFF[j][i] += tevarray[m][col-1-i]*ZFdata[j][m];
				}
			}
		}

		//最大最小值归一化
		mmdata = new double[2][count];//每个主成分最大值和最小值存储数组
		for(int j=0;j<count;j++){
			mmdata[0][j] = Maxnum(ZFF,row,j);
		}
		for(int i=0;i<count;i++){
			mmdata[1][i] = Minnum(ZFF,row,i);
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<count;j++){
				ZFF[i][j] = Normalize(ZFF[i][j],mmdata[0][j],mmdata[1][j]);//最大最小值归一化后的主成分矩阵
			}
		}
	}
}
