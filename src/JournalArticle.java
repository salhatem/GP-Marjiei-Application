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
    private String Volume;
    
      // Constructors
       public JournalArticle ()
    {
        Title = " "; 
        Author = " "; 
        Publisher = " "; 
        PublishYear = " ";
        PagesNo = " ";
        JournalName = " ";
        Volume = " ";
    }
       
    public JournalArticle (String title, String author, String publisher, String pYear, String pages, String jName, String volume)
    {
        Title = title; 
        Author = author; 
        Publisher = publisher; 
        PublishYear = pYear;
        PagesNo = pages;
        JournalName = jName;
        Volume = volume;
    }

    /**
     * @return the JournalName
     */
    public String getJournalName() {
        return JournalName;
    }

    /**
     * @param JournalName the JournalName to set
     */
    public void setJournalName(String JournalName) {
        this.JournalName = JournalName;
    }

    /**
     * @return the Volume
     */
    public String getVolume() {
        return Volume;
    }

    /**
     * @param Volume the Volume to set
     */
    public void setVolume(String Volume) {
        this.Volume = Volume;
    }
}
