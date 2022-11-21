import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if(args.length != 1)
		{
          System.out.println("use valid argument\n a for show all\n r for random item\n c for count\n + for add new\n ? for find specific item\n");
		}
		else if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferreader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String names = bufferreader.readLine();
				String studentnames[] = names.split(",");
				for (String name : studentnames) {
					System.out.println(name.trim());
				}
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferreader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String names = bufferreader.readLine();
				String studentnames[] = names.split(",");
				Random random = new Random();
				int randomindex = random.nextInt(studentnames.length);
				System.out.println(studentnames[randomindex].trim());
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferwriter = new BufferedWriter(
						new FileWriter("students.txt", true));
				String name = args[0].substring(1);
				Date date = new Date();
				String dateformat = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateformat);
				String formatdate = dateFormat.format(date);
				bufferwriter.write(", " + name + "\nList last updated on " + formatdate);
				bufferwriter.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferreader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String names =  bufferreader.readLine();
				String studentnames[] = names.split(",");
				boolean done = false;
				String name = args[0].substring(1);
				for (int index = 0; index < studentnames.length && !done; index++) {
					if (studentnames[index].equals(name)) {
						System.out.println("We found it!");
						done = true;
					}
				}
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferreader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String name = bufferreader.readLine();
				char names[] = name.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char c : names) {
					if (c == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found ");
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
		else
		{
			System.out.println("use valid argument\n a for show all\n r for random item\n c for count\n + for add new\n ? for find specific item\n");
		}
	}
}
