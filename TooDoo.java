import java.util.ArrayList;
import java.util.Scanner;
public class TooDoo {
	
	public static ArrayList<Task> tasks = new ArrayList<Task>();
	public static Scanner scanner = new Scanner(System.in);

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

				//Get the name of the new task
				System.out.print("Enter a name: ");
				String inp_name = scanner.nextLine();
				//Add the task to the task list
				tasks.add(new Task(inp_name));
				//Confirm the creation of the task
				System.out.println("A new task has been created");

			} else if (inp.equals("list")) {

				//loops through all of the tasks
				for (int i = 0; i < tasks.size(); i++) {
					//Print out the task name
					System.out.print(tasks.get(i).name);
					//Prints the completed check box
					if (tasks.get(i).completed == false) {
					System.out.println(" []");
					} else {
						System.out.println(" [X]");
					}
				}
			} else if (inp.equals("check")) {
				System.out.print("Enter the name of the task: ");
				String taskToCheck = scanner.nextLine();
				for (int i = 0; i < tasks.size(); i++) {
					if (taskToCheck.equals(tasks.get(i).name)) {
						tasks.get(i).completed = true;
						System.out.println("The task has been checked");
						break;
					}
				}
			} else if (inp.equals("clean")) {
				for (int i = 0; i < tasks.size(); i++) {
					if (tasks.get(i).completed == true) {
						tasks.remove(i);
					}
				}
			} else if (inp.equals("remove")) {
				System.out.print("Enter the name of the task: ");
				String taskToRemove = scanner.nextLine();
				for (int i = 0; i < tasks.size(); i++) {
					if (taskToRemove.equals(tasks.get(i).name)) {
						tasks.remove(i);
					}
				}
			}
		}
	}
	public static void main(String[] args)
	{
		//Welcome Message
		System.out.println("TooDoo 1.0.0");
		getInp();
	}
}
