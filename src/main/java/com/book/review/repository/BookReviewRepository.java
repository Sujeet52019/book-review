package com.book.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.review.entity.BookReview;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer>{

	List<BookReview> findAllByInfoId(int infoId);

}
