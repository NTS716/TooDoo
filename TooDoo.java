import java.util.ArrayList;
import java.util.Scanner;
public class TooDoo {
	
	public static ArrayList<Task> tasks = new ArrayList<Task>();
	public static Scanner scanner = new Scanner(System.in);

	public static void newTask()
	{
	//Get the name of the new task
	System.out.print("Enter a name: ");
	String inp_name = scanner.nextLine();
	//Get the description of the new task
	tasks.add(new Task(inp_name));
	//Confirmation message
	System.out.println("Done.");
	}

	public static void help()
	{
		System.out.println("\nnew - creates a new task");
		System.out.println("list - views the created tasks");
		System.out.println("check - checks a selected task");
		System.out.println("clean - removes all checked tasks");
		System.out.println("remove - removes a selected task");
		System.out.println("help - show this dialouge");
		System.out.println("quit - exits TooDoo\n");
	}

	public static void list()
	{
		//loops through all of the tasks
		for (int i = 0; i < tasks.size(); i++) {
			//Prints the number of the task
			System.out.print("(");
			System.out.print(i + 1);
			System.out.print(") ");
			//Print out the task name
			System.out.print(tasks.get(i).name);
			//Prints the completed check box
			if (tasks.get(i).completed == false) {
				System.out.println(" []");
			} else {
				System.out.println(" [X]");
			}
		}
	}
	
	public static void check()
	{
		//Prompt for the name of the task
		System.out.print("Enter the number of the task: ");
		String taskToCheck = scanner.nextLine();
		//Convert the user input to an integer
		int taskInt = Integer.parseInt(taskToCheck);
		//Check the task
		try {

		tasks.get(taskInt - 1).completed = true;

		} catch (IndexOutOfBoundsException e) {

			System.out.println("\nERROR: task does not exist\n");

		}
		//Confirmation message
		System.out.println("Done.");
	}

	public static void clean()
	{
		for (int i = tasks.size() - 1; i >= 0; i--) {
			if (tasks.get(i).completed == true) {
				tasks.remove(i);
				continue;
			}
		}
	}

	public static void remove()
	{
		System.out.print("Enter the number of the task: ");
		String taskToRemove = scanner.nextLine();
		int taskInt = Integer.parseInt(taskToRemove);
		try {

		tasks.remove(taskInt - 1);
		
		} catch (IndexOutOfBoundsException e) {
	
			System.out.println("\nERROR: task does not exist\n");

		}
		//Confirmation Message
		System.out.println("Done.");
	}

	public static void getInp()
	{
		while (true) {
			//ask for command
			System.out.print("Enter a command: ");
			String inp = scanner.nextLine();
			//identify the command
			if (inp.equals("quit")) {
				break;

			} else if (inp.equals("new")) {
				newTask();

			} else if (inp.equals("list")) {
				list();

			} else if (inp.equals("check")) {
				check();

			} else if (inp.equals("clean")) {
				clean();

			} else if (inp.equals("remove")) {
				remove();
			} else {
				help();
			}
		}
	}

	public static void main(String[] args)
	{
		//Welcome Message
		System.out.println("TooDoo 1.0.0");
		help();
		getInp();
	}
}
