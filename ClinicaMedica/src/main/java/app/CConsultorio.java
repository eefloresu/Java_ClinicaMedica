/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author eefloresU
 */
public class CConsultorio {

    int codigo;
    String Nombre;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
   
    //Funcion para Insertar nuevos Registros 
    public void InsertarConsultorio(JTextField paramNombre){
        setNombre (paramNombre.getText());
        
        CConexion objetoConexion = new  CConexion();
        
        String consulta = "INSERT INTO consultorios (conNombre) VALUES (?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString (1, getNombre());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se inserto correctamente el consultorio");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha insertado correctamente el consultorio, error: "+e.toString());
        }
    }
    
    //Función para mostrar registros existentes
    public DefaultTableModel mostrarConsultorios(){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter();
        //paramTotalConsultorios.setRowSorter(OrdenarTabla);        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");      
        //paramTotalConsultorios.setModel(modelo);
        sql = "SELECT * FROM consultorios;";
        
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
            //paramTotalConsultorios.setModel(modelo);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
       return modelo;  
    }
    
    //Función para Seleccionar el archivo que se va a modificar
    public void seleccionarConsultorio(JTable paramTablaConsultorios, JTextField paramId, JTextField paramNombre){
       
        try {
           int fila = paramTablaConsultorios.getSelectedRow();
           
            if (fila >= 0) {
                paramId.setText((paramTablaConsultorios.getValueAt(fila, 0).toString()));
                paramNombre.setText((paramTablaConsultorios.getValueAt(fila, 1).toString()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error de selección, error: "+e.toString());
        }
    }
    //Función para actualizar Consultorios
    public void modificarConsultorios(JTextField paramCodigo, JTextField paramNombre){       
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombre(paramNombre.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE consultorios SET consultorios.conNombre = ? WHERE consultorios.idConsultorio=?;";
        
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
    
}
