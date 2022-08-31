package fa.training.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


import fa.training.entities.Magazine;

public class MagazineService {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Magazine> magazines = new ArrayList<>();
	

public static void addMagazineToList() {
	System.out.println("Nhập số magazine cần nhập");
	int n = scanner.nextInt();
	for (int i = 0; i < n; i++) {
		Magazine magazine = new Magazine();
		magazine.input();
		magazines.add(magazine);
	}
}

public static ArrayList<Magazine> getListMagazine(){
	return magazines;
}

public static void chooseTop10Volumn() {
	SortVolumn();
	for(int i = 0; i < 10; i++) {
		if(i < magazines.size()) {
			System.out.println(magazines.get(i));
		}else {
			
		}
	}
}

public static void SortVolumn() {
	  Collections.sort(magazines, new Comparator<Magazine>() {
          @Override
          public int compare(Magazine o1, Magazine o2) {
              return o1.getVolumn() < o2.getVolumn() ? 1:-1;
          }
      });
}
}