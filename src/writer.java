import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class writer {
	public writer(String str[], int meannum[], int selectednum) {
		int number = 0;
		boolean pass = true;
		Random rm = new Random();
		int rannum[] = new int[selectednum];
		String txt[] = new String[selectednum];
		Date date = new Date();
 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String fileName = dateformat.format(date) + " 문제.txt";
		
		for (int i=0; i<selectednum; i++) {
			rannum[i] = rm.nextInt(selectednum);
			for (int j=0; j<i; j++) {
				if(rannum[i]==rannum[j]) {
					i--;
				}
			}
		}
		
		
		try {
			File file = new File(fileName);
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
		
			for (int i=0; i<selectednum; i++) {
				number++;
				if (meannum[rannum[i]] == 1) {
					fw.write(Integer.toString(number) + ". " + str[rannum[i]] + "\r\n");
				}
				else
					fw.write(Integer.toString(number) + ". " + str[rannum[i]] + " (" + Integer.toString(meannum[rannum[i]]) + ")" + "\r\n");
				fw.flush();
			}
			//파일 안에 문자열 쓰기
		//	if (meannum == 1)
		//		fw.write(Integer.toString(number) + ". " + str + "\r\n");
		//	else
		//		fw.write(Integer.toString(number) + ". " + str + " (" + Integer.toString(meannum) + ")" +  "\r\n");

			fw.flush();
			
			//객체 닫기
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
