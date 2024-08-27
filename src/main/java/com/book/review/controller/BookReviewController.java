package com.book.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.review.entity.BookReview;
import com.book.review.exception.BookReviewException;
import com.book.review.service.BookReviewServiceI;

@RestController
@RequestMapping("/v1")
public class BookReviewController {

	@Autowired
	private BookReviewServiceI bookReviewService;
	
	@GetMapping("/book-review")
	public ResponseEntity<List<BookReview>> getAllBookReviews(){
		
		return new ResponseEntity<List<BookReview>>( bookReviewService.getAllBookInfos(), HttpStatus.OK);
	}
	
	@GetMapping("/book-review/{id}")
	public ResponseEntity<Object> getBookReviewsById(@PathVariable("id") int id){
		BookReview bookReview = bookReviewService.getBookReviewsById(id);
		if(bookReview != null) {
			return new ResponseEntity<Object>( bookReview, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>( new BookReviewException("No book available for id :"+id), HttpStatus.OK);
		}
	}
	
	@PostMapping("/book-review")
	public ResponseEntity<BookReview> addBookReview(@RequestBody BookReview bookReview){
		
		return new ResponseEntity<BookReview>(bookReviewService.addBookReview(bookReview), HttpStatus.CREATED);
	}
	
	@PutMapping("/book-review/{id}")
	public ResponseEntity<BookReview> modifyBookReview(
			@PathVariable("id") int id,
			@RequestBody BookReview bookReview){
		
		return new ResponseEntity<BookReview>(bookReviewService.modifyBookReview(id, bookReview), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/book-review/{id}")
	public ResponseEntity<Void> deleteBookReview(@PathVariable("id") int id){
		bookReviewService.deleteBookReview(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/book-review/info/{info-id}")
	public ResponseEntity<List<BookReview>> getAllBookReviewsByInfoId(@PathVariable("info-id") int infoId){
		
		return new ResponseEntity<List<BookReview>>( bookReviewService.getAllBookReviewsByInfoId(infoId), HttpStatus.OK);
	}
}
