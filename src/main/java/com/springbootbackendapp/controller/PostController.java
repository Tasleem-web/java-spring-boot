package com.springbootbackendapp.controller;

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

import com.springbootbackendapp.dto.ApiResponse;
import com.springbootbackendapp.model.Post;
import com.springbootbackendapp.service.PostService;

@RestController
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId) {

		return new ResponseEntity<Post>(postService.createPost(post, userId, categoryId), HttpStatus.CREATED);
	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<Post>> getPostByUser(@PathVariable Integer userId) {
		return new ResponseEntity<List<Post>>(postService.getPostByUser(userId), HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<Post>> getPostByCategory(@PathVariable Integer categoryId) {
		return new ResponseEntity<List<Post>>(postService.getPostByCategory(categoryId), HttpStatus.OK);
	}

	@PutMapping("/post/{postId}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable Integer postId) {
		return new ResponseEntity<Post>(postService.updatePost(post, postId), HttpStatus.OK);
	}

	@DeleteMapping("/post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Post " + postId + " is deleted!."),
				HttpStatus.OK);
	}

	@GetMapping("/post/{postId}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
		return new ResponseEntity<Post>(postService.getPostById(postId), HttpStatus.OK);
	}

	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<Post>> searchPosts(@PathVariable("keyword") String keyword) {
		return new ResponseEntity<List<Post>>(postService.searchPosts(keyword), HttpStatus.OK);
	}

}
