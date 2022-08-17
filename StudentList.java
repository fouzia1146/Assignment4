import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static void main(String[] input)
	{
		//Check arguments
		if(input[0].equals(Constant.ShowAll))   //Enlisted data in the list
		{
			System.out.println(Constant.LoadingData);
			String substring=input[0].substring(1);
			if(substring.length()==0)
			{
				try
				{
					String students[] = getLine().split(Constant.Coma);
					for (String student : students)
					{
						System.out.println(student);
					}
				} catch (Exception e) {}
				System.out.println(Constant.dataLoaded);
			}
			else
				System.out.println(Constant.invalidInput);
		}
		else if(input[0].equals(Constant.randomStudent))    //Random data from the list
		{
			System.out.println(Constant.LoadingData);
			String substring=input[0].substring(1);
			if(substring.length()==0)
			{
				try
				{
					String students[] = getLine().split(Constant.Coma);
					int index = new Random().nextInt(students.length);
					System.out.println(students[index]);
				} catch (Exception e) {}
			}
			else
				System.out.println(Constant.invalidInput);
			System.out.println(Constant.dataLoaded);
		}
		else if(input[0].contains(Constant.add))    //Adding data in thr list
		{
			System.out.println(Constant.LoadingData);
			try
			{
				String line = Files.readAllLines(Paths.get(Constant.StudentList)).get(0);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constant.StudentList, true));
				String input_txt = input[0].substring(1);
				new PrintWriter(new FileWriter(Constant.StudentList, false), false).flush();
				new PrintWriter(new FileWriter(Constant.StudentList, false), false).close();
				new FileWriter(Constant.StudentList, false).close();
				String dateFormater = Constant.date;
				bufferedWriter.write(line+Constant.Coma+ input[0].substring(1) +Constant.listUpdated+new SimpleDateFormat(dateFormater).format(new Date()));
				bufferedWriter.close();
			} catch (Exception e){}
			System.out.println(Constant.dataLoaded);
		}
		else if(input[0].contains(Constant.isEnlisted))    //Searching data in the list
		{
			System.out.println(Constant.LoadingData);
			try
			{
				String students[] = getLine().split(Constant.Coma);
				String input_word = input[0].substring(1);
				int ind=-1;
				for(int index = 0; index < students.length ; index++)
				{
					if(students[index].equals(input_word))
					{
						ind=index;
						break;
					}
				}
				if(ind==-1)
					System.out.println(Constant.notFound);
				else
					System.out.println(Constant.found);
			} catch (Exception e) {}
			System.out.println(Constant.dataLoaded);
		}
		else if(input[0].contains(Constant.numOfWords))     //Counting words
		{
			System.out.println(Constant.LoadingData);
			if (input[0].substring(1).length() == 0)
			{
				try
				{
					String chars[] = getLine().split(Constant.Coma);
					System.out.println(chars.length + Constant.NoOfWords);
				} catch (Exception e) {}
			}
			else
				System.out.println(Constant.invalidInput);
			System.out.println(Constant.dataLoaded);
		}
		else     //Invalid input
		{
			System.out.println(Constant.invalidInput);
		}
	}
	private static String getLine() throws IOException
	{
		return new BufferedReader(new InputStreamReader(new FileInputStream(Constant.StudentList))).readLine();
		//Returning bufferedreader
	}
}