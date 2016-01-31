package com.unitn.process_centric_service;

import com.unitn.local_database.UserData;
import com.unitn.storage_service.Goal;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by erinda on 1/24/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface ProcessCentricService {
    @WebMethod()
    @WebResult()
    String getDescription();


    @WebMethod
    @WebResult
    boolean userExists(int telegramId);

    @WebMethod
    @WebResult
    boolean registerNewUser(UserData user);


    @WebMethod
    @WebResult
    boolean saveGoal(int telegramId, Goal goal);

}
