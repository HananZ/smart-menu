package org.smatmenu.DB;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.smartmenu.common.ErrorCode;
import org.smartmenu.common.ParameterCatalog;
import org.smartmenu.model.Promotion;
import org.smartmenu.model.RecommendedFromChef;
import org.smartmenu.model.Review;

public class ReviewDaoImp extends BasicDAO<Review, ObjectId> implements ReviewDao
{
	public ReviewDaoImp(Class<Review> entityClass, Datastore ds) 
	{
		super(entityClass, ds);
	}
	public List<Review> getAllReviews(Integer itemId)
	{
		List<Review> reviewsList= new ArrayList();
		try
		{
			 Datastore ds = getDatastore();			 
			 reviewsList =  ds.createQuery(Review.class).field(ParameterCatalog.REVIEWED_ITEM_ID).equal(itemId).asList();			
		}
		catch(Exception e)
		{
			System.out.println(ErrorCode.GET_ITEMS_REVIEWS);
			return null;
		}	
		return reviewsList;
	}

}
