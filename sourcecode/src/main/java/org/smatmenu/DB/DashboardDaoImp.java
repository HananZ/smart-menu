package org.smatmenu.DB;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.smartmenu.common.ParameterCatalog;
import org.smartmenu.model.DashboardItem;


public class DashboardDaoImp extends BasicDAO<DashboardItem, ObjectId> implements DashboardDao 
{
	
	public DashboardDaoImp(Class<DashboardItem> entityClass, Datastore ds) 
	{
		super(entityClass, ds);
	}
	public DashboardItem getItemByOrder(Integer order)
	{
	    Query<DashboardItem>  itemsQuery = createQuery().field(ParameterCatalog.DASHBOARD_ITEM_ORDER).equal(order);
		return itemsQuery.get();
	}
	
	public DashboardItem getItemByObjectId(Integer objectid)
	{
		  Query<DashboardItem>  itemsQuery = createQuery().field(ParameterCatalog.OBJECTID).equal(objectid);
		  return itemsQuery.get();
	}
	
	public DashboardItem getItemByUrl(String url)
	{
		 Query<DashboardItem>  itemsQuery = createQuery().field(ParameterCatalog.DASHBOARD_ITEM_URL).equal(url);
		 return itemsQuery.get();
	}
	public DashboardItem getItemByEnglishText(String englishText)
	{
		Query<DashboardItem>  itemsQuery = createQuery().field(ParameterCatalog.DASHBOARD_ITEM_ENG_TEXT).equal(englishText);
		return itemsQuery.get();
	}
	public DashboardItem getItemByArabicText(String arabicText)
	{
		Query<DashboardItem>  itemsQuery = createQuery().field(ParameterCatalog.DASHBOARD_ITEM_AR_TEXT).equal(arabicText);
		return itemsQuery.get();
	}
	public List<DashboardItem> getAllItems()
	{
		 Datastore ds = getDatastore();
	     return ds.createQuery(DashboardItem.class).asList();
	}

}
