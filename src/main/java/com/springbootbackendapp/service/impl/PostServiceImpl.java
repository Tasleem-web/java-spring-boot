package com.springbootbackendapp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.Category;
import com.springbootbackendapp.model.Post;
import com.springbootbackendapp.model.User;
import com.springbootbackendapp.repository.CategoryRepository;
import com.springbootbackendapp.repository.PostRepository;
import com.springbootbackendapp.repository.UserRepository;
import com.springbootbackendapp.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Post createPost(Post post, Integer userId, Integer categoryId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User ", "user id", userId));
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category ", "categoryid", categoryId));

		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);

		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		List<Post> posts = postRepository.findByUser(user);
		return posts;
	}

	@Override
	public List<Post> getPostByCategory(Integer categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category ID", categoryId));
		List<Post> posts = postRepository.findByCategory(category);
		return posts;
	}

	@Override
	public Post updatePost(Post post, Integer postId) {
		Post existingPost = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		existingPost.setTitle(post.getTitle());
		existingPost.setContent(post.getContent());
		postRepository.save(existingPost);
		return existingPost;

	}

	@Override
	public void deletePost(Integer id) {
		postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", id));
		postRepository.deleteById(id);
	}

	@Override
	public Post getPostById(Integer id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", id));
		return post;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		return postRepository.searchPosts("%" + keyword + "%");
	}

}
