package com.kashu.property.editors;

import java.beans.PropertyEditorSupport;
import com.kashu.domain.Category;

public class CategoryEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String id) 
    {
    	Category c;
    	switch(Integer.parseInt(id))
		{
			case 1: c = new Category(1l,  "jam"); break;
			case 2: c = new Category(2l,  "router"); break;
			case 3: c = new Category(3l,  "book"); break;
			default: c = null;
		}
        this.setValue(c);
    }
}
