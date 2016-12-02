package com.manageyourmoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.datastax.driver.core.utils.UUIDs;
//import com.google.common.collect.ImmutableSet;
import com.manageyourmoney.cassandra.entity.Book;
import com.manageyourmoney.cassandra.repository.BookRepository;

@Service
public class BookService {
	// @Autowired
	// private BookRepository bookRepository;
	//
	// public void saveBook() {
	// Book book = new Book(UUIDs.timeBased(), "head first java", "yahia ammar",
	// ImmutableSet.of("computer", "Software"));
	// bookRepository.save(ImmutableSet.of(book));
	// }
}
