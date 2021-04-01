package com.zatch.toursandtravels.utility;

import java.util.Comparator;

import com.zatch.toursandtravels.pojo.Customer;
import com.zatch.toursandtravels.pojo.Package;
public class SortPackageByName implements Comparator<Package>{

	@Override
	public int compare(Package pkg1, Package pkg2) {
		// TODO Auto-generated method stub
		return pkg1.getPackageName().compareToIgnoreCase(pkg2.getPackageName());
	}
	

}
