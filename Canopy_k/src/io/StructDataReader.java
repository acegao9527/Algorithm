package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StructDataReader {
	private final int STOP = 0;
	private final int READING = 1;
	private final int SUSPEND = 2;
	
	private LineListener lineListener = null;
	private OptionListener stopOptionListener = null;

	private File file = null;
	private BufferedInputStream bufferedInputStream = null;
	private BufferedReader bufferedReader = null;

	private String line;
	private long position = 0;
	private String filePath = null;
	private int status = this.STOP;
	private boolean readHeader = true;

	public StructDataReader(String filePath, boolean readHeader) {
		this.filePath = filePath;
		setBufferedInputStream(filePath);
		bufferedReader = new BufferedReader(new InputStreamReader(
				bufferedInputStream), 5 * 1024 * 1024);
		this.readHeader = readHeader;
	}

	private void setBufferedInputStream(String filePath) {
		file = new File(filePath);
		bufferedInputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(
					file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getFilePath() {
		return this.filePath;
	}

	public long getPostion() {
		return this.position;
	}

	public StructDataReader setLineListener(LineListener lineListener) {
		this.lineListener = lineListener;
		return this;
	}

	public StructDataReader setStopListener(OptionListener stopOptionListener) {
		this.stopOptionListener = stopOptionListener;
		return this;
	}

	public StructDataReader read() {
		try {
			this.status = this.READING;
			while ((line = bufferedReader.readLine()) != null && this.status == READING) {
				position++;
				if (!this.readHeader && this.position == 1) {
					continue;
				}
				readLine(line);
			}
			readStop();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	public StructDataReader readBySplits(String regex) {
		try {
			this.status = this.READING;
			while ((line = bufferedReader.readLine()) != null && this.status == READING) {
				position++;
				if (!this.readHeader && this.position == 1) {
					continue;
				}
				readLineBySplits(line, regex);
			}
			readStop();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	private void readLine(String line) {
		if (this.lineListener != null) {
			this.lineListener.opt(line);
		}
	}

	private void readLineBySplits(String line, String regex) {
		if (this.lineListener != null) {
			this.lineListener.opt(line.split(regex));
		}
	}

	public void readStop() {
		if (this.stopOptionListener != null) {
			this.stopOptionListener.opt();
		}
	}

	public void close() {
		try {
			this.bufferedReader.close();
			this.bufferedInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void suspend() {
		this.status = this.SUSPEND;
	}

}
