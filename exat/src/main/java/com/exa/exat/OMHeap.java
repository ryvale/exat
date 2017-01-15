package com.exa.exat;

import com.exa.buffer.RBRAM;
import com.exa.buffer.ReadingBuffer;

public class OMHeap extends OutputMan {
	//public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	protected StringBuilder buffer;
	
	public OMHeap(StringBuilder buffer) {
		//super(charset);
		this.buffer = buffer;
	}
	
	/*public OMHeap(StringBuilder buffer) {
		this(buffer, DEFAULT_CHARSET);
	}*/
	
	public OMHeap() { this(new StringBuilder()/*, DEFAULT_CHARSET*/); }

	@Override
	public void open() {
		// TODO Auto-generated method stub
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(String data) {
		buffer.append(data);
	}

	@Override
	public ReadingBuffer result() {
		return new RBRAM(buffer.toString()); //charset.encode(buffer.toString());
	}
	
}
