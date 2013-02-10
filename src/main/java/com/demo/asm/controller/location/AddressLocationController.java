package com.demo.asm.controller.location;

/**
 * The Location controller is used to executed any view related functions like validation or model processing
 * It also serves as connection between the view and the rest of the business and DB connection logic
 * @author Ignas Nikolejev
 */
public interface AddressLocationController {
    /**
     * Created new unit of the controller entity type and stores it in selected field
     */
    public void createNew();

    /**
     * Send request to service to execute the save method for  selected field
     */
    public void save();

    /**
     * Send request to service to execute the delete method for  selected field
     */
    public void delete();

    /**
     * Executes this method to refresh data before the view is rendered
     */
    public void updateData();
}
