/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
public class Book extends ReferenceDocument {
    private int Edition;
    
    // Constructors
       public Book ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = 0;
        PagesNo = " ";
        Edition = 0;
    }
       
    public Book (String title, String author, String publisher, int pYear, String pages, int edition)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        Edition = edition; 
    }
}
