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
        PublishYear = " ";
        PagesNo = " ";
        MagazineName = " ";
        Month = " ";
    }
       
    public MagazineArticle (String title, String author, String publisher, String pYear, String pages, String mName, String month)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        MagazineName = mName;
        Month = month; 
    }

    /**
     * @return the MagazineName
     */
    public String getMagazineName() {
        return MagazineName;
    }

    /**
     * @param MagazineName the MagazineName to set
     */
    public void setMagazineName(String MagazineName) {
        this.MagazineName = MagazineName;
    }

    /**
     * @return the Month
     */
    public String getMonth() {
        return Month;
    }

    /**
     * @param Month the Month to set
     */
    public void setMonth(String Month) {
        this.Month = Month;
    }
}
