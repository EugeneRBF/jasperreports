package net.sf.jasperreports.engine;

/**
 * This interface represents a data source which can detect total size of dataset.
 * Created by teo on 05.11.18.
 *
 */
public interface JRCountableDataSource extends JRRewindableDataSource {
	int getRecordCount();
}
