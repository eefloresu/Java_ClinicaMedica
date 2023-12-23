/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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
public class CCitas {
    
    private int codigo;
    private String fecha;
    private String hora;
    private String paciente;
    private String medico;
    private String consultorio;
    private String estado;
    private String observaciones;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    //Función para Insertar nuevos Registros a la tabla Citas
    public void InsertarCita(JTextField paramFecha, JTextField paramHora, 
            JTextField paramPaciente, JTextField paramMedico, JTextField paramConsultorio, 
            JTextField paramEstado, JTextField paramObservaciones){
        
        setFecha(paramFecha.getText());
        setHora(paramHora.getText());
        setPaciente(paramPaciente.getText());
        setMedico(paramMedico.getText());
        setConsultorio(paramConsultorio.getText());
        setEstado(paramEstado.getText());
        setObservaciones(paramObservaciones.getText());
        
        CConexion objetoConexion = new  CConexion();
        
        String consulta = "INSERT INTO citas (citfecha, cithora, citPaciente, citMedico, "
                        + "citConsultorio, citestado, citobservaciones) "
                        + "VALUES (?,?,?,?,?,?,?);";        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getFecha());
            cs.setString(2, getHora());
            cs.setString(3, getPaciente());
            cs.setString(4, getMedico());
            cs.setString(5, getConsultorio());
            cs.setString(6, getEstado());
            cs.setString(7, getObservaciones());
            
            JOptionPane.showMessageDialog(null,"Medico ingresado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha insertado correctamente el medico, error: "+e.toString());
        }
    }
         
    //Función para mostrar registros existentes
    public DefaultTableModel mostrarCitas(){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter();        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Paciente"); 
        modelo.addColumn("Medico");
        modelo.addColumn("Consultorio");
        modelo.addColumn("Estado");
        modelo.addColumn("Observaciones");
        
        sql = "SELECT * FROM citas ORDER BY idCita DESC;"; // ASC para ordenar de forma Ascendente
        
        String[] datos = new String[8];
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
                datos[7]=rs.getString(8);
                
                modelo.addRow(datos);
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
       return modelo;  
    }
}
