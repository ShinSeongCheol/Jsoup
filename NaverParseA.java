package jsoupProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NaverParseA {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document doc =  Jsoup.connect("https://comic.naver.com/webtoon/detail?titleId=736989&no=90").get();
//			System.out.println(doc);
//			
			Elements element = doc.select("img");
			System.out.println(element);
			
			FileOutputStream fileOutputStream = null;
			for(int i=0; i<element.size(); i++) {
				System.out.println(element.get(i).attr("src"));
				URL url = new URL(element.get(i).attr("src"));
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("Referer", "https://comic.naver.com/webtoon/detail?titleId=736989&no=90");
				BufferedImage img = ImageIO.read(connection.getInputStream());
				File file = new File("C:\\Users\\cher3\\Desktop\\JsuopParsing\\IMAGE_" + (i+1) + ".png");
				fileOutputStream = new FileOutputStream(file);
				ImageIO.write(img, "png", fileOutputStream);
			}
			
			fileOutputStream.close();
			System.out.println(element);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
