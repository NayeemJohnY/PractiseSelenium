package seleniumEasy;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class HandleDate {

	
@Test
void DateTime()
{
	SimpleDateFormat dateformat= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	Date date=new Date();
	String date1=dateformat.format(date);
	System.out.println(date1);
}
}
