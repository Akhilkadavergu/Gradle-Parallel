package com.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Report {

	public static void moveFolder(String folderName) {
		File newFolerInArchive = new File("Report\\Archive\\" + folderName);
		try {
			newFolerInArchive.mkdir();
			Files.move(new File("Report\\" + folderName).toPath(), new File("Report\\Archive\\" + folderName).toPath(),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void moveOldReportToArchive() {
		File folder = new File("Report");
		File[] listFOFiles = folder.listFiles();
		for (File file : listFOFiles) {
			if (file.isDirectory() && file.getName().startsWith("cucumber-html-reports")) {
				System.out.println(file.getName());
				moveFolder(file.getName());
			}
		}
	}
}
