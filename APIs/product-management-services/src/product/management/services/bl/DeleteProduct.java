package product.management.services.bl;

import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.utilities.constants.CommonConstants;
import product.management.services.beans.ProductManagementRequest;
import product.management.services.beans.ProductManagementResponse;
import product.management.services.dao.AbstractProductManagementServicesDao;

public class DeleteProduct extends AbstractProductManagementServicesHandler {
	private static final Logger logger = LoggerFactory.getLogger(DeleteProduct.class);

	public ProductManagementResponse productManagementService(ProductManagementRequest productManagementRequest, Connection connection) {
		ProductManagementResponse productManagementResponse = null;	
		productManagementResponse = new ProductManagementResponse();
		if (null == productManagementRequest || null == productManagementRequest.getProduct()) {
			logger.info(logger.isInfoEnabled() ? "Couldn't proceed as product requested content has been passed empty ...": null);
			productManagementResponse.setResponseCode(CommonConstants.INVALID_TRANS);
			productManagementResponse.setResponseDesc(CommonConstants.INVALID_TRANS_DESCRIPTION);
			return productManagementResponse;
		}
		logger.info(logger.isInfoEnabled() ? "Going to delete product for user id: ": null);
		AbstractProductManagementServicesDao.getInstance().deleteProduct(productManagementRequest, connection);
		productManagementResponse.setResponseCode(CommonConstants.SUCCESS);
		productManagementResponse.setResponseDesc(CommonConstants.SUCCESS_DESCRIPTION);
		return productManagementResponse;
	}
}