package text_1;
import java.util.Iterator;
import java.util.Vector;

public class CanopyVector {

	private Vector<Float> v = new Vector<Float>(); //每一个变量V
	public Float distance = (Float) null;//距离运算
	public int PNum = 0;
	CanopyVector(Integer vnum, Float num) {
		this.v = new Vector<Float>();
		for(int i = 0; i < vnum; i++) {
			this.v.add(num);
			//System.out.println("v" + this.v.size());
		}
	}

	CanopyVector(CanopyVector cv) {
		this.v = cv.getVector();
	}

	CanopyVector(String data, String regex) {
		setData(data, regex);
	}

	CanopyVector(double[] ff){
		this.v = new Vector<Float>();

		for(int j = 0; j < ff.length; j++)
		{
			v.add((float) ff[j]);
		}
		//System.out.println("v" + this.v.size());
	}


	public void setData(String data, String regex) {
		String[] datas = data.split(regex);
		for(int i = 0; i < datas.length; i++) {
			v.add(Float.parseFloat(String.valueOf(datas[i])));
		}
		//System.out.println("new v: " + this.v);
	}//读入数据

	public Float setDistance(Vector<Float> centerVector) {
		//System.out.println("size of v is" + v.size());
		if(v.size() == centerVector.size()) {
			Double square = (double) 0;
			for(int index = 0; index < v.size(); index++) {
				square += Math.pow((v.elementAt(index) - centerVector.elementAt(index)), 2);
			}
			this.distance = (float) Math.sqrt(square);
			return this.distance;

		} else {
			System.out.println("Error: Vector size is not match. v: " + v.size() + ", center vector: " + centerVector.size());
		}
		return null;
	}//计算欧氏距离

	public Vector<Float> getVector() {
		return this.v;
	}

	public int size() {
		return this.v.size();
	}

	public Vector<Float> addVector(CanopyVector cv) {
		Vector<Float> vector = new Vector<Float>();
		if(this.v.size() == cv.getVector().size()) {
			for(int index = 0; index < v.size(); index++) {
				vector.add(v.elementAt(index) + cv.getVector().elementAt(index));
			}
			this.v = vector;
			return this.v;
		} else {
			System.out.println("Error: Vector size is not match. v: " + v.size() + ", center vector: " + cv.getVector().size());
		}
		return null;
	}

	public Vector<Float> divideVector(Integer divide) {
		Float tmp = null;
		for(int index = 0; index < this.v.size(); index++) {
			tmp = this.v.elementAt(index) / divide;
			this.v.remove(index);
			this.v.add(index, tmp);
		}
		return this.v;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Float> it = v.iterator();
		while(it.hasNext()) {
			sb.append(it.next()).append("\t");
		}
		return sb.toString().trim();
	}
}
