package jsoupProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleParsing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		String url = "https://www.google.com/search?q=" + title +"&sxsrf=ALeKk03gTH-dopPn4K9rCBVQRXmiKh5DSg:1628172554915&source=lnms&tbm=isch&sa=X&ved=2ahUKEwin4JK2h5ryAhUDCd4KHbLaA5AQ_AUoAXoECAEQAw&biw=1745&bih=881";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.getElementsByAttributeValue("jsname", "Q4LuWd");
		
		File path = null;
		URL imageUrl = null;
		BufferedImage img = null;
		
		for(int i=0; i<elements.size(); i++) {
//			if(elements.get(i).hasAttr("src")) {
//				System.out.println(elements.get(i).attr("src"));
//				path = new File("C:\\Users\\cher3\\Desktop\\JsuopParsing\\" + title + i + ".jpg");
//				imageUrl = new URL(elements.get(i).attr("src"));
//				img = ImageIO.read(imageUrl);
//				ImageIO.write(img, "jpg", path);
			 if(elements.get(i).hasAttr("data-src")) {
				System.out.println(elements.get(i).attr("data-src"));
				path = new File("C:\\Users\\cher3\\Desktop\\JsuopParsing\\" + title + i + ".jpg");
				imageUrl = new URL(elements.get(i).attr("data-src"));
				img = ImageIO.read(imageUrl);
				ImageIO.write(img, "jpg", path);
			}
		}
		sc.close();
	}

}
