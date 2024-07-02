package activities;

abstract class Book {
    String title;
    abstract void setTitle(String S);
    public String getTitle(){
        return title;
    }
}