package com.taran.solr.service;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

import com.taran.solr.model.Book;

/**
 * The Interface SolrContentQueryBuilderService.
 */
public interface SolrContentQueryBuilderService {

	/**
	 * Creates the document.
	 *
	 * @param book the book
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	void createDocument(final Book book) throws SolrServerException, IOException;

	/**
	 * Delete document.
	 *
	 * @param book the book
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	void deleteDocument(final Book book) throws SolrServerException, IOException;

	/**
	 * Delete all documents.
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	void deleteAllDocuments() throws SolrServerException, IOException;
	
	/**
	 * Query document.
	 *
	 * @param query the query
	 */
	void queryDocument(final String query);
}
