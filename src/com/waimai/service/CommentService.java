package com.waimai.service;

import java.util.List;

import com.waimai.dao.CommentDao;
import com.waimai.entity.Comment;

public class CommentService {
	private CommentDao commentDao;
	
	
	public CommentService() {
		super();
		this.commentDao = new CommentDao();
	}

	public List<Comment> showCommentByProductId(String productId) throws Exception{
		return commentDao.showCommentByProductId(productId);
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	

}
