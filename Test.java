import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

public class Test {
	public static void main(String [] args) throws MalformedURLException, IOException{
		String path = "http://api.nbp.pl/api/exchangerates/rates/A/EUR/";
		URL url = new URL(path);

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

		Pattern pattern = Pattern.compile(".*\"(\\d{4}-\\d{2}-\\d{2})\".*(\\d.\\d{4}).*");

		String line = "";
		while((line = br.readLine()) != null) {
			//System.out.println(line);
			Matcher matcher = pattern.matcher(line);
			while(matcher.find()) {
				String s = "Œredni kurs EURO: " + matcher.group(2) + "\nna dzieñ " + matcher.group(1);
			JOptionPane.showMessageDialog(null, s, "Info",  JOptionPane.PLAIN_MESSAGE);
}			
		}
		br.close();
	}
}