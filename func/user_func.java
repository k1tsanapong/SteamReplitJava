package func;

import java.util.*;

public class user_func
{

	public static void AddNewUser(String name, String password)
	{
		String start_money = "0";

		file_func.WriteOnFile("user", name + "," + password);
		file_func.WriteOnFile("libary", name + "," + start_money + ",");

		// using (StreamWriter file = new StreamWriter(file_func.Path("user"), true))
		// {
		//     file.WriteLine(user_new);
		// }

	}




	public static boolean CheckUserName(String new_user_name)
	{
		String[] user_name = file_func.PullData("user");
		return file_func.ScanData(new_user_name, 1, user_name);

	}







}