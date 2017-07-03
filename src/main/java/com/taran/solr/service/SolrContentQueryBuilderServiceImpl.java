package com.taran.solr.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import com.taran.solr.SolrConstants;
import com.taran.solr.model.Book;

/**
 * This class is used to build the solr content.
 * 
 * @author Taran
 */
public class SolrContentQueryBuilderServiceImpl implements SolrContentQueryBuilderService {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(SolrContentQueryBuilderService.class);

	/** The solr client. */
	private SolrClient solrClient;

	/**
	 * Instantiates a new solr content query builder service.
	 *
	 * @param client
	 *            the client
	 */
	public SolrContentQueryBuilderServiceImpl(final SolrClient client) {
		// this.solrClient = client;
		this.solrClient = new HttpSolrClient.Builder(SolrConstants.SOLR_URL + SolrConstants.CORE_NAME).build();
	}

	/* (non-Javadoc)
	 * @see com.taran.solr.service.SolrContentQueryBuilderService#createDocument(com.taran.solr.model.Book)
	 */
	public void createDocument(final Book book) throws SolrServerException, IOException {
		LOGGER.info("Adding document");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("cat", book.getCategory());
		document.addField("name", book.getName());
		document.addField("price", book.getPrice().toString());
		document.addField("inStock", String.valueOf(book.isInStock()));
		solrClient.add(document);
		solrClient.commit();
	}

	/* (non-Javadoc)
	 * @see com.taran.solr.service.SolrContentQueryBuilderService#deleteDocument(com.taran.solr.model.Book)
	 */
	public void deleteDocument(final Book book) throws SolrServerException, IOException {
		LOGGER.info("Deleting document");
		StringBuilder query = new StringBuilder().append("name :").append(book.getName());
		solrClient.deleteByQuery(query.toString());
	}

	/* (non-Javadoc)
	 * @see com.taran.solr.service.SolrContentQueryBuilderService#deleteAllDocuments()
	 */
	public void deleteAllDocuments() throws SolrServerException, IOException {
		LOGGER.info("Flushing All documents");
		solrClient.deleteByQuery("name : *");
		solrClient.commit();
	}

	/* (non-Javadoc)
	 * @see com.taran.solr.service.SolrContentQueryBuilderService#queryDocument(java.lang.String)
	 */
	public void queryDocument(String query) {
	}

}
