package com.exa.exat;

import com.exa.buffer.ReadingBuffer;
import com.exa.utils.ManagedException;

public abstract class OutputMan {
	//protected Charset charset;
	
	/*public OutputMan(Charset charset) {
		this.charset = charset;
	}*/

	public abstract void open() throws ManagedException;
	
	public abstract void close() throws ManagedException;
	
	public abstract void write(String data) throws ManagedException;
	
	public abstract ReadingBuffer result() throws ManagedException;

}
