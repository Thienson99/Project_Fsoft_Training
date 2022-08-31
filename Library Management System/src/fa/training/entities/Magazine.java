package fa.training.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Magazine extends Publication {
private String author;
private int volumn;
private int edition;


@Override
public String toString() {
	return "Magazine [author=" + author + ", volumn=" + volumn + ", edition=" + edition + ", getAuthor()=" + getAuthor()
			+ ", getVolumn()=" + getVolumn() + ", getEdition()=" + getEdition() + ", getPublicationYear()="
			+ getPublicationYear() + ", getPublisher()=" + getPublisher() + ", getPublicationDate()="
			+ getPublicationDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
public Magazine() {
	super();
}
public Magazine(int publicationYear, String publisher, Date publicationDate, String author, int volumn, int edition) {
	super(publicationYear, publisher, publicationDate);
	this.author = author;
	this.volumn = volumn;
	this.edition = edition;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getVolumn() {
	return volumn;
}
public void setVolumn(int volumn) {
	this.volumn = volumn;
}
public int getEdition() {
	return edition;
}
public void setEdition(int edition) {
	this.edition = edition;
}
public void input() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Input author: ");
    this.setAuthor(scanner.nextLine());
    System.out.print("Input Volumn: ");
    this.setVolumn(scanner.nextInt());
    System.out.print("Input Edition: ");
    this.setEdition(scanner.nextInt());
    System.out.print("Input PublicationYear: ");
    this.setPublicationYear(scanner.nextInt());
    System.out.print("Input Publisher: ");
    scanner.nextLine();
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
   
   
   
}
public String getWriteFile() {
	return "\n"+this.getAuthor()+","+this.getEdition()+","+this.getPublicationYear()+","+this.getPublisher()+","+this.getVolumn()+","+this.getPublicationDate();
}
public void parse(String line) throws ParseException {
	String[] params=line.split(",");
	this.setAuthor(params[1]);
	this.setEdition(Integer.parseInt(params[3]));
	this.setPublicationYear(Integer.parseInt(params[3]));
	this.setPublisher(params[4]);
	this.setVolumn(Integer.parseInt(params[3]));
	SimpleDateFormat formatt=new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");
	this.setPublicationDate(formatt.parse(params[5]));
}
public void disTable() {
System.out.format(" %20s|%20s|%20s|%20s|%20s|%20s|\n", this.getAuthor(),this.getEdition(),this.getPublicationYear(),this.getPublisher(),this.getVolumn(),this.getPublicationDate());
}
}
