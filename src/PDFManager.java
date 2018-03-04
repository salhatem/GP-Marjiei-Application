import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.apache.pdfbox.cos.COSDocument;
//import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
//import org.apache.pdfbox.text.PDFTextStripper;
//import java.time.format.DateTimeFormatter;

public class PDFManager {
   //private PDFParser parser;
   //private PDFTextStripper pdfStripper;
   //private PDDocument pdDoc;
   //private COSDocument cosDoc;
   
   //private String Text, fileName;
   private String filePath, author, title;
   private File file;
   private int numberOfPages;
   private Connection con; 
   private Statement stmt;
   private ResultSet rs;
   String Query; 
   

   
   private void DatabaseConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = "jdbc:mysql://localhost:3306/mg-marjieidb";
            String username = "root";
            String password = ""; 
            String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
            con = DriverManager.getConnection( host+unicode, username, password );
            stmt = con.createStatement();
            
        } catch ( ClassNotFoundException | SQLException err ) {
          System.out.println( err.getMessage( ) ); }
    }
      
    public PDFManager() {
       DatabaseConnect(); 
    }
   public void ToText() throws IOException
   {
       //this.pdfStripper = null;
       //this.pdDoc = null;
       //this.cosDoc = null;
       
       file = new File(filePath);
       
       //parser = new PDFParser(new RandomAccessFile(file,"r")); // update for PDFBox V 2.0
       //parser.parse();
       //cosDoc = parser.getDocument();
       //pdfStripper = new PDFTextStripper();
       //pdDoc = new PDDocument(cosDoc);
       //pdDoc.getNumberOfPages();
       //pdfStripper.setStartPage(1);
       //pdfStripper.setEndPage(10);
       
       PDDocument document = PDDocument.load(file);
       PDDocumentInformation pdd = document.getDocumentInformation();
       author = pdd.getAuthor();
       title = pdd.getTitle();
       numberOfPages = document.getNumberOfPages();
       
       //reading text from page 1 to 10
       // if you want to get text from full pdf file use this code
       // pdfStripper.setEndPage(pdDoc.getNumberOfPages());  
       //Text = pdfStripper.getText(pdDoc);
       if(author == null){
           author = "";
       }
       else if(title == null){
           title = "";
       }
       // Code to insert book information here.
             try 
              {
                // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
                //   LocalDate localDate = LocalDate.now();
                 stmt = con.createStatement();
                 stmt.executeUpdate("INSERT INTO referencedocument (documentType, title, author, pages)"+" VALUES ('book', '"+title+"', '"+author+"', '"+numberOfPages+"')"); 
                 rs = stmt.executeQuery("SELECT documentID FROM referencedocument WHERE title = '"+ title +"' AND author = '"+ author +"'");
                 rs.next();
                 int id = rs.getInt("documentID");
                 stmt.executeUpdate("INSERT INTO book (documentID)"+" VALUES ( '"+ id +"')");
              } catch (SQLException ex)
                  {
                    System.out.println(ex.getMessage());
                  }
   }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    } 
}
