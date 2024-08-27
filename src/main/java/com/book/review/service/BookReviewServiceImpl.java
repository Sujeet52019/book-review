package com.book.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.review.entity.BookReview;
import com.book.review.repository.BookReviewRepository;

@Service
public class BookReviewServiceImpl implements BookReviewServiceI{

	@Autowired
	private BookReviewRepository bookReviewRepository;
	
	@Override
	public BookReview addBookReview(BookReview bookReview) {
		
		return bookReviewRepository.save(bookReview);
	}

	@Override
	public List<BookReview> getAllBookInfos() {
		// TODO Auto-generated method stub
		return bookReviewRepository.findAll();
	}

	@Override
	public BookReview getBookReviewsById(int id) {
		// TODO Auto-generated method stub
		return bookReviewRepository.findById(id).orElse(null);
	}

	@Override
	public BookReview modifyBookReview(int id, BookReview bookReview) {
		BookReview oldBookReview = bookReviewRepository.findById(id).get();
		
		oldBookReview.setInfoId(bookReview.getInfoId());
		oldBookReview.setReviewComment(bookReview.getReviewComment());
		oldBookReview.setReviewer(bookReview.getReviewer());
		oldBookReview.setReviewPoint(bookReview.getReviewPoint());
		return bookReviewRepository.save(oldBookReview);
	}

	@Override
	public void deleteBookReview(int id) {
		// TODO Auto-generated method stub
		bookReviewRepository.deleteById(id);
	}

	@Override
	public List<BookReview> getAllBookReviewsByInfoId(int infoId) {
		// TODO Auto-generated method stub
		return bookReviewRepository.findAllByInfoId(infoId);
	}

}
