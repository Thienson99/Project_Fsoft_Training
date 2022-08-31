package fa.training.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book extends Publication {
private String isbn;
private String author;
private String publicationPlace;



public Book() {
	super();
}
public Book(int publicationYear, String publisher, Date publicationDate, String isbn, String author,
		String publicationPlace) {
	super(publicationYear, publisher, publicationDate);
	this.isbn = isbn;
	this.author = author;
	this.publicationPlace = publicationPlace;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublicationPlace() {
	return publicationPlace;
}
public void setPublicationPlace(String publicationPlace) {
	this.publicationPlace = publicationPlace;
}
@Override
public String toString() {
	return "Book [isbn=" + isbn + ", author=" + author + ", publicationPlace=" + publicationPlace + ", getIsbn()="
			+ getIsbn() + ", getAuthor()=" + getAuthor() + ", getPublicationPlace()=" + getPublicationPlace()
			+ ", getPublicationYear()=" + getPublicationYear() + ", getPublisher()=" + getPublisher()
			+ ", getPublicationDate()=" + getPublicationDate() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}

public void input() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Input author: ");
    this.setAuthor(scanner.nextLine());
    System.out.print("Input publicationPlace: ");
    this.setPublicationPlace(scanner.nextLine());
    System.out.print("Input PublicationYear: ");
    this.setPublicationYear(Integer.parseInt(scanner.nextLine()));
    System.out.print("Input Publisher: ");
    this.setPublisher(scanner.nextLine());
    System.out.print("Input Date: ");
    Pattern pattern=Pattern.compile("(([1-2][0-9])|([1-9])|(3[0-1]))/((1[0-2])|([1-9]))/[0-9]{4}");
    while(true) {
    	String dataString= scanner.nextLine();
    	Matcher matcher=pattern.matcher(dataString);
    	if(matcher.find()) {
    		SimpleDateFormat formatt=new SimpleDateFormat("dd/MM/yyyy");
    		try {
				this.setPublicationDate(formatt.parse(dataString));
			} catch (Exception e) {
				e.printStackTrace();
			}
    		break;
    	}else {
    		System.out.println("Lỗi nhập Date");
    	}
    }
   
    System.out.print("Input isbn: ");
    Pattern pattern1=Pattern.compile("((?:[\\dX]{13})|(?:[\\d\\-X]{17})|(?:[\\dX]{10})|(?:[\\d\\-X]{13}))");
    while(true) {
    	String isbnString= scanner.nextLine();
    	Matcher matcher=pattern1.matcher(isbnString);
    	if(matcher.find()) {
    		try {
				this.setIsbn(isbnString);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		break;
    	}else {
    		System.out.println("Lỗi nhập isbn");
    	}
    }
   
}
public String getWriteFile() {
	return "\n"+ this.getIsbn()+","+this.getAuthor()+","+this.getPublicationPlace()+","+this.getPublicationYear()+","+this.getPublisher()+","+this.getPublicationDate();
}
public void parse(String line) throws ParseException {
	String[] params=line.split(",");
	this.setIsbn(params[0]);
	this.setAuthor(params[1]);
	this.setPublicationPlace(params[2]);
	this.setPublicationYear(Integer.parseInt(params[3]));
	this.setPublisher(params[4]);
	SimpleDateFormat formatt=new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");
	this.setPublicationDate(formatt.parse(params[5]));

}
public void disTable() {
System.out.format(" %20s|%20s|%20s|%20s|%20s|%30s|\n", this.getIsbn(),this.getAuthor(),this.getPublicationPlace(),this.getPublicationYear(),this.getPublisher(),this.getPublicationDate());
}
}
