package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WebGet {

//    <!-- https://mvnrepository.com/artifact/org.jsoup/jsoup -->
//<dependency>
//    <groupId>org.jsoup</groupId>
//    <artifactId>jsoup</artifactId>
//    <version>1.16.1</version>
//</dependency>
    public WebGet(){
//            new Thread(()->{ // ביצוע תהליכון שרץ כל הזמן על האתר מכיוון שמתעדכן
//                try {
                    while (true) {
                        Document document = null;// לקחת את הדומקמין השלישי המתאים לאובקייט.
                        try {
                            document = Jsoup.connect("https://www.one.co.il/").get();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(document.title()); //לוקח את הכותרת של הלשונית- בדיקה ראשונית
                        Element mainArticleEleElement = document.getElementById("_ctl0_ContentHolder_Body_ucArticleMain_hlTitle");// לוקחת אלמנט של הכותרת ראשית לפי id
                        if (mainArticleEleElement != null) { //בודק שהאלמנט אינו ריק
                            String content = mainArticleEleElement.text();
                            System.out.println(content);
                        } else {
                            System.out.println("Cannot find element!");
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

//            });

        }


