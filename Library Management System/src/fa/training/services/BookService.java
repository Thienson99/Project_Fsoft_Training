package fa.training.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import fa.training.entities.Book;
import fa.training.entities.Magazine;

public class BookService {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Book> books = new ArrayList<>();

	public static void addBookToList() {
		System.out.println("Nhập số book cần nhập");
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			Book book = new Book();
			book.input();
			books.add(book);
		}
	}

	public static ArrayList<Book>getListBook(){
		return books;
	}

	public static void addBook() {
			System.out.print("Nhap isbn: ");
			String isbn = scanner.nextLine();
			for (Book Ex : books) {
			if (Ex.getIsbn().equals(isbn)) {
				if (Ex.getAuthor() == null) {
					System.out.print("Add successfully");
				} else {
					System.out.print("Đã tồn tại tác giả ");
				}
			}
		}

	}
	
	public static void searchBook() {
		int choose;
		do {
			showMenu();
			choose = Integer.parseInt(scanner.nextLine());
			switch (choose) {
			case 1:
				System.out.print("Nhap isbn: ");
				String isbn = scanner.nextLine();
				SortIsbn();
				for (Book Ex : books) {
					SortDate();
				if (Ex.getIsbn().equals(isbn)) {	
					System.out.println(Ex);
				}
			}
				break;
			case 2:
				System.out.print("Nhap author: ");
				String author = scanner.nextLine();
				SortIsbn();
				for (Book Ex : books) {
					SortDate();
				if (Ex.getAuthor().equals(author)) {	
					System.out.println(Ex);
				}
			}
				break;
			case 3:
				System.out.print("Nhap publisher: ");
				String publisher = scanner.nextLine();
				SortIsbn();
				for (Book Ex : books) {
					SortDate();
				if (Ex.getPublisher().equals(publisher)) {	
					System.out.println(Ex);
				}
			}
				break;
				
			case 0:
				System.out.println("exited!");
				break;
			}
		} while (choose != 0);
	}

	public static void showMenu() {
		System.out.println("-----------menu------------");
		System.out.println("1. Search isbn.");
		System.out.println("2. Search author");
		System.out.println("3. Search publisher");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	
	}
	public static void SortIsbn() {
		  Collections.sort(books, new Comparator<Book>() {
	          @Override
	          public int compare(Book o1, Book o2) {
	              return o1.getIsbn().compareTo(o2.getIsbn());
	          }
	      });
	}
	public static void SortDate() {
		  Collections.sort(books, new Comparator<Book>() {
	          @Override
	          public int compare(Book o1, Book o2) {
	              return o1.getPublicationDate().compareTo(o2.getPublicationDate());
	          }
	      });
	}
}
