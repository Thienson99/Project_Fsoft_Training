package fa.training.main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import fa.training.entities.Book;

import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;

public class LibraryManagement {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {

		int choose;
		do {
			showMenu();
			choose = Integer.parseInt(scanner.nextLine());
			switch (choose) {
			case 1:
				BookService.addBookToList();
				break;
			case 2:
				MagazineService.addMagazineToList();
				break;
			case 3:
				for (Book Ex : BookService.getListBook()) {
					for (Magazine mg : MagazineService.getListMagazine())
						if (Ex.getPublicationYear() == mg.getPublicationYear()
								|| Ex.getPublisher().equals(mg.getPublisher())) {
							System.out.println(Ex);
							System.out.println(mg);
						}
				}
				break;
			case 4:
				BookService.addBook();
				break;
			case 5:
				MagazineService.chooseTop10Volumn();
				break;
			case 6:
				BookService.searchBook();
				break;
			case 0:
				System.out.println("exited!");
				break;
			}
		} while (choose != 0);
	}

	public static void showMenu() {
		System.out.println("\n-----------menu------------");
		System.out.println("1. Add Book.");
		System.out.println("2. Add Magazine.");
		System.out.println("3. Show Mazigane Book.");
		System.out.println("4. Edit Book.");
		System.out.println("5. Show list of top 10.");
		System.out.println("6. Search.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}

}
