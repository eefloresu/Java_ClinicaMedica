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
public class CCitas {
    
     int codigo;
     String fecha;
     String hora;
     String paciente;
     String medico;
     String consultorio;
     String estado;
     String observaciones;

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
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Cita ingresada correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha insertado correctamente la cita, error: "+e.toString());
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
        
        //sql = "SELECT * FROM citas ORDER BY idCita DESC;"; // ASC para ordenar de forma Ascendente
        
        sql = "SELECT c.idcita,c.citfecha,c.cithora,p.pacNombre AS nombrePaciente,m.mednombres AS nombreMedico,\n"
                + "con.conNombre AS nombreConsultorio,c.citestado,c.citobservaciones\n"
                + "FROM citas c\n"
                + "JOIN pacientes p ON c.citPaciente = p.idPaciente\n"
                + "JOIN medicos m ON c.citMedico = m.idMedico\n"
                + "JOIN consultorios con ON c.citConsultorio = con.idConsultorio\n"
                + "ORDER BY c.idcita DESC;";
        
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
       return modelo;  
    }
    
     //Función para Seleccionar el archivo que se va a modificar
    public void seleccionarCitas(JTable paramTablaCitas, JTextField paramId, JTextField paramfecha, 
            JTextField paramHora, JTextField paramPaciente, JTextField paramMedico, JTextField paramConsultorio,
            JTextField paramEstado, JTextField paramObservaciones){
       
        try {
           int fila = paramTablaCitas.getSelectedRow();
           
            if (fila >= 0) {
                paramId.setText((paramTablaCitas.getValueAt(fila, 0).toString()));
                paramfecha.setText((paramTablaCitas.getValueAt(fila, 1).toString()));
                paramHora.setText((paramTablaCitas.getValueAt(fila, 2).toString()));
                paramPaciente.setText((paramTablaCitas.getValueAt(fila, 3).toString()));
                paramMedico.setText((paramTablaCitas.getValueAt(fila, 4).toString()));
                paramConsultorio.setText((paramTablaCitas.getValueAt(fila, 5).toString()));
                paramEstado.setText((paramTablaCitas.getValueAt(fila, 6).toString()));
                paramObservaciones.setText((paramTablaCitas.getValueAt(fila, 7).toString()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error de selección, error: "+e.toString());
        }
    }
   
    //Función para modificar Citas
    public void modificarCitas(JTextField paramCodigo, JTextField paramFecha, 
    JTextField paramHora, JTextField paramPaciente, JTextField paramMedico, 
    JTextField paramConsultorio, JTextField paramEstado, JTextField paramObservaciones){       
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setFecha(paramFecha.getText());
        setHora(paramHora.getText());
        setPaciente(paramPaciente.getText());
        setMedico(paramMedico.getText());
        setConsultorio(paramConsultorio.getText());
        setEstado(paramEstado.getText());
        setObservaciones(paramObservaciones.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE citas SET citas.citfecha=?, citas.cithora=?, "
                        + "citas.citPaciente=?, citas.citMedico=?, citas.citConsultorio=?, "
                        + "citas.citEstado=?, citas.citobservaciones=? WHERE citas.idcita = ?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            //Incorporar parametros
            cs.setString(1, getFecha());
            cs.setString(2, getHora());
            cs.setString(3, getPaciente());
            cs.setString(4, getMedico());
            cs.setString(5, getConsultorio());
            cs.setString(6, getEstado());
            cs.setString(7, getObservaciones());
            cs.setInt(8, getCodigo()); //asignar el valor al campo idMedico.
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modifico, error: "+ e.toString());
        }
    }
    
    //Función para Eliminar Medicos.
    public void eliminarCitas(JTextField paramCodigo){
        setCodigo (Integer.parseInt(paramCodigo.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM citas WHERE citas.idcita = ?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la cita");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: "+e.toString());
        }
    } 
    
}
