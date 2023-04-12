package com.springbootbackendapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.springbootbackendapp.dto.reqestDto.UpdateCategoryRequestDto;
import com.springbootbackendapp.dto.responseDto.AuthorResponseDto;
import com.springbootbackendapp.dto.responseDto.BookResponseDto;
import com.springbootbackendapp.dto.responseDto.UpdateCategoryResponseDto;
import com.springbootbackendapp.model.Author;
import com.springbootbackendapp.model.Book;
import com.springbootbackendapp.model.UpdateCategory;

public class Mapper {

	// Book Mapper
	public static BookResponseDto bookToBookResponseDto(Book book) {
		BookResponseDto bookResponseDto = new BookResponseDto();
		bookResponseDto.setId(book.getId());
		bookResponseDto.setCategoryName(book.getCategory().getName());
		List<String> names = new ArrayList<>();
		List<Author> authors = book.getAuthors();
		for (Author author : authors) {
			names.add(author.getName());
		}
		bookResponseDto.setAuthorNames(names);
		return bookResponseDto;
	}

	public static List<BookResponseDto> bookToBookResponseDtos(List<Book> books) {
		List<BookResponseDto> bookResponseDtos = new ArrayList<>();
		for (Book book : books) {
			bookResponseDtos.add(bookToBookResponseDto(book));
		}

		return bookResponseDtos;
	}

	// Author Mapper
	public static AuthorResponseDto authorToAuthorResponseDto(Author author) {
		AuthorResponseDto authorResponseDto = new AuthorResponseDto();

		authorResponseDto.setId(author.getId());
		authorResponseDto.setName(author.getName());
		List<String> names = new ArrayList<>();
		List<Book> books = author.getBooks();

		for (Book book : books) {
			names.add(book.getName());
		}

		authorResponseDto.setBookNames(names);
		return authorResponseDto;
	}

	public static List<AuthorResponseDto> authorToAuthorResponseDtos(List<Author> authors) {
		List<AuthorResponseDto> authorResponseDto = new ArrayList<>();

		for (Author author : authors) {
			authorResponseDto.add(authorToAuthorResponseDto(author));
		}
		return authorResponseDto;
	}

	// Category Mapper
	public static UpdateCategoryResponseDto categoryToCategoryResponseDto(UpdateCategory category) {
		UpdateCategoryResponseDto categoryResponseDto = new UpdateCategoryResponseDto();
		categoryResponseDto.setId(category.getId());
		categoryResponseDto.setName(category.getName());
		List<String> names = new ArrayList<>();
		List<Book> books = category.getBooks();
		for (Book book : books) {
			names.add(book.getName());
		}

		categoryResponseDto.setBookNames(names);
		return categoryResponseDto;
	}

	public static List<UpdateCategoryResponseDto> categoryToCategoryDtos(List<UpdateCategory> categories) {
		List<UpdateCategoryResponseDto> categoryResponseDto = new ArrayList<>();
		for (UpdateCategory category : categories) {
			categoryResponseDto.add(categoryToCategoryResponseDto(category));
		}

		return categoryResponseDto;
	}
}
