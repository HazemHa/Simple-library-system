/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

/**
 *
 * @author Hazem
 */
public interface communicationManager {

    int STATUS_SUCCESSFUL = 1;
    int STATUS_FAILURE = 2;
    int STATUS_NOT_FOUND = 3;
    int STATUS_SEARCH = 4;

    void OnCompete(Message msg);

    void OnFailure(Message msg);

}
