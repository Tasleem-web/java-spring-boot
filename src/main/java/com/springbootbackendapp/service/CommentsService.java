package com.springbootbackendapp.service;

import com.springbootbackendapp.model.Comments;
import com.springbootbackendapp.model.Post;

public interface CommentsService {

	Comments createComment(Integer commentId, Integer postId);

	void deleteComment(Comments commentId);
}
