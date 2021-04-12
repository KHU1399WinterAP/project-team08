package models;

public class Setting {
    public int id;
    public int themeId;
    public Setting ( int id , int themeId){
        this.id= id;
        this.themeId = themeId;

    }
    @Override
    public String toString(){
        return " settings{" +
                "id =" +id+
                ",themeId = " + themeId +
                "}" ;

    }
}