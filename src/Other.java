/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
public class Other extends ReferenceDocument {
    
     // Constructors
       public Other ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = " ";
        PagesNo = " ";
    }
       
    public Other (String title, String author, String publisher, String pYear, String pages)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
    }
}
