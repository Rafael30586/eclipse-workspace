package com.rafael;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;


public class FileUpload extends HttpServlet {
	
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory; // Investigar cual es el constructor que funciona para esta versión de la bilblioteca
		
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File)servletContext.getAttribute("jakarta.servlet.context.tempdir");
		factory = DiskFileItemFactory.builder().get();
		
		
		JakartaServletFileUpload sf = new JakartaServletFileUpload(factory);
		List<FileItem> multifiles = sf.parseRequest(request);
		
		
		for(FileItem item : multifiles) {
			Path ruta = FileSystems.getDefault().getPath("C:\\Users\\User\\eclipse-workspace\\FileUploadDemo\\", item.getName());
			item.write(ruta);
		}
		
		System.out.println("Archivo subido");
	}

}
