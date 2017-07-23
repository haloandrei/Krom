package com.haloandrei.pj1game1.input;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class write {
	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(int x,int y) {

		BufferedWriter bw = null;
		FileWriter fw = null;
      
		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(String.valueOf(x)+"\n" + String.valueOf(y) + "\n");

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}


}
