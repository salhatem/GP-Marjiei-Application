/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
public class MagazineArticle extends ReferenceDocument {
    private String MagazineName;
    private String Month;
    
     // Constructors
       public MagazineArticle ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = 0;
        PagesNo = " ";
        MagazineName = " ";
        Month = " ";
    }
       
    public MagazineArticle (String title, String author, String publisher, int pYear, String pages, String mName, String month)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        MagazineName = mName;
        Month = month; 
    }
}
