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
    private String Edition;
    
    // Constructors
       public Book ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = 0;
        PagesNo = " ";
        Edition = " ";
    }
       
    public Book (String title, String author, String publisher, int pYear, String pages, String edition)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        Edition = edition; 
    }

    /**
     * @return the Edition
     */
    public String getEdition() {
        return Edition;
    }

    /**
     * @param Edition the Edition to set
     */
    public void setEdition(String Edition) {
        this.Edition = Edition;
    }
}
