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
        PublishYear = " ";
        PagesNo = " ";
        ConferenceName = " ";
        Place = " ";
    }
       
    public ConferenceProceeding (String title, String author, String publisher, String pYear, String pages, String cName, String place)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        ConferenceName = cName;
        Place = place; 
    }
    
    /**
     * @return the ConferenceName
     */
    public String getConferenceName() {
        return ConferenceName;
    }

    /**
     * @param ConferenceName the ConferenceName to set
     */
    public void setConferenceName(String ConferenceName) {
        this.ConferenceName = ConferenceName;
    }

    /**
     * @return the Place
     */
    public String getPlace() {
        return Place;
    }

    /**
     * @param Place the Place to set
     */
    public void setPlace(String Place) {
        this.Place = Place;
    }
}
