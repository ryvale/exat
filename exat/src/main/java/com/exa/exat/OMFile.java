package com.exa.exat;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.exa.buffer.RBMappedFile;
import com.exa.buffer.ReadingBuffer;
import com.exa.chars.ByteCharDecoder;
import com.exa.utils.ManagedException;

public class OMFile extends OutputMan {
	public static final int DEFAULT_BUFFER_SIZE = 4*1024;
	
	protected String outputFile;
	protected Charset charset;
	public boolean includeBOM;
	protected int bufferSize;
	private RandomAccessFile file;
	private int start;
	
	public OMFile(String outputFile, int bufferSize, Charset charset, boolean includeBOM) {
		this.outputFile = outputFile;
		this.charset = charset;
		this.includeBOM = includeBOM;
		this.bufferSize = bufferSize;
	}
	
	public OMFile(String outputFile, Charset charset, boolean includeBOM) {
		this(outputFile, DEFAULT_BUFFER_SIZE, charset, includeBOM);
	}
	
	public OMFile(String outputFile) {
		this(outputFile, DEFAULT_BUFFER_SIZE, StandardCharsets.UTF_8, false);
	}
	
	public void open() throws ManagedException {
		try {
		file = new RandomAccessFile(outputFile, "rw");
		
		if(includeBOM) {
			byte[] bomBytes = ByteCharDecoder.bom(charset);
			if(bomBytes != null) {
				start = bomBytes.length;
				file.write(bomBytes);
				
				return;
			}
		}
		} catch(IOException e) { throw new ManagedException(e); }
		
		start = 0;
	}
	
	public void close() throws ManagedException {
		try {
			file.close();
		} catch (IOException e) {
			throw new ManagedException(e);
		}
	}
	
	
	@Override
	public void write(String data) throws ManagedException {
		ByteBuffer bb = charset.encode(data);
		
		byte[] b = new byte[bb.limit()];
		bb.get(b);
		
		try {
			file.write(b);
		} catch (IOException e) {
			throw new ManagedException(e);
		}
		
	}

	@Override
	public ReadingBuffer result() throws ManagedException  {
		try {
			return new RBMappedFile(file, start, charset, false);
		} catch (IOException e) {
			throw new ManagedException(e);
		}
	}
	
}
