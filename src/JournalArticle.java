/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
public class JournalArticle extends ReferenceDocument {
    private String JournalName;
    private int Volume;
    
      // Constructors
       public JournalArticle ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = 0;
        PagesNo = " ";
        JournalName = " ";
        Volume = 0;
    }
       
    public JournalArticle (String title, String author, String publisher, int pYear, String pages, String jName, int volume)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        JournalName = jName;
        Volume = volume;
    }
}
