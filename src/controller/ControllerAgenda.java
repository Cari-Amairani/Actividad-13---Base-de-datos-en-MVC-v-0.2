/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import model.ModelAgenda;
import view.ViewAgenda;


public class ControllerAgenda {
    
    // Crea un objeto para modelo
     ModelAgenda modelAgenda;
     
    ViewAgenda viewAgenda;
    // Crea un objeto para la vista
    
     Statement st;
    ResultSet rs;
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jB_Primero) {
                jB_Primero_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Anterior){
                jB_Anterior_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Siguiente){
                jB_Siguiente_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Ultimo){
                jB_Ultimo_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Insertar){
               jB_Insertar_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Eliminar){
              jB_Eliminar_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Modificar){
              jB_Modificar_actionPerformed();
            }else if (e.getSource() ==  viewAgenda.jB_Nuevo){
                jB_Nuevo_actionPerformed();
            }
         }
    };
    
    
    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
        
    }
    
    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jTF_Nombre.setText(modelAgenda.getNombre());
        viewAgenda.jTF_Email.setText(modelAgenda.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda");
        viewAgenda.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jB_Primero.addActionListener(actionListener);
        viewAgenda.jB_Anterior.addActionListener(actionListener);
        viewAgenda.jB_Siguiente.addActionListener(actionListener);
        viewAgenda.jB_Ultimo.addActionListener(actionListener);
        viewAgenda.jB_Nuevo.addActionListener(actionListener);
        viewAgenda.jB_Insertar.addActionListener(actionListener);
        viewAgenda.jB_Modificar.addActionListener(actionListener);
        viewAgenda.jB_Eliminar.addActionListener(actionListener);
    }

    
    /**
     * Método para el boton Insertar
     */
         private void jB_Insertar_actionPerformed() {
             // Permite insertar almacenar los datos que se encuentran en las cajas de texto
        modelAgenda.setNombre(viewAgenda.jTF_Nombre.getText());
        modelAgenda.setEmail(viewAgenda.jTF_Email.getText());
        modelAgenda.Insertar();
         }
         
         
    /**
     * Método para el boton Eliminar
     */
         private void jB_Eliminar_actionPerformed() {
             // Elimina el nombre y el email del registro que deseemos
        viewAgenda.jTF_Nombre.setText(modelAgenda.getNombre());
        viewAgenda.jTF_Email.setText(modelAgenda.getEmail());
        modelAgenda.Eliminar();
         }

         
    /**
     * Método para el boton Modificar
     */
         private void jB_Modificar_actionPerformed() {
             // Modifica los datos que se reescribieron en las cajas detexto
        modelAgenda.setNombre(viewAgenda.jTF_Nombre.getText());
        modelAgenda.setEmail(viewAgenda.jTF_Email.getText());
        modelAgenda.Modificar();
         }

         
    /**
     * Método para el boton Nuevo
     */
         private void jB_Nuevo_actionPerformed() {
             //limpia las cajas de texto
        viewAgenda.jTF_Nombre.setText(" ");
       viewAgenda.jTF_Email.setText(" ");
    }
  
    
   

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jB_Primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelAgenda.moverPrimerRegistro();
        viewAgenda.jTF_Nombre.setText(modelAgenda.getNombre());
        viewAgenda.jTF_Email.setText(modelAgenda.getEmail());
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jB_Anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelAgenda.moverAnteriorRegistro();
       
        viewAgenda.jTF_Nombre.setText(modelAgenda.getNombre());
        viewAgenda.jTF_Email.setText(modelAgenda.getEmail());
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jB_Ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelAgenda.moverUltimoRegistro();
        
        viewAgenda.jTF_Nombre.setText(modelAgenda.getNombre());
        viewAgenda.jTF_Email.setText(modelAgenda.getEmail());
        
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jB_Siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelAgenda.moverSiguienteRegistro();
       
        viewAgenda.jTF_Nombre.setText(modelAgenda.getNombre());
        viewAgenda.jTF_Email.setText(modelAgenda.getEmail());
        //invocar al metodo moverSiguienteRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }
}
