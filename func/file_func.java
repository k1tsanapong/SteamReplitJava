package func;

import java.util.*;

public class file_func
{

	public static String[] PullData(String file_name)
	{
		String[] data_base;
		String path = Path(file_name);

	try
	{
		data_base = File.ReadAllLines(path);
	}
	catch (DirectoryNotFoundException e)
	{
		path = "../../../data/" + file_name + ".txt"; //for visual studio
		data_base = File.ReadAllLines(path);
	}
		return data_base;

	}

	public static String[] SelectData(String check, int column, String[] data_base)
	{

		column--;
		String[] not_found = {"NotFound"};

		for (int i = 0; i < data_base.length; i++)
		{
			String[] fields = data_base[i].split("[,]", -1);

			if (check.equals(fields[column]))
			{
				return fields; //break
			}
		}

		return not_found;
	}

	public static String Path(String file_name)
	{
		// string path = "../../../data/" + file_name + ".txt"; //for visual studio
		String path = "./data/" + file_name + ".txt";
		return path;
	}

	public static boolean ScanData(String check, int column, String[] data_base)
	{

		column--; //Array start at 0

		for (int i = 0; i < data_base.length; i++) //check all rows
		{
			String[] fields = data_base[i].split("[,]", -1);

			if (check.equals(fields[column]))
			{
				//Console.WriteLine("fail");
				return true; //break
			}
		}

		//Console.WriteLine("Suc");
		return false;

	}

	public static String CheckLine(String check, int column, String[] data_base)
	{

		column--; //Array start at 0

		for (int i = 0; i < data_base.length; i++) //check all rows
		{
			String[] fields = data_base[i].split("[,]", -1);

			if (check.equals(fields[column]))
			{
				//Console.WriteLine("fail");
				return data_base[i]; //break
			}
		}

		//Console.WriteLine("Suc");
		return "not";

	}



	public static void WriteOnFile(String file_name, ArrayList<String> words)
	{

		// string user_new = name + "," + password;
		// Console.WriteLine(name + "," + password);

		// column--;   //Array start at 0

		// for (int i = 0; i < data_base.Length; i++)  //check all rows
		// {
		//     string[] fields = data_base[i].Split(',');

		//     if (check == fields[column])
		//     {
		//         //Console.WriteLine("fail");
		//         return true;                           //break
		//     }
		// }

		// //Console.WriteLine("Suc");
		// return false;

		// string sentence ;

		// var even = new List<int>();
		// var odd = new List<int>();

		try (OutputStreamWriter file = new OutputStreamWriter(file_func.Path(file_name)))
		{
			file.write(words.get(0) + System.lineSeparator());
		}



	}

	public static void WriteOnFile(String file_name, String words)
	{
		try (OutputStreamWriter file = new OutputStreamWriter(file_func.Path(file_name)))
		{
			file.write(words + System.lineSeparator());
		}
	}

}