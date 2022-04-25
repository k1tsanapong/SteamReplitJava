package selectmenu;

import func.*;
import java.util.*;
import java.nio.file.*;

//  .----------------.  .----------------.  .-----------------. .----------------. 
// | .--------------. || .--------------. || .--------------. || .--------------. |
// | | ____    ____ | || |  _________   | || | ____  _____  | || | _____  _____ | |
// | ||_   \  /   _|| || | |_   ___  |  | || ||_   \|_   _| | || ||_   _||_   _|| |
// | |  |   \/   |  | || |   | |_  \_|  | || |  |   \ | |   | || |  | |    | |  | |
// | |  | |\  /| |  | || |   |  _|  _   | || |  | |\ \| |   | || |  | '    ' |  | |
// | | _| |_\/_| |_ | || |  _| |___/ |  | || | _| |_\   |_  | || |   \ `--' /   | |
// | ||_____||_____|| || | |_________|  | || ||_____|\____| | || |    `.__.'    | |
// | |              | || |              | || |              | || |              | |
// | '--------------' || '--------------' || '--------------' || '--------------' |
//  '----------------'  '----------------'  '----------------'  '----------------'                            

public class menu
{
	public static void selection()
	{
		Console.Clear();

		System.out.println("*----Menu----*");
		System.out.println("1.Shop");
		System.out.println("2.Libray");
		System.out.println("0.Sign Out");
		// Console.WriteLine("0. Exit");
		System.out.print("Select ....");
	}

	//    _____ __              
	//   / ___// /_  ____  ____ 
	//   \__ \/ __ \/ __ \/ __ \
	//  ___/ / / / / /_/ / /_/ /
	// /____/_/ /_/\____/ .___/ 
	//                 /_/      



	public static void shop(double balance)
	{

		String[] game_name = {"GTA X", "Cyberpunk 1999", "Old World", "Mariol Cart"};
		int[] game_price = {999, 1299, 899, 299};

		Console.Clear();

		System.out.println("*----Shop----*    Your Balance:" + balance);
		System.out.println(String.format("1.%1$s \t\t %2$s  baht", game_name[0], game_price[0]));
		System.out.println(String.format("2.%1$s \t %2$s  baht", game_name[1], game_price[1]));
		System.out.println(String.format("3.%1$s \t\t %2$s  baht", game_name[2], game_price[2]));
		System.out.println(String.format("4.%1$s \t\t %2$s  baht", game_name[3], game_price[3]));
		System.out.println(String.format("5.my wallet"));
		System.out.println("0.Return");

	}

	//    _____      __          __       ______                   
	//   / ___/___  / /__  _____/ /_     / ____/___ _____ ___  ___ 
	//   \__ \/ _ \/ / _ \/ ___/ __/    / / __/ __ `/ __ `__ \/ _ \
	//  ___/ /  __/ /  __/ /__/ /_     / /_/ / /_/ / / / / / /  __/
	// /____/\___/_/\___/\___/\__/     \____/\__,_/_/ /_/ /_/\___/ 

	public static void SelectGame(String user_name, double balance)
	{
		boolean success; // use for no error input
		int select;

		do
		{
			shop(balance);
			// Console.WriteLine(select);
			tangible.OutObject<Integer> tempOut_select = new tangible.OutObject<Integer>();
			success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_select); // input select
		select = tempOut_select.outArgValue;

			if (select >= 1 && select <= 4)
			{
				balance = BuyGame(user_name, balance, select);

			}

			else if (select == 5)
			{
				balance = YourWallet(user_name, balance);

			}

			else if (select == 0 && success == true)
			{
				break;
			}

			else
			{
				Console.Clear();
				System.out.println("Please select 1-5");
				Console.ReadKey();

			}

		} while (true);



		System.out.println(String.format("Your current balance is : %1$s", balance));
	}

	//     ____                 ______                      
	//    / __ ) __  __ __  __ / ____/____ _ ____ ___   ___ 
	//   / __  |/ / / // / / // / __ / __ `// __ `__ \ / _ \
	//  / /_/ // /_/ // /_/ // /_/ // /_/ // / / / / //  __/
	// /_____/ \__,_/ \__, / \____/ \__,_//_/ /_/ /_/ \___/ 
	//               /____/                                 
	public static double BuyGame(String user_name, double balance, int choose)
	{
		boolean success;
		int ans;
		int select;
		String[] games_in_libary;
		choose--;

		var games = new String[][]
		{
			{"GTA X", "999"},
			{"Cyberpunk 1999", "1299"},
			{"Old World", "899"},
			{"Mario Cart", "299"}
		};

		int name = 0;
		int price = 1;


		// Console.Clear();

		do
		{
			Console.Clear();

			// check game


			games_in_libary = file_func.SelectData(user_name, 1, file_func.PullData("libary"));

			for (int i = 2; i < games_in_libary.length; i++)
			{

				if (games_in_libary[i].equals(games[choose][name]))
				{
					System.out.println("You have it already.");
					Console.ReadKey();
					return balance;
				}


			}

			// check game


			System.out.println(String.format("%1$s", games[choose][name]));
			System.out.println(String.format("Would you like to buy %1$s for %2$s baht? \n1.Yes   2.No", games[choose][name], games[choose][price]));


			tangible.OutObject<Integer> tempOut_ans = new tangible.OutObject<Integer>();
			success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_ans); // input ans
		ans = tempOut_ans.outArgValue;


			int game_price = Integer.parseInt(games[choose][price]);



			if (ans == 1 && balance > game_price)
			{




				do
				{
					Console.Clear();
					System.out.println(String.format("You have purchased %1$s.\t Your remaining balance : %2$s", games[choose][name], balance - game_price)); //เงินที่จะเหลือหลังซื้อเกม
					System.out.println("Comfirm purchase?");
					System.out.println("1.yes");
					System.out.println("2.no");

					tangible.OutObject<Integer> tempOut_select = new tangible.OutObject<Integer>();
					success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_select);
				select = tempOut_select.outArgValue;

					switch (select)
					{
						case 1:

							Console.Clear();
							System.out.println("yes");

							double balance_new = balance - game_price;
							// file_func.WriteOnFile("libary", user_name + "," + balance + "," + games[choose, name] + ",");

							String text = Files.readString("./data/libary.txt");
							// string[] text = file_func.PullData("libary");



							// text = text.Replace(user_name, "," + balance + "," + games[choose, name] + ",");
							text = text.replace(user_name + "," + balance, user_name + "," + balance_new);
							Files.writeString("./data/libary.txt", text);

							String line = file_func.CheckLine(user_name, 1, file_func.PullData("libary"));
							text = text.replace(line, line + games[choose][name] + ",");
							Files.writeString("./data/libary.txt", text);

							return balance_new;


						case 2:

							Console.Clear();
							System.out.println("purchase failed !!!");
							return balance;


						default:
							Console.Clear();
							System.out.println("Select only 1,2");
							Console.ReadKey();
							break;

					}



				} while (true);




			}

			else if (ans == 1 && balance < game_price) //Taeza007
			{
				Console.Clear();
				System.out.println("You don't have enough money.");
				Console.ReadKey();
				return balance;
			}

			else if (ans == 2)
			{
				Console.Clear();
				System.out.println("Purchase Failed.");
				Console.ReadKey();
				return balance;
			}

			else
			{
				Console.Clear();
				System.out.println("Please select 1 or 2 only.");
				Console.ReadKey();
			}



		} while (true);

	}

	// __  __                    _       __        __ __       __ 
	// \ \/ /____   __  __ _____| |     / /____ _ / // /___   / /_
	//  \  // __ \ / / / // ___/| | /| / // __ `// // // _ \ / __/
	//  / // /_/ // /_/ // /    | |/ |/ // /_/ // // //  __// /_  
	// /_/ \____/ \__,_//_/     |__/|__/ \__,_//_//_/ \___/ \__/  



	public static double YourWallet(String user_name, double balance)
	{
		boolean success;
		int select;

		int topup_loop = 1;
		while (topup_loop != 0)
		{
			Console.Clear();
			System.out.println("----Your Wallet----");
			System.out.println(String.format("Current Wallet balance = %1$s Baht", balance)); //return wallet
			System.out.println("1.Topup");
			System.out.println("0.return");
			tangible.OutObject<Integer> tempOut_select = new tangible.OutObject<Integer>();
			success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_select); // input select
		select = tempOut_select.outArgValue;

			switch (select)
			{
				case 1:

					topup_loop--;

					double topup;
					System.out.print("Input your balance: ");
					tangible.OutObject<Double> tempOut_topup = new tangible.OutObject<Double>();
					success = tangible.TryParseHelper.tryParseDouble(new Scanner(System.in).nextLine(), tempOut_topup); // input select
				topup = tempOut_topup.outArgValue;

					double balance_new = balance + topup;

					String text = Files.readString("./data/libary.txt");
					text = text.replace(user_name + "," + balance + ",", user_name + "," + balance_new + ",");
					Files.writeString("./data/libary.txt", text);

					System.out.println(String.format("Steam wallet code : %1$s", balance)); //return wallet

					return balance_new;


				case 0:
					if (success == false)
					{
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
						goto default;
					}
					topup_loop--;
					return balance;
				// ฝาก 0.returnด้วย
				default:
					Console.Clear();
					System.out.println("Please select only 0 or 1");
					Console.ReadKey();

					break;
			}

		}
		return balance;
	}

	//     __     _  __                       
	//    / /    (_)/ /_   ____ _ _____ __  __
	//   / /    / // __ \ / __ `// ___// / / /
	//  / /___ / // /_/ // /_/ // /   / /_/ / 
	// /_____//_//_.___/ \__,_//_/    \__, /  
	//                               /____/   

	public static void libary(String user_name)
	{
		boolean success;
		String[] show_game;
		show_game = file_func.SelectData(user_name, 1, file_func.PullData("libary"));



		for (int i = 2; i <= show_game.length; i++)
		{
			if (i == 2)
			{
				Console.Clear();
				System.out.println("*----Libary----*");

			}

			if (i == show_game.length)
			{
				System.out.println("0. Return");
				System.out.print("Select... ");

				int game;

				tangible.OutObject<Integer> tempOut_game = new tangible.OutObject<Integer>();
				success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_game); // input select
			game = tempOut_game.outArgValue;
				game = game + 1;

				switch (game)
				{
					case < 1:
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
						goto default;

					case 1:

						if (success == false)
						{
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
							goto default;
						}
						// return
						break;

					case > 1:
						if (game > show_game.length - 2)
						{
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
							goto default;
						}

						Console.Clear();
						System.out.println(String.format("%1$s", show_game[game]));

						System.out.println("   _____ _             _      _____                      ");
						System.out.println("  / ____| |           | |    / ____|                     ");
						System.out.println(" | (___ | |_ __ _ _ __| |_  | |  __  __ _ _ __ ___   ___ ");
						System.out.println("  \\___ \\| __/ _` | '__| __| | | |_ |/ _` | '_ ` _ \\ / _ \\");
						System.out.println("  ____) | || (_| | |  | |_  | |__| | (_| | | | | | |  __/");
						System.out.println(" |_____/ \\__\\__,_|_|   \\__|  \\_____|\\__,_|_| |_| |_|\\___|");


						//kimzafslk;djgo;eghlwjerfl;jksfd

						Console.ReadKey();
						System.exit(0);

						break;

					default:

						Console.Clear();

						if (show_game.length - 3 == 0)
						{
							System.out.println("Please select return");
						}

						else
						{
							System.out.println(String.format("Please select 1-%1$s", show_game.length - 3));
						}


						Console.ReadKey();
						i = 1;

						break;

				}

			}




			else if (show_game[2].equals(""))
			{
				System.out.println("Have no game");


			}

			else if (!show_game[i].equals(""))
			{
				System.out.println(i - 1 + ". " + show_game[i]);
			}






		}



	}

}