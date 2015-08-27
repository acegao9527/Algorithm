package io;

public interface LineListener {
	public void opt(String line);

	public void opt(String[] strs);

	public void setReader(StructDataReader sdReader);

}
