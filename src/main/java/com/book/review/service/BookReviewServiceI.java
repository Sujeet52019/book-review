package com.book.review.service;

import java.util.List;

import com.book.review.entity.BookReview;

public interface BookReviewServiceI {

	BookReview addBookReview(BookReview bookReview);

	List<BookReview> getAllBookInfos();

	BookReview getBookReviewsById(int id);

	BookReview modifyBookReview(int id, BookReview bookReview);

	void deleteBookReview(int id);

	List<BookReview> getAllBookReviewsByInfoId(int infoId);

}
