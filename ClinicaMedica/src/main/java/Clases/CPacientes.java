package Clases;

import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author eefloresU
 */
public class CPacientes {
    
    int codigo;
    String identificacion;
    String nombres;
    String apellidos;
    String fechaNacimiento;
    String sexo;

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

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
     //Función para Insertar nuevos Registros a la tabla Pacientes
    public void InsertarPaciente(JTextField paramIdentificacion, JTextField paramNombres, 
            JTextField paramApellidos, JTextField paramFechaNacimiento, JTextField paramSexo){
        
        setIdentificacion(paramIdentificacion.getText());
        setNombres (paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setFechaNacimiento(paramFechaNacimiento.getText());
        setSexo(paramSexo.getText());
        
        CConexion objetoConexion = new  CConexion();
        
        String consulta = "INSERT INTO pacientes (pacIdentificacion, pacNombre, pacApellidos, pacFechaNacimiento, pacSexo) "
                        + "VALUES (?,?,?,?,?);";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString (1, getIdentificacion());
            cs.setString (2, getNombres());
            cs.setString (3, getApellidos());
            cs.setString (4, getFechaNacimiento());
            cs.setString (5, getSexo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Paciente ingresado correctamente");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,"No se ha insertado correctamente el paciente, error: "+e.toString());
        }
    }
    
    
    //Función para mostrar registros existentes
    public DefaultTableModel mostrarPacientes(){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter();        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Identificación");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos"); 
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Sexo");
        
        sql = "SELECT * FROM pacientes ORDER BY idPaciente DESC;"; // ASC para ordenar de forma descendente
        
        String[] datos = new String[6];
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
                
                modelo.addRow(datos);
            }           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar los registros, error: "+ e.toString());
        }
       return modelo;  
    }
    
    //Función para Seleccionar el archivo que se va a modificar
    public void seleccionarPacientes(JTable paramTablaPacientes, JTextField paramId, JTextField paramidentificacion, 
            JTextField paramNombre, JTextField paramApellidos, JTextField paramFechaNacimiento, JTextField paramSexo){
       
        try {
           int fila = paramTablaPacientes.getSelectedRow();
           
            if (fila >= 0) {
                paramId.setText((paramTablaPacientes.getValueAt(fila, 0).toString()));
                paramidentificacion.setText((paramTablaPacientes.getValueAt(fila, 1).toString()));
                paramNombre.setText((paramTablaPacientes.getValueAt(fila, 2).toString()));
                paramApellidos.setText((paramTablaPacientes.getValueAt(fila, 3).toString()));
                paramFechaNacimiento.setText((paramTablaPacientes.getValueAt(fila, 4).toString()));
                paramSexo.setText((paramTablaPacientes.getValueAt(fila, 5).toString()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error de selección, error: "+e.toString());
        }
    }
    
    //Función para modificar Pacientes
    public void modificarPacientes(JTextField paramCodigo, JTextField paramIdentificacion, 
    JTextField paramNombre, JTextField paramApellidos, JTextField paramFechaNacimiento, 
    JTextField paramSexo){       
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setIdentificacion(paramIdentificacion.getText());
        setNombres(paramNombre.getText());
        setApellidos(paramApellidos.getText());
        setFechaNacimiento(paramFechaNacimiento.getText());
        setSexo(paramSexo.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE pacientes SET pacientes.pacIdentificacion=?, pacientes.pacNombre=?, "
                        + "pacientes.pacApellidos=?, pacientes.pacFechaNacimiento=?, pacientes.pacSexo=? "
                        + "WHERE pacientes.idPaciente = ?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            //Incorporar parametros
            cs.setString(1, getIdentificacion());
            cs.setString(2, getNombres());
            cs.setString(3, getApellidos());
            cs.setString(4, getFechaNacimiento());
            cs.setString(5, getSexo());
            cs.setInt(6, getCodigo()); //asignar el valor al campo idMedico.
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modifico, error: "+ e.toString());
        }
    }
    
    //Función para Eliminar Pacientes.
    public void eliminarPacientes(JTextField paramCodigo){
        setCodigo (Integer.parseInt(paramCodigo.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM pacientes WHERE pacientes.idPaciente = ?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, getCodigo());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el paciente");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: "+e.toString());
        }
    }
    
    // función para imprimir el reporte 'Pacientes.jasper'
    public void imprimirReporte() {
        try {
            // Ruta del archivo JasperReport
            String reportPath = "src\\main\\resources\\Reportes\\Pacientes.jasper";

            // Parámetros, si es necesario
            Map<String, Object> parametros = new HashMap<>();

            // Conexión a la base de datos
            CConexion objetoConexion = new CConexion();

            // Generar el informe
            InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(reportPath)));
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, objetoConexion.estableceConexion());

            // Visualizar el informe
            JasperViewer.viewReport(jasperPrint, false);
        } catch (FileNotFoundException | JRException  e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir el reporte: " + e.toString());
        }
    }
    
}
