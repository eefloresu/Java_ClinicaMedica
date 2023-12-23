/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author eefloresU
 */
public class CEspecialidades {

    int codigo;
    String nombre;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    //Funcion para Insertar nuevos Registros 
    public void InsertarEspecialidad(JTextField paramNombre){
        setNombre (paramNombre.getText());
        
        CConexion objetoConexion = new  CConexion();
        
        String consulta = "INSERT INTO especialidades (esp_Nombre) VALUES (?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString (1, getNombre());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se inserto correctamente la Especialidad");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha insertado correctamente la Especialidad, error: "+e.toString());
        }
    }
    
    //Función para mostrar registros existentes
    public DefaultTableModel mostrarEspecialidades(){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter();       
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        sql = "SELECT * FROM especialidades ORDER BY id_especialidad DESC;"; // ASC para ordenar de forma descendente
        
        String[] datos = new String[2];
        Statement st;
        
        try {
            st=objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                
                modelo.addRow(datos);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
       return modelo;  
    }
    
    //Función para Seleccionar el archivo que se va a modificar
    public void seleccionarEspecialidad(JTable paramTablaEspecialidades, JTextField paramId, JTextField paramNombre){
       
        try {
           int fila = paramTablaEspecialidades.getSelectedRow();
           
            if (fila >= 0) {
                paramId.setText((paramTablaEspecialidades.getValueAt(fila, 0).toString()));
                paramNombre.setText((paramTablaEspecialidades.getValueAt(fila, 1).toString()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error de selección, error: "+e.toString());
        }
    }
    
    //Función para actualizar Especialidades
    public void modificarEspecialidades(JTextField paramCodigo, JTextField paramNombre){       
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombre(paramNombre.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE especialidades SET especialidades.esp_Nombre = ? WHERE especialidades.id_especialidad=?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            //Incorporar parametros
            cs.setString(1, getNombre());
            cs.setInt(2, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modifico, error: "+ e.toString());
        }
    }
    
    //Función para Eliminar Especialidades.
    public void eliminarEspecialidad(JTextField paramCodigo){
        setCodigo (Integer.parseInt(paramCodigo.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM especialidades WHERE especialidades.id_especialidad=?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el consultorio");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: "+e.toString());
        }
    } 
    
}
