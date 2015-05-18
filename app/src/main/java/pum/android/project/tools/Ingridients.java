package pum.android.project.tools;

/**
 * Created by seba on 18.05.15.
 */
public class Ingridients {
    public long id;//id w bazie
    public String name;//nazwa do wyswietlenia
    public String image;
    public Ingridients(long id,String name,String image){
        this.id=id;
        this.name=name;
        this.image=image;
    }
}
