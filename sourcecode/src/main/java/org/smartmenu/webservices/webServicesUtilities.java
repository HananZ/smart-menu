package org.smartmenu.webservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.smartmenu.common.ErrorCode;
import org.smartmenu.model.DashboardItem;
import org.smartmenu.model.Dish;
import org.smartmenu.model.Promotion;
import org.smartmenu.model.RecommendedFromChef;
import org.smatmenu.DB.DashboardDaoImp;
import org.smatmenu.DB.DishDaoImp;
import org.smatmenu.DB.MorphiaService;
import org.smatmenu.DB.PromotionDaoImp;
import org.smatmenu.DB.RecommendedFromChefDaoImp;
import com.google.gson.Gson;
import com.mongodb.DBObject;



public class webServicesUtilities 
{
	

	private MorphiaService morphiaObj ; 

	
	
	// constructor
	webServicesUtilities()
	{	
		this.morphiaObj = new MorphiaService();
	}
	
	/**
	 * Method gets all rows from dashboard items table 
	  * @return dashboard items list 
	 */
	public List<DashboardItem> getAllItemsFromDashboardItemsTable ()
	{
		List<DashboardItem> TableDocuments= new ArrayList<DashboardItem>();
	  try
		{
		DashboardDaoImp _dao = new DashboardDaoImp(DashboardItem.class, morphiaObj.getDatastore());		
		TableDocuments.addAll(_dao.getAllItems());
		
		}
	  catch(Exception ex)
	  {
		 System.out.println(ErrorCode.GET_DASHBOARD_ITEMS_ERROR);
	  }
	  return TableDocuments;	    
		
	}
	
	
	/**
	 * Method gets menu from dish table (most popular/rated/main menu categories) 
	  * @return dishes Map list
	 */
	public List<Map<String,Object>> getCategoryMenuFromDishesTable (DashboardItem item)
	{
		
		
		Map<String,Object> result =  new HashMap<String,Object>();
	    List<Map<String,Object>> resultList = new ArrayList();
		try
		{
		DishDaoImp _dishDao = new DishDaoImp(Dish.class, morphiaObj.getDatastore());
		List<Dish> menuDishes = new ArrayList(); 
		menuDishes.addAll(_dishDao.getDishByDescriptiveId(item.getDescriptive_URI()));
		result.put(item.getText_EN(),menuDishes);
		}
		catch(Exception e )
		{
			System.out.println(ErrorCode.GET_CATEGORY_MENU_DATA);
			
		}
		resultList.add(result);
		return resultList;
	}
	
	/**
	 * Method gets menu from recommended from chef table 
	  * @return dishes Map list
	 */
	public List<Map<String,Object>> getRecommendedFromChefDishes (DashboardItem item)
	{
		
		Map<String,Object> result =  new HashMap<String,Object>();
		 List<Map<String,Object>> resultList = new ArrayList();
		try
		{
			RecommendedFromChefDaoImp _dao = new RecommendedFromChefDaoImp(RecommendedFromChef.class, morphiaObj.getDatastore());
			result.put(item.getText_EN(), _dao.getAllItems());
		}
		catch(Exception e)
		{
		    System.out.println(ErrorCode.GET_CATEGORY_MENU_DATA);
		}
		resultList.add(result);
		return resultList;		
	}
	
	/**
	 * Method gets menu from promotion table 
	  * @return dishes Map list
	 */
	public List<Map<String,Object>> getPromotions (DashboardItem item)
	{
		
		Map<String,Object> result =  new HashMap<String,Object>();
		 List<Map<String,Object>> resultList = new ArrayList();
		try
		{
			PromotionDaoImp _PromotionDao = new PromotionDaoImp(Promotion.class, morphiaObj.getDatastore());
			result.put(item.getText_EN(),_PromotionDao.getAllItems());
		}
		catch(Exception ex)
		{
			 System.out.println(ErrorCode.GET_CATEGORY_MENU_DATA);
		}
		resultList.add(result);
		return resultList;
	}
	
	
	
	}
		

	


