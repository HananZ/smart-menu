package org.smatmenu.DB;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.smartmenu.common.ErrorCode;
import org.smartmenu.common.ParameterCatalog;
import org.smartmenu.model.Dish;


public class DishDaoImp extends BasicDAO<Dish, ObjectId> implements DishDao 
{
	
	public DishDaoImp(Class<Dish> entityClass, Datastore ds) 
	{
		super(entityClass, ds);
	}	
	
	public Dish getDishByObjectId(String objectId)
	{
		    Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.OBJECTID).equal(objectId);
			return itemsQuery.get();
	}
	
	public Dish getDishByEnglishTitle(String title_EN)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_TITLE_EN).equal(title_EN);
		return itemsQuery.get();
	}
	public Dish getDishByArabicTitle(String title_AR)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_TITLE_AR).equal(title_AR);
		return itemsQuery.get();
	}
	
	public Dish getDishByArabicDescription(String description_AR)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_DESCRIPTION_AR).equal(description_AR);
		return itemsQuery.get();
	}
	
	public Dish getDishByRate(Integer rate)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_RATE).equal(rate);
		return itemsQuery.get();
	}
	public Dish getDishbyPhoto(String photoUrl)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_PHOTO_URL).equal(photoUrl);
		return itemsQuery.get();
	}
	public Dish getDishByPrice(Integer price)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_PRICE).equal(price);
		return itemsQuery.get();
	}
	
	public Dish getDishByLatestReview(String review)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_LATEST_REVIEW).equal(review);
		return itemsQuery.get();
	}
	public Dish getDishByCategoryId(Integer categoryId)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_CATEGORY_ID).equal(categoryId);
		return itemsQuery.get();
	}
	public Dish getDishBySubCategory(Integer subCategoryId)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.DISH_SUB_CATEGORY_ID).equal(subCategoryId);
		return itemsQuery.get();
	}
	
	public Dish getDishByStatus(String status)
	{
		Query<Dish>  itemsQuery = createQuery().field(ParameterCatalog.STATUS).equal(status);
		return itemsQuery.get();	
	}
	public List<Dish> getAllDishes()
	{
		 Datastore ds = getDatastore();
	     return ds.createQuery(Dish.class).asList();
	}
	public List<Dish> getDishByDescriptiveId (String DescriptiveId )
	{
		
		List<Dish> dishes = new ArrayList();		
		try
		{
		 
		Query<Dish>  itemsQuery;
		
		 switch (DescriptiveId)
		 {
         case ParameterCatalog.MAIN_MENU_URI:
         {
        	
         	 itemsQuery = createQuery().field(ParameterCatalog.STATUS).equal("active");
         	 dishes.addAll(itemsQuery.asList());
             break;
         } 
         case ParameterCatalog.MOST_POPULAR_URI:
         {
        	 itemsQuery = createQuery().field(ParameterCatalog.STATUS).equal("active")
        			 .field(ParameterCatalog.DISH_ORDERES_COUNT)
        			 .greaterThan(0).order("-"+ParameterCatalog.DISH_ORDERES_COUNT).limit(5);
        	 dishes.addAll(itemsQuery.asList());
                  break;
         }
         case ParameterCatalog.MOST_RATED_URI:
         {
        	 itemsQuery = createQuery().field(ParameterCatalog.STATUS).equal("active")
        			 .field(ParameterCatalog.DISH_RATE)
        			 .greaterThanOrEq(4).order("-"+ParameterCatalog.DISH_RATE);  
        	 dishes.addAll(itemsQuery.asList());
                  break;
         }
        
          
	}
		 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + ErrorCode.GET_CATEGORY_MENU_DATA);		
		}
		
		return dishes;
		 
	}
	
	
	
}
