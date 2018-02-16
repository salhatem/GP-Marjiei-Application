/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatha Suliman
 */
public class ConferenceProceeding extends ReferenceDocument {
    private String ConferenceName;
    private String Place;
    
     // Constructors
       public ConferenceProceeding ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = 0;
        PagesNo = " ";
        ConferenceName = " ";
        Place = " ";
    }
       
    public ConferenceProceeding (String title, String author, String publisher, int pYear, String pages, String cName, String place)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        ConferenceName = cName;
        Place = place; 
    }
}
