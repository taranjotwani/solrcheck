package com.taran.solr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServerException;

import com.taran.solr.model.Book;
import com.taran.solr.service.SolrContentQueryBuilderService;
import com.taran.solr.service.SolrContentQueryBuilderServiceImpl;

/**
 * The Class App.
 */
public class App {

	/** The logger. */
	private Logger LOGGER = Logger.getLogger(App.class);

	/** The service. */
	private static SolrContentQueryBuilderService service;

	/**
	 * Inits the application.
	 *
	 * @throws SolrServerException
	 *             the solr server exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void init() throws SolrServerException, IOException {
		LOGGER.info("Deleting all documents....");
		service.deleteAllDocuments();
		loadAllBooks();

	}

	/**
	 * Load all books.
	 */
	private void loadAllBooks() {
		LOGGER.info("Loading Books");
		BufferedReader reader = null;
		File file = new File("./books.csv");
		try {
			FileReader fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				String[] bookArr = currentLine.split(",");
				Book book = new Book(bookArr[0], bookArr[1], Double.valueOf(bookArr[2]), Boolean.valueOf(bookArr[3]),
						bookArr[4]);
				service.createDocument(book);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				LOGGER.info("Books loaded Successfully.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		App app = new App();
		service = new SolrContentQueryBuilderServiceImpl(null);
		try {
			app.init();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
