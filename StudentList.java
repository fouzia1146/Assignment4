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
		if(input[0].equals(Constant.ShowAll))
		{
			System.out.println(Constant.LoadingData);
			String substring=input[0].substring(1);
			if(substring.length()==0)
			{
				try
				{
					String line = getLine();
					String students[] = line.split(Constant.Coma);
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
		else if(input[0].equals(Constant.randomStudent))
		{
			System.out.println(Constant.LoadingData);
			String substring=input[0].substring(1);
			if(substring.length()==0)
			{
				try
				{
					String line = getLine();
					String students[] = line.split(Constant.Coma);
					Random random = new Random();
					int index = random.nextInt(students.length);
					System.out.println(students[index]);
				} catch (Exception e) {}
			}
			else
				System.out.println(Constant.invalidInput);
			System.out.println(Constant.dataLoaded);
		}
		else if(input[0].contains(Constant.add))
		{
			System.out.println(Constant.LoadingData);
			try
			{
				String line = Files.readAllLines(Paths.get(Constant.StudentList)).get(0);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constant.StudentList, true));
				String input_txt = input[0].substring(1);
				FileWriter fileWriter = new FileWriter(Constant.StudentList, false);
				PrintWriter printWriter = new PrintWriter(fileWriter, false);
				printWriter.flush();
				printWriter.close();
				fileWriter.close();
				Date date = new Date();
				String dateFormater = Constant.date;
				DateFormat dateFormat = new SimpleDateFormat(dateFormater);
				String fd= dateFormat.format(date);
				bufferedWriter.write(line+Constant.Coma+ input_txt +Constant.listUpdated+fd);
				bufferedWriter.close();
			} catch (Exception e){}
			System.out.println(Constant.dataLoaded);
		}
		else if(input[0].contains(Constant.isEnlisted))
		{
			System.out.println(Constant.LoadingData);
			try
			{
				String line = getLine();
				String students[] = line.split(Constant.Coma);
				boolean done = false;
				String input_word = input[0].substring(1);
				for(int index = 0; index < students.length && !done; index++)
				{
					if(students[index].equals(input_word))
					{
						System.out.println(Constant.found);
						done=true;
					}
				}
				if(done==false)
					System.out.println(Constant.notFound);
			} catch (Exception e) {}
			System.out.println(Constant.dataLoaded);
		}
		else if(input[0].contains(Constant.numOfWords))
		{
			System.out.println(Constant.LoadingData);
			String b = input[0].substring(1);
			if (b.length() == 0)
			{
				try
				{
					String line = getLine();
					char chars[] = line.toCharArray();
					int count = 0;
					for (char Char : chars)
					{
						if (Char == ' ')
						{
							count++;
						}
					}
					System.out.println(count + 1 + Constant.words + chars.length);
				} catch (Exception e) {}
			}
			else
				System.out.println(Constant.invalidInput);
			System.out.println(Constant.dataLoaded);
		}
		else
		{
			System.out.println(Constant.invalidInput);
		}
	}
	private static String getLine() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.StudentList)));
		String line = bufferedReader.readLine();
		return line;
	}
}