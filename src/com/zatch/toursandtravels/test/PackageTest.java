package com.zatch.toursandtravels.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.zatch.toursandtravels.dao.PackageDao;
import com.zatch.toursandtravels.dao.impl.PackageDaoImpl;
import com.zatch.toursandtravels.pojo.Package;

public class PackageTest 
{
	public static void main(String[] args) 
	{
		int choice=0;
		Scanner sc = new Scanner(System.in);
		String packageName, packageLocation, packageType, packageDetails;
		int packageDays, packageId;
		double packagePrice;
		
		
		Package pkg = null; 
		PackageDao packageDao = new PackageDaoImpl();// it will use to call all
		// implemented methods.
		
		boolean flag;
		
		List<Package> packageList = null;
		
		do {
			sc = new Scanner(System.in);
			System.out.println("----------------- Tours Package Testing ------------------");
			System.out.println("___1.Add Package ");
			System.out.println("___2.Show Packages ");
			System.out.println("___3.Update Packages ");
			System.out.println("___4.Delete Packages ");
			System.out.println("___5.Show Packages By PackageID");
			System.out.println("___6.Show Packages By Location");
			System.out.println("___7.Sort Packages By PackageId");
			System.out.println("___8.Sort Packages By PackageName");
			System.out.println("___9.Exit");
			try 
			{
				System.out.println("Enter your Choice");
				choice = sc.nextInt(); // to handle this 
				// enter call blank nextLine method.
				sc.nextLine();
				
				switch(choice)
				{
				case 1:
					System.out.println("Enter The New Package Details");
					System.out.println("Name:- ");
					packageName = sc.nextLine();
					System.out.println("Location:- ");
					packageLocation = sc.nextLine();
					System.out.println("Type:- ");
					packageType = sc.nextLine();
					System.out.println("Days:- ");
					packageDays = sc.nextInt();
					System.out.println("Price:- ");
					packagePrice = sc.nextDouble();
					sc.nextLine(); // it will handle the enter double method.
					System.out.println("Details:- ");
					packageDetails = sc.nextLine();
					
//					pkg = new com.zatch.toursandtravels.pojo.Package(packageName, packageLocation, packageType, packageDays, packagePrice, packageDetails);
					
					flag = packageDao.addPackage(pkg);
					if(flag)
						System.out.println("Package Added Successfully.");
					else
						System.out.println("Package is Not Added");					
					break;
				case 2:
						packageList = packageDao.showAllPackage();
						if(packageList!=null && !packageList.isEmpty())
						{
							System.out.println("------------------------Package List----------------------");
							for (Package pack : packageList) 
							{
								System.out.println(pack);
							}
							System.out.println("______________________________________________________");
						}else
							System.out.println("No Packages Found.");
						
					break;
				case 3:
					System.out.println("Enter the Id to be updated");
					packageId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter The New Package Details");
					System.out.println("Name:- ");
					packageName = sc.nextLine();
					System.out.println("Location:- ");
					packageLocation = sc.nextLine();
					System.out.println("Type:- ");
					packageType = sc.nextLine();
					System.out.println("Days:- ");
					packageDays = sc.nextInt();
					System.out.println("Price:- ");
					packagePrice = sc.nextDouble();
					sc.nextLine(); // it will handle the enter double method.
					System.out.println("Details:- ");
					packageDetails = sc.nextLine();
					
					pkg = new com.zatch.toursandtravels.pojo.Package(packageId, packageName, packageLocation, packageType, packageDays, packagePrice, packageDetails);
					
					flag = packageDao.updatePackage(pkg);
					if(flag)
						System.out.println("Package Updated Successfully.");
					else
						System.out.println("Package is Not Updated");		
					break;
				case 4:
					System.out.println("Enter the ID to be deleted");
					packageId = sc.nextInt();
					flag = packageDao.deletePackage(packageId);
					if(flag)
						System.out.println("Delete Success");
					else
						System.out.println("Fail");
					break;
				case 5:
					System.out.println("Enter the packageId to be shown");
					packageId = sc.nextInt();
					pkg = packageDao.getPackageById(packageId);
					if(pkg != null && pkg.getPackageId() != 0)
						System.out.println(pkg);
					else
						System.out.println("Fail Package Not Found");
					break;
				case 6:
					System.out.println("Enter the packageLocation to be shown");
					packageLocation = sc.next();
					packageList = packageDao.getPackageByLocation(packageLocation);
					if(packageList != null && !packageList.isEmpty()) {
						System.out.println("______________________________");
						for (Package package1 : packageList) {
							System.out.println(package1);
						}
						System.out.println("_______________________________");
					}
					else
						System.out.println("NO Package Found");
					break;
				case 7:
					System.out.println("Package sorted by ID");
					packageList = packageDao.sortById();
					if(packageList != null && !packageList.isEmpty()) {
						System.out.println("__________________________________");
						for (Iterator<Package> iterator = packageList.iterator(); iterator.hasNext();) {
							Package package1 = (Package) iterator.next();
							System.out.println(package1);
						}
						System.out.println("____________________________________");
					}
					else
						System.out.println("Fail");
					break;
				case 8:
					System.out.println("Package sorted by Name");
					packageList = packageDao.sortByName();
					if(packageList != null && !packageList.isEmpty()) {
						System.out.println("__________________________________");
						for (Package package1 : packageList) {
							System.out.println(package1);
						}
						System.out.println("____________________________________");
					}
					else
						System.out.println("Fail");
					break;
				case 9:
					System.out.println("Thank You ^^");
					break;
				default:
					System.out.println("Invalid Choice");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}while(choice!=9);
		sc.close();
	}
}
