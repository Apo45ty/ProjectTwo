/**
 * A colleciton of mehods to deal with files giveing and taking in the testing enviorment
 */
package com.revature.test.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ed M
 * @date May 15, 2018
 * @time time 9:32:23 AM
 */
public class FileUtil {

	// Only checks if the filename matches in the given directory
	public static boolean isFileThere(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public static boolean DeleteFile(String downloadPath, String fileName) {
		// Checks to see if file is there first
		if (isFileThere(downloadPath, fileName)) {
			String filePath = downloadPath +"\\" +fileName;// Combine folderpath and filename to filepath
			System.out.println("Deleteing: " + filePath);
			try {
				Files.deleteIfExists(Paths.get(filePath));
			} catch (NoSuchFileException e) {
				System.out.println("No such file/directory exists");
				e.getLocalizedMessage();
			} catch (DirectoryNotEmptyException e) {
				System.out.println("Directory is not empty.");
				e.getLocalizedMessage();
			} catch (IOException e) {
				System.out.println("Invalid permissions.");
				e.getLocalizedMessage();
			}
		}
		return false;

	}
}
