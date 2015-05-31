package pum.android.project.tools;

import java.util.List;

public class Recipe {

	public long id;
	public String name;
	public List<String> images;
	public String ingredients;
	public String description;
    public String image;
	public Recipe() {
	}

	public Recipe(String name) {
		this.name = name;
	}

	public Recipe(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Recipe(long id,String name,String image){
        this.id=id;
        this.name=name;
        this.image=image;
    }
    public Recipe(long id,String name,String ingredients,String description){
        this.id=id;
        this.name=name;
        this.ingredients=ingredients;
        this.description=description;
    }

}
