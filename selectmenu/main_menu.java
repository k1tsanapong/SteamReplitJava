package selectmenu;

import func.*;
import java.util.*;
import java.nio.file.*;

//  .----------------.  .----------------.  .----------------.  .-----------------.          .----------------.  .----------------.  .-----------------. .----------------. 
// | .--------------. || .--------------. || .--------------. || .--------------. |         | .--------------. || .--------------. || .--------------. || .--------------. |
// | | ____    ____ | || |      __      | || |     _____    | || | ____  _____  | |         | | ____    ____ | || |  _________   | || | ____  _____  | || | _____  _____ | |
// | ||_   \  /   _|| || |     /  \     | || |    |_   _|   | || ||_   \|_   _| | |         | ||_   \  /   _|| || | |_   ___  |  | || ||_   \|_   _| | || ||_   _||_   _|| |
// | |  |   \/   |  | || |    / /\ \    | || |      | |     | || |  |   \ | |   | |         | |  |   \/   |  | || |   | |_  \_|  | || |  |   \ | |   | || |  | |    | |  | |
// | |  | |\  /| |  | || |   / ____ \   | || |      | |     | || |  | |\ \| |   | |         | |  | |\  /| |  | || |   |  _|  _   | || |  | |\ \| |   | || |  | '    ' |  | |
// | | _| |_\/_| |_ | || | _/ /    \ \_ | || |     _| |_    | || | _| |_\   |_  | |         | | _| |_\/_| |_ | || |  _| |___/ |  | || | _| |_\   |_  | || |   \ `--' /   | |
// | ||_____||_____|| || ||____|  |____|| || |    |_____|   | || ||_____|\____| | |         | ||_____||_____|| || | |_________|  | || ||_____|\____| | || |    `.__.'    | |
// | |              | || |              | || |              | || |              | |         | |              | || |              | || |              | || |              | |
// | '--------------' || '--------------' || '--------------' || '--------------' |         | '--------------' || '--------------' || '--------------' || '--------------' |
//  '----------------'  '----------------'  '----------------'  '----------------'           '----------------'  '----------------'  '----------------'  '----------------' 


public class main_menu
{

	public static void selection(int again)
	{
		Console.Clear();

		System.out.println("--- Main Menu ---");
		System.out.println("1. Log in ");
		System.out.println("2. Sign up");
		System.out.println("0. Exit");
		if (again == 2)
		{
			System.out.println("Please select 1-2");
		}
		System.out.print("Select ....");

	}


	//     __                  ____     
	//    / /   ____   ____ _ /  _/____ 
	//   / /   / __ \ / __ `/ / / / __ \
	//  / /___/ /_/ // /_/ /_/ / / / / /
	// /_____/\____/ \__, //___//_/ /_/ 
	//              /____/              
	public static String login()
	{
		String user_name, user_password;
		String[] check_password;
		int check_loop = 1;

		Console.Clear();
		System.out.println("--- Log In ---");
		System.out.println("Enter 0 for return");
		do
		{
			if (check_loop == 2)
			{
				Console.Clear();
				System.out.println("--- Log In ---");
				System.out.println("Username or Password is wrong");
			}

			System.out.print("User : ");

			user_name = new Scanner(System.in).nextLine();
			if (user_name.equals("0"))
			{
				return "0";
			}
			if (file_func.ScanData(user_name, 1, file_func.PullData("user")))
			{

				System.out.print("Password : ");
				user_password = new Scanner(System.in).nextLine();

				check_password = file_func.SelectData(user_name, 1, file_func.PullData("user"));

				if (user_password.equals(check_password[1]))
				{
					System.out.println("Suc");
					return user_name;
				}

				else
				{
					check_loop = 2;
				}

			}
			else
			{
				check_loop = 2;
			}

		} while (true);


	}


	//    _____  _                __  __     
	//   / ___/ (_)____ _ ____   / / / /____ 
	//   \__ \ / // __ `// __ \ / / / // __ \
	//  ___/ // // /_/ // / / // /_/ // /_/ /
	// /____//_/ \__, //_/ /_/ \____// .___/ 
	//          /____/              /_/      
	public static String signup()
	{
		String user_name, user_password, user_password_confilm;
		int check_loop = 1;

		// user_name condition if(new_user_name) {do something}

		Console.Clear();
		System.out.println("--- Sign Up ---");
		System.out.println("Enter 0 for return");

		do
		{
			if (check_loop == 2)
			{
				Console.Clear();
				System.out.println("--- Sign Up ---");
				System.out.println("Duplicate");

				// Console.WriteLine("Me kon chai leaw");

			}

			System.out.print("User : ");
			user_name = new Scanner(System.in).nextLine();


			if (user_name.equals("0"))
			{
				return "0";
			}

			check_loop = 2;

		} while (user_func.CheckUserName(user_name));



		check_loop = 1;
		do
		{
			if (check_loop == 2)
			{
				Console.Clear();
				System.out.println("--- Sign Up ---");
				System.out.println("User : " + user_name);
				System.out.println("Not match");
			}

			System.out.print("Password : ");
			user_password = new Scanner(System.in).nextLine();

			System.out.print("Confirm Password : ");
			user_password_confilm = new Scanner(System.in).nextLine();

			check_loop = 2;

		} while (!user_password.equals(user_password_confilm));



		Console.Clear();
		user_func.AddNewUser(user_name, user_password);
		return user_name;
	}
} // end class main_menu