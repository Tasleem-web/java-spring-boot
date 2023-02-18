package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.model.Post;

public interface PostService {

//	create
	Post createPost(Post post, Integer userId, Integer categoryId);

//	get all
	List<Post> getAllPosts();

	// get all post by user
	List<Post> getPostByUser(Integer userId);

//	get all post by category
	List<Post> getPostByCategory(Integer categoryId);

// update
	Post updatePost(Post post, Integer postId);

//	delete
	void deletePost(Integer postId);

//	get post by id
	Post getPostById(Integer postId);

	List<Post> searchPosts(String keyword);

}
