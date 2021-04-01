package com.zatch.toursandtravels.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zatch.toursandtravels.dao.impl.PackageDaoImpl;
import com.zatch.toursandtravels.pojo.Package;


@WebServlet("/image")
public class ImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/*");
		PrintWriter out = resp.getWriter();
		String action = req.getParameter("action");
		
		if(action != null && action.equalsIgnoreCase("showImage")) {
			int packageId = Integer.parseInt(req.getParameter("packageId"));
			
			Package packageObj = new PackageDaoImpl().getPackageById(packageId);
			
			InputStream packageImage = packageObj.getPackageImage();
			
			
			if(packageImage !=null) {
				int i=0;
				while((i = packageImage.read())!=-1) {
					out.write(i);
				}
				packageImage.close();
				out.close();
			}
		}
	}
}
