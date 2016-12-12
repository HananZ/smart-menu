package org.smatmenu.DB;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.smartmenu.model.RecommendedFromChef;


public class RecommendedFromChefDaoImp extends BasicDAO<RecommendedFromChef, ObjectId> implements RecommendedFromChefDao 
{
	public RecommendedFromChefDaoImp(Class<RecommendedFromChef> entityClass, Datastore ds) 
	{
		super(entityClass, ds);
	}
	public List<RecommendedFromChef> getAllItems()
	{
   
   	 Datastore ds = getDatastore();
   	 return ds.createQuery(RecommendedFromChef.class).asList();	 
    }
	

}
