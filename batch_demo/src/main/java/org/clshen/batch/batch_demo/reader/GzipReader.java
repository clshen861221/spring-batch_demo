package org.clshen.batch.batch_demo.reader;

import org.clshen.batch.batch_demo.entity.Person;
import org.springframework.batch.item.file.FlatFileItemReader;

public class GzipReader<T> extends FlatFileItemReader<Person> {
	private boolean isGzip;

	public boolean isGzip() {
		return isGzip;
	}

	public void setGzip(boolean isGzip) {
		this.isGzip = isGzip;
	}

	public String ungzip(String path) {
		if (isGzip) {
			// TODO ungzip and get the new path to return
		}
		return path;
	}
}
