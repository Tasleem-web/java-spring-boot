package com.springbootbackendapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springbootbackendapp.config.AppConstants;
import com.springbootbackendapp.dto.ApiResponse;
import com.springbootbackendapp.dto.PostResponse;
import com.springbootbackendapp.model.Post;
import com.springbootbackendapp.service.FileService;
import com.springbootbackendapp.service.PostService;
import org.springframework.util.StreamUtils;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId) {

		return new ResponseEntity<Post>(postService.createPost(post, userId, categoryId), HttpStatus.CREATED);
	}

	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		return new ResponseEntity<PostResponse>(postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir),
				HttpStatus.OK);
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

//	post image upload
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<Post> uploadPostImage(@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException {
		Post post = this.postService.getPostById(postId);
		String fileName = this.fileService.uploadImage(path, image);
		post.setImageName(fileName);
		Post updatePost = this.postService.updatePost(post, postId);

		return new ResponseEntity<Post>(updatePost, HttpStatus.OK);
	}

//	get files
	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response)
			throws IOException {
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
}
