package org.smatmenu.DB;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.smartmenu.model.Dish;
import org.smartmenu.model.Promotion;

public class PromotionDaoImp extends BasicDAO<Promotion, ObjectId> implements PromotionDao {

	public PromotionDaoImp(Class<Promotion> entityClass, Datastore ds) 
	{
		super(entityClass, ds);
	}
	
	public List<Promotion>	getAllItems()
	{
		 Datastore ds = getDatastore();
	     return ds.createQuery(Promotion.class).asList();
	}
}
