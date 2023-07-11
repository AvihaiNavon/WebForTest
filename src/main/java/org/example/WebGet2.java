package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class WebGet2 {
    public WebGet2(){
        while (true) {
            Document document = null;// לקחת את הדומקמין השלישי המתאים לאובקייט.
            try {
                document = Jsoup.connect("https://www.one.co.il/").get();

            List<Element>elementsList=document.getElementsByClass("one-article one-article-secondary");// לוקח את כל האלמנטים עם ה id הנוכחי
            for(Element element:elementsList){
                System.out.println("-----כל התיבת טקסט---");
                System.out.println(element.text()); //מדפיס את כל האלמנטים, עם כל המלל המלא זה האבא של הכותרת
                if(element.children().size()>1){ // אם יש לו גורמים בפנים
                    Element title=element.child(1);// תיקח את הגורם השני
                    System.out.println("-----מדפיס את הכותברת מתוך התיבת טקסט-----");
                    System.out.println(title.text());// תדפיס את הטקסט שלו
                    String link=element.attr("href");//בודק אם יש לו תכונה של קישור לאתר פנימי
                    if(link!=null){
                        Document article=Jsoup.connect("https://www.one.co.il"+link).get();
                        System.out.println("-----מדפיס את הטקסט מתוך הקישור לכתבה-----");
                        List<Element>elements=article.getElementsByClass("article-body-container");
                        System.out.println(elements.get(0).text());

                    }

                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
