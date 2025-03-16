package application;

import java.util.List;

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
		
		for(Seller s : list) System.out.println(s);
	}

}
