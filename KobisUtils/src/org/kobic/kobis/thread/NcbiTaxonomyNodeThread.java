package org.kobic.kobis.thread;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class NcbiTaxonomyNodeThread extends FileThread implements Runnable{
	private Map<String, Map<String, String>> map;

	public NcbiTaxonomyNodeThread(String filename, String serviceName, CountDownLatch latch) {
		super(filename, serviceName, latch);
		// TODO Auto-generated constructor stub
		this.map = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Reading " + this.get_serviceName() + " map....");
			FileInputStream fin = new FileInputStream( this.getFilename() );
			ObjectInputStream ois = new ObjectInputStream( fin );
			long start = System.currentTimeMillis();
			this.map = (Map<String, Map<String, String>>) ois.readObject();
			long end = System.currentTimeMillis();
			
			System.out.println( this.get_serviceName() + " : " + ((double)(end-start)/1000) + "sec");
			this.set_serviceUp( true );
			ois.close();
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
			this.set_serviceUp( false );
			
		}finally{
			if(this.get_latch() != null) {
                this.get_latch().countDown();
            }
		}
	}

	public Map<String, Map<String, String>> getMap() {
		return map;
	}
}
