package org.kobic.kobis.thread;

import java.io.ObjectInputStream;
import java.util.concurrent.CountDownLatch;

public abstract class FileThread{
	private String filename;
	
	private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;

	public FileThread( String filename, String serviceName, CountDownLatch latch ) {
		this._latch = latch;
		this.filename = filename;
		this._serviceName = serviceName;
		this._serviceUp = false;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public CountDownLatch get_latch() {
		return _latch;
	}

	public void set_latch(CountDownLatch _latch) {
		this._latch = _latch;
	}

	public String get_serviceName() {
		return _serviceName;
	}

	public void set_serviceName(String _serviceName) {
		this._serviceName = _serviceName;
	}

	public boolean is_serviceUp() {
		return _serviceUp;
	}

	public void set_serviceUp(boolean _serviceUp) {
		this._serviceUp = _serviceUp;
	}
}
