package com.haloandrei.pj1game1.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class read {
	private static final String FILENAME = "C:\\Users\\Andrei\\workspace\\pj1game1\\res\\PlayerLoc.txt";

	public static void main() {

		BufferedReader br = null;
		FileReader fr = null;
     
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine,nextLine;
			//System.out.println(br.readLine());
			br = new BufferedReader(new FileReader(FILENAME));
			//System.out.println(br.readLine());
			sCurrentLine = br.readLine();
			//PlayerSPx = Integer.parseInt(sCurrentLine);
		//	System.out.println(PlayerSPx);
			nextLine = br.readLine();
			//PlayerSPy = Integer.parseInt(nextLine);
			//System.out.println(PlayerSPy);
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

}
