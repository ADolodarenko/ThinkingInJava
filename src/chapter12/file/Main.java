package chapter12.file;

import java.io.FileInputStream;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream file = new FileInputStream("kokoko.java");
		file.close();
	}
}
