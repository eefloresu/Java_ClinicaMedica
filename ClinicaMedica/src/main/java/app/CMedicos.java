/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author eefloresU
 */
public class CMedicos {
    
    int codigo;
    String identificacion;
    String nombres;
    String apellidos;
    String especialidad;
    String telefono;
    String correo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //Función para Insertar nuevos Registros a la tabla Medicos
    public void InsertarMedico(JTextField paramIdentificacion, JTextField paramNombres, 
            JTextField paramApellidos, JTextField paramEspecialidad, JTextField paramTelefono, 
            JTextField paramCorreo){
        
        setIdentificacion(paramIdentificacion.getText());
        setNombres (paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setEspecialidad(paramEspecialidad.getText());
        setTelefono(paramTelefono.getText());
        setCorreo(paramCorreo.getText());
        
        CConexion objetoConexion = new  CConexion();
        
        String consulta = "INSERT INTO medicos ( medidentificacion, mednombres, medapellidos, medEspecialidad, medtelefono, medcorreo) "
                        + "VALUES (?,?,?,?,?,?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString (1, getIdentificacion());
            cs.setString (2, getNombres());
            cs.setString (3, getApellidos());
            cs.setString (4, getEspecialidad());
            cs.setString (5, getTelefono());
            cs.setString (6, getCorreo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Medico ingresado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha insertado correctamente el medico, error: "+e.toString());
        }
    }
    
    //Función para mostrar registros existentes
    public DefaultTableModel mostrarMedicos(){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter();        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Identificación");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos"); 
        modelo.addColumn("Especialidad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        sql = "SELECT * FROM medicos ORDER BY idMedico DESC;"; // ASC para ordenar de forma descendente
        
        String[] datos = new String[7];
        Statement st;
        
        try {
            st=objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                
                modelo.addRow(datos);
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
       return modelo;  
    }
    
    
}
