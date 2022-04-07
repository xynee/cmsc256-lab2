package cmsc256;



public class MyBook implements Comparable<MyBook> {
    private String title, authorFirstName, authorLastName;
    private String ISBN10, ISBN13;


    public MyBook(){
        this.title = "None Given";
        this.authorFirstName = "None Given";
        this.authorLastName = "None Given";
        this.ISBN10 = "0000000000";
        this.ISBN13 = "0000000000000";
    }

    public MyBook (String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13){
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.ISBN10 = ISBN10;
        this.ISBN13 = ISBN13;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthorFirstName(){
        return authorFirstName;
    }

    public String getAuthorLastName(){
        return authorLastName;
    }

    public String getISBN10(){
        return ISBN10;
    }

    public String getISBN13(){
        return ISBN13;
    }

    public void setTitle(String title){
        this.title = title;
        if (this.title == null) {
            throw new IllegalArgumentException("Null is not permitted");
        }
    }

    public void setAuthorFirstName(String authorFirstName){
        this.authorFirstName = authorFirstName;
        if (this.authorFirstName == null) {
            throw new IllegalArgumentException("Null is not permitted");
        }
    }

    public void setAuthorLastName(String authorLastName){
        this.authorLastName = authorLastName;
        if (this.authorLastName == null) {
            throw new IllegalArgumentException("Null is not permitted");
        }
    }

    public void setISBN10 (String ISBN10){
        this.ISBN10 = ISBN10;
        if (ISBN10.length() != 10){
            throw new IllegalArgumentException("Value length does not match");
        }
        for (int x = 0; x < ISBN10.length(); x++){
            if (!Character.isDigit(ISBN10.charAt(x))){
                throw new IllegalArgumentException("Value contains unaccepted characters");
            }
        }
    }

    public void setISBN13 (String ISBN13){
        this.ISBN13 = ISBN13;
        if (ISBN13.length() != 13){
            throw new IllegalArgumentException("Value length does not match");
        }
        for (int x = 0; x < ISBN13.length(); x++){
            if (!Character.isDigit(ISBN13.charAt(x))){
                throw new IllegalArgumentException("Value contains unaccepted characters");
            }
        }
    }

    public String toString(){
        return "Title: " + this.title + "\n" + "Author: " + this.authorFirstName + " " +
                this.authorLastName + "\n" + "ISBN10: " + this.ISBN10 + "\n" + "ISBN13: " + this.ISBN13;
    }

    public boolean equals(Object otherBook){
        if (otherBook == this){
            return true;
        }
        if (!(otherBook instanceof MyBook)){
            return false;
        }

        MyBook other = (MyBook) otherBook;

        return ISBN10.equals(other.ISBN10) && ISBN13.equals(other.ISBN13);
    }

    public int compareTo (MyBook other){
        int result = getAuthorLastName().compareTo(other.getAuthorLastName());
        if(result == 0){
            result = getAuthorFirstName().compareTo(other.getAuthorFirstName());
        }
        if(result == 0){
            result = getTitle().compareTo(other.getTitle());
        }
        return result;
    }





}
