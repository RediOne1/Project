package pum.android.project.tools;

import java.util.List;

/**
 * author:  Adrian Kuta
 * index:   204423
 * date:    08.05.15
 */
public class Recipe {

	public long id;
	public String name;
	public List<String> images;
	public String ingredients;
	public String description;

	public Recipe() {
	}

	public Recipe(String name) {
		this.name = name;
	}
    public Recipe(long id,String name,String ingredients,String description){
        this.id=id;
        this.name=name;
        this.ingredients=ingredients;
        this.description=description;
    }

}
