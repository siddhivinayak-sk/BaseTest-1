package poitest;

/**
 *
 * @author Mohit.sareen
 */
public class RHMetaInfo1 
{
    private static String eisbn;
    private static String start_page;
    private static String coverPath;
    private static String isbn;
    private static String title;
    private static String subTitle;
    private static String author;
    private static String division;
    private static String imprint;
    private static String onSaleDate;
    
    public static void setCoverPath(String coverPath) {
        RHMetaInfo1.coverPath = coverPath;
    }

    public static String getCoverPath() {
        return coverPath;
    }
    
    public static void setEisbn(String eisbn) {
        RHMetaInfo1.eisbn = eisbn;
    }

    public static void setStart_page(String start_page) {
        RHMetaInfo1.start_page = start_page;
    }
        
    public static String getEisbn() {
        return eisbn;
    }

    public static String getStart_page() {
        return start_page;
    }
    
    public static void setIsbn(String isbn) {
        RHMetaInfo1.isbn = isbn;
    }

    public static String getIsbn() {
        return isbn;
    }
    
    public static void setTitle(String title) {
        RHMetaInfo1.title = title;
    }

    public static String getTitle() {
        return title;
    }
    
    public static void setSubTitle(String subTitle) {
        RHMetaInfo1.subTitle = subTitle;
    }

    public static String getSubTitle() {
        return subTitle;
    }
    
    public static void setAuthor(String author) {
        RHMetaInfo1.author = author;
    }

    public static String getAuthor() {
        return author;
    }
    
    public static void setDivision(String division) {
        RHMetaInfo1.division = division;
    }

    public static String getDivision() {
        return division;
    }
    
      public static void setImprint(String imprint) {
        RHMetaInfo1.imprint = imprint;
    }

    public static String getImprint() {
        return imprint;
    }
    
    public static void setOnSaleDate(String onSaleDate) {
        RHMetaInfo1.onSaleDate = onSaleDate;
    }

    public static String getOnSaleDate() {
        return onSaleDate;
    }    
}