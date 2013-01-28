package com.ptank.food.app.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.core.io.FileSystemResource;

import com.ptank.food.core.FoodApp;
import com.ptank.food.core.io.FoodAppXmlIO;

public class FileBasedFoodAppRepository {

	private FileSystemResource location;
	private FoodAppXmlIO foodAppIO = new FoodAppXmlIO();
	
	public void setLocation(FileSystemResource location) {
		this.location = location;
	}
	
	private void createIfDoesNotExist() throws IOException {
		if(!location.exists()) {
			try {
				File locationFile = new File(location.getPath());
				locationFile.getParentFile().mkdirs();
				locationFile.createNewFile();
				PrintWriter fileWriter = new PrintWriter(locationFile);
				Scanner scanner = new Scanner(FoodApp.class.getResourceAsStream("/StartingFoodLibrary.xml"));
				while(scanner.hasNextLine()) {
					fileWriter.println(scanner.nextLine());
				}
				fileWriter.close();
				scanner.close();
			} catch (FileNotFoundException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
	
	public FoodApp loadFoodApp() throws IOException {
		createIfDoesNotExist();
		return foodAppIO.loadFoodApp(new InputStreamReader(location.getInputStream()));
	}
	
	public void saveFoodApp(FoodApp foodApp) throws IOException {
		foodAppIO.save(foodApp, new FileWriter(location.getFile()));
	}
}
