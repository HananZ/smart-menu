package org.smartmenu.webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import org.smartmenu.common.ErrorCode;
import org.smartmenu.common.ParameterCatalog;
import org.smartmenu.common.Required;
import org.smartmenu.model.DashboardItem;
import com.google.gson.Gson;
import javax.ws.rs.core.Response;


@Path("myresource")
public class MyResource {
	
	
	

/**
 * Method handling HTTP GET requests. The returned object will be sent
 * to the client as "text/plain" media type.
  * @return String that will be returned as a text/plain response.
 */
@GET
@Produces(MediaType.APPLICATION_JSON)
public String getIt() {
    return "test it!";
}
    
   
/**
this web service used to view  customer dash board items 
@param none
@return dash board items
 */
 @GET
 @Path("getDashBoardItems")
 @Produces(MediaType.APPLICATION_JSON)
  public Response getDashboardItems()
  { 	 
	 try
	 {	
		// initialize new object from web utilities class 
     webServicesUtilities utilityObj = new webServicesUtilities();     
	 List<DashboardItem> dashboarTableData = new ArrayList();	
	 
	 // get all data , store in  a list
	 dashboarTableData = utilityObj.getAllItemsFromDashboardItemsTable();	 
	 
	 
	 // convert  output to json.
	 return Response.ok(new Gson().toJson(dashboarTableData), MediaType.APPLICATION_JSON).build();	
	
	 }
	 catch ( Exception ex )
	 {		
	 return Response.status(Response.Status.NOT_FOUND).entity(ErrorCode.GET_DASHBOARD_ITEMS_ERROR).build();
		
	 } 
  }
 
 /**
 this web service used to view  selected category data 
 @param category descriptiveUrl 
 @return category json data 
  */
  @GET
  @Path("viewCategoryData")
  @Produces(MediaType.APPLICATION_JSON) 
   public Response viewSelectedCategoryData(@NotNull @QueryParam(ParameterCatalog.DASHBOARD_ITEM_URL) String descriptiveUrl)
   { 	 
 	 try
 	 {	
      webServicesUtilities utilityObj = new webServicesUtilities();	     
 	  List<DashboardItem> dashboardTableData = new ArrayList();	
 	  
 	  // get dashboard elements.
 	  dashboardTableData = utilityObj.getAllItemsFromDashboardItemsTable(); 
 	  
 	  // result object 
      List<Map<String,Object>> result  = null;	
 	  
      
      // loop to find the item that has the requested respictive_uri
 	  for (DashboardItem item : dashboardTableData )
 	  { 		  
 		
 		if ((item).getDescriptive_URI().equals(descriptiveUrl))
 		{
 			// if promotion category is required , call get promotion method , store it in the result Map
 			 if ((item.getDescriptive_URI()).equals(ParameterCatalog.PROMOTIONS_URI))
 			{
 				result=	utilityObj.getPromotions(item);
 		     	break;
 			}
 			// if recommended from chef  category is required , call get recommended method , store it in the result Map
 			 if ((item.getDescriptive_URI()).equals(ParameterCatalog.RECOMMENDED_FROM_CHEF_URI))
 			 {
 				 
 						result=	utilityObj.getRecommendedFromChefDishes(item);
 				break; 
 			 }
 			 
 			 // in case if the requested category is most rated or most popular : get menu from dish collection  
 			 else
 			 {
 				result=	utilityObj.getCategoryMenuFromDishesTable(item);
 				break;
 			 }
 		} 			
 	  }	 
      return Response.ok(new Gson().toJson(result), MediaType.APPLICATION_JSON).build();
 	 }
 	 catch ( Exception ex )
 	 {
 	 return Response.status(Response.Status.NOT_FOUND).entity(ErrorCode.GET_CATEGORY_MENU_DATA).build();		
 	 } 
   }
  

  
  /**
   * Method gets the order from the user and save it into DB
    * @return message indicates that the order is saved successfully
   */
//  @GET
//  @Path("getOrder")
//  @Produces(MediaType.APPLICATION_JSON)
//  public Response getOrderFromUser(@NotNull @QueryParam(ParameterCatalog.DASHBOARD_ITEM_URL) Object order) 
//  {
//	  try
//	  {
//		  
//	  }
//	  catch(Exception Ex)
//	  {
//		  return  Response.status(Response.Status.NOT_FOUND).entity(ErrorCode.GET_USER_ORDER).build();
//	  }
//     
//  }
// 
//
  
}

 
 
 
 
 

    
    
