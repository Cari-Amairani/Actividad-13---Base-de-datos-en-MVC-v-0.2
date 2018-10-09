/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package main;

import model.ModelAgenda;
import view.ViewAgenda;
import controller.ControllerAgenda;

public class MainAgenda {

    public static void main(String[] args) {
        
         ModelAgenda modelAgenda = new ModelAgenda();
        ViewAgenda viewAgenda = new ViewAgenda();
        ControllerAgenda controllerAgenda = new ControllerAgenda(modelAgenda, viewAgenda);
    }
    
}
