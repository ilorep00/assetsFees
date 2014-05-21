package es.unileon.ulebank.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChangeMethod {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Min(1)
    @Max(5)
    private int type;
    
    public void setType(int i) {
        type = i;
        logger.info("Type set to " + i);
    }

    public int getType() {
        return type;
    }
}
