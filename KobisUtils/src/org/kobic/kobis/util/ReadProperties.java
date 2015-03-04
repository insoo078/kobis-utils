package org.kobic.kobis.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadProperties {
	public Properties readProperties( String filename ) throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
			pro.load(new InputStreamReader(fis));
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				fis.close();
			} catch (IOException e) { 
				throw e;
			}
		}
		return pro;
	} 
}