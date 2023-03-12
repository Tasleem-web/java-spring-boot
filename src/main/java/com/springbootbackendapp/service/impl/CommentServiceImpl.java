package com.springbootbackendapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.Comments;
import com.springbootbackendapp.model.Post;
import com.springbootbackendapp.repository.CommentsRepository;
import com.springbootbackendapp.repository.PostRepository;
import com.springbootbackendapp.service.CommentsService;

public class CommentServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void deleteComment(Comments commentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comments createComment(Integer commentId, Integer postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));

		Comments comment = commentsRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "comment Id", commentId));

		commentsRepository.save(comment);
		return comment;
	}

}
