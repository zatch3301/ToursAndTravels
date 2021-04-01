package com.zatch.toursandtravels.dao;

import java.util.List;

import com.zatch.toursandtravels.pojo.Package;
//Dao 
public interface PackageDao 
{
	boolean addPackage(Package pkg);
	boolean updatePackage(Package pkg);
	boolean deletePackage(int packageId);
	
	List<Package> showAllPackage();
	Package getPackageById(int packageId);
	List<Package> getPackageByLocation(String packageLocation);

	List<Package> sortById();
	List<Package> sortByName();

	// IF you need any extra feature in you project 
	// we can add that method here.
	
}
