import func.*;
import selectmenu.*;
import java.util.*;

// start

public class Program
{
	public static void main(String[] args)
	{
		boolean success; // use for no error input
		int select, userInput = 1;
		String user_name = "";
		String[] user_data;
		double balance = 0;



		userInput = 1;
		while (userInput != 0)
		{

			main_menu.selection(userInput);
			tangible.OutObject<Integer> tempOut_select = new tangible.OutObject<Integer>();
			success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_select);
			select = tempOut_select.outArgValue;

			switch (select)
			{

				case 1:
					userInput = 0;
					user_name = main_menu.login();
					if (user_name.equals("0"))
					{
						userInput = 1;
						break;
					}
					user_data = file_func.SelectData(user_name, 1, file_func.PullData("libary"));
					balance = Double.parseDouble(user_data[1]);
					break;
				case 2:
					userInput = 0;
					user_name = main_menu.signup();
					if (user_name.equals("0"))
					{
						userInput = 1;
						break;
					}
					user_data = file_func.SelectData(user_name, 1, file_func.PullData("libary"));
					balance = Double.parseDouble(user_data[1]);
					break;

				case 0:

					if (success == false)
					{
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
						goto default;
					}

					System.exit(0);
					break;

				default:
					userInput = 2;
					break;


			}
		}



		do
		{

			menu.selection();
			tangible.OutObject<Integer> tempOut_select2 = new tangible.OutObject<Integer>();
			success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_select2); // input select
			select = tempOut_select2.outArgValue;

			switch (select)
			{
				case 1:
					menu.SelectGame(user_name, balance); // return game yet.
					break;

				case 2:
					menu.libary(user_name);
					break;

				case 0:
					if (success == false)
					{
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
						goto default;
					}
					userInput = 1;
					while (userInput != 0)
					{

						main_menu.selection(userInput);
						tangible.OutObject<Integer> tempOut_select3 = new tangible.OutObject<Integer>();
						success = tangible.TryParseHelper.tryParseInt(new Scanner(System.in).nextLine(), tempOut_select3);
						select = tempOut_select3.outArgValue;

						switch (select)
						{

							case 1:
								userInput = 0;
								user_name = main_menu.login();
								if (user_name.equals("0"))
								{
									userInput = 1;
									break;
								}
								user_data = file_func.SelectData(user_name, 1, file_func.PullData("libary"));
								balance = Double.parseDouble(user_data[1]);
								break;
							case 2:
								userInput = 0;
								user_name = main_menu.signup();
								if (user_name.equals("0"))
								{
									userInput = 1;
									break;
								}
								user_data = file_func.SelectData(user_name, 1, file_func.PullData("libary"));
								balance = Double.parseDouble(user_data[1]);

								break;

							case 0:

								if (success == false)
								{
//C# TO JAVA CONVERTER TODO TASK: There is no 'goto' in Java:
									goto default;
								}

								System.exit(0);
								break;

							default:
								userInput = 2;
								break;


						}
					}

					break;
				default:
					Console.Clear();
					System.out.println("Please select 1-3");
					Console.ReadKey();
					break;
			}

			user_data = file_func.SelectData(user_name, 1, file_func.PullData("libary"));
			balance = Double.parseDouble(user_data[1]);


		} while (true);

	} // main


}