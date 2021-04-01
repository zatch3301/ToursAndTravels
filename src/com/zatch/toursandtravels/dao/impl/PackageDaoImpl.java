package com.zatch.toursandtravels.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zatch.toursandtravels.dao.PackageDao;
import com.zatch.toursandtravels.pojo.Package;
import com.zatch.toursandtravels.utility.DBConnection;
import com.zatch.toursandtravels.utility.SortPackageByName;

import java.sql.*
;
public class PackageDaoImpl implements PackageDao 
{
	Connection con = DBConnection.getCon();
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String sqlQuery;
	
	

	@Override
	public boolean addPackage(Package pkg) 
	{
		sqlQuery = "insert into package_zatch(packageName, packageLocation, packageType, packageDays, packagePrice, packageDetails, packageImage)"
				+ " values (?,?,?,?,?,?,?)";
		try 
		{
			ps = con.prepareStatement(sqlQuery);
			
			ps.setString(1,pkg.getPackageName());
			ps.setString(2,pkg.getPackageLocation());
			ps.setString(3,pkg.getPackageType());
			ps.setInt(4,pkg.getPackageDays());
			ps.setDouble(5,pkg.getPackagePrice());
			ps.setString(6,pkg.getPackageDetails());
			ps.setBinaryStream(7,pkg.getPackageImage());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public List<Package> showAllPackage() 
	{
		List<Package> packageList = new ArrayList<>();
		sqlQuery = "select * from package_zatch";
		try 
		{
			ps = con.prepareStatement(sqlQuery);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Package pkg = new Package(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getDouble(6),
						rs.getString(7));
				pkg.setPackageImage(rs.getBinaryStream(8));
				packageList.add(pkg);
				
			}
			return packageList;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public boolean updatePackage(Package pkg) {
		
		sqlQuery = "update package_zatch set packageName=?, packageLocation=?, packageType=?, packageDays=?, packagePrice=?, packageDetails=?, packageImage=? where  packageId=?";
		try 
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, pkg.getPackageName());
			ps.setString(2, pkg.getPackageLocation());
			ps.setString(3, pkg.getPackageType());
			ps.setInt(4, pkg.getPackageDays());
			ps.setDouble(5, pkg.getPackagePrice());
			ps.setString(6, pkg.getPackageDetails());
			ps.setBinaryStream(7,pkg.getPackageImage());
			ps.setInt(8, pkg.getPackageId());
			
			int i = ps.executeUpdate();
			if(i>0)
				return true;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deletePackage(int packageId) {
		sqlQuery="delete from package_zatch where packageId=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,packageId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Package getPackageById(int packageId) {
		sqlQuery = "select * from package_zatch where packageId=?";
		try 
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,packageId);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				Package pkg = new Package(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getDouble(6),
						rs.getString(7));
				pkg.setPackageImage(rs.getBinaryStream(8));
				return pkg;
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Package> getPackageByLocation(String packageLocation) {
		List<Package> pkglist = new ArrayList<Package>();
		sqlQuery = "select *from package_zatch where packagelocation =?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, packageLocation);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Package pkg = new Package();
				pkg.setPackageId(rs.getInt(1));
				pkg.setPackageName(rs.getString(2));
				pkg.setPackageLocation(rs.getString(3));
				pkg.setPackageType(rs.getString(4));
				pkg.setPackageDays(rs.getInt(5));
				pkg.setPackagePrice(rs.getDouble(6));
				pkg.setPackageDetails(rs.getString(7));
				pkglist.add(pkg);
			}
			
			return pkglist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Package> sortById() {
		List<Package> list = showAllPackage();
		Collections.sort(list);
		return list;
	}

	@Override
	public List<Package> sortByName() {
		List<Package> list = showAllPackage();
		SortPackageByName byName = new SortPackageByName();
		Collections.sort(list, byName);
		return list;
	}

}
