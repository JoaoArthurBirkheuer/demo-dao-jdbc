package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("TESTE 1 : seller findById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTESTE 2 : seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		List<Seller> list2 = sellerDao.findAll();
		
		for(Seller s : list) System.out.println(s);
		System.out.println("\nTESTE 3 : seller findAll");
		for(Seller s : list2) System.out.println(s);
		
		System.out.println("\nTESTE 4 : seller insert");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(), 4000.0, department);
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID = " + newSeller.getId());
		
		System.out.println("\nTESTE 5 : seller update");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		System.out.println("\nTESTE 6 : seller delete\nEnter id: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		sc.close();
		System.out.println("Deletion complete");
	}

}
