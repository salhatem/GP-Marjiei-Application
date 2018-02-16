/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
import java.util.Date;
public class WebPage extends ReferenceDocument {
    private Date AccessDate;
    private String URL;
    
      // Constructors
       public WebPage ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = 0;
        PagesNo = " ";
        AccessDate = null;
        URL = " ";
    }
       
    public WebPage (String title, String author, String publisher, int pYear, String pages, Date aDate, String url)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        AccessDate = aDate;
        URL = url; 
    }
}
