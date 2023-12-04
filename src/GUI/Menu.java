package GUI;

import DAO.CitaCRUD;
import DAO.DoctorCRUD;
import DAO.PacienteCRUD;
import Entidades.Doctor;
import Entidades.Paciente;
import Entidades.Cita;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Menu extends JFrame{
    private JPanel MiPanel;
    private JTabbedPane TPMenu;
    private JTextField txtIDD;
    private JTextField txtApellidoPD;
    private JTextField txtApellidoMD;
    private JTextField txtNombreD;
    private JLabel lblIDD;
    private JLabel lblNombreD;
    private JLabel lblApellidoPD;
    private JLabel lblApellidoM;
    private JLabel lblEspecialidadD;
    private JComboBox cbEspecialidadD;
    private JComboBox cbGeneroD;
    private JTextField txtTelefonoD;
    private JPanel JPgtD;
    private JLabel lblGeneroD;
    private JLabel lblTelefonoD;
    private JLabel lblCorreoD;
    private JTextField txtCorreoD;
    private JLabel lblFechaNacD;
    private JTextField txtFechaNacD;
    private JButton btnBuscarD;
    private JPanel JPbtnD;
    private JButton btnCrearD;
    private JButton btnEditarD;
    private JButton btnEliminarD;
    private JComboBox cbDiaFND;
    private JComboBox cbMesFND;
    private JComboBox cbAnioFND;
    private JTextField txtIDP;
    private JLabel lblIDP;
    private JTextField txtNombreP;
    private JTextField txtApellidoPP;
    private JTextField txtApellidoMP;
    private JLabel lblNombreP;
    private JLabel lblApellidoPP;
    private JLabel lblApellidoMP;
    private JLabel lblFechaNacP;
    private JComboBox cbDiaP;
    private JComboBox cbMesP;
    private JComboBox cbAnioP;
    private JLabel lblTelefono;
    private JTextField txtTelefonoP;
    private JComboBox cbGeneroP;
    private JLabel lblGeneroP;
    private JTextField txtCorreoP;
    private JLabel lblCorreoP;
    private JLabel lblOMP;
    private JTextField txtOMP;
    private JButton btnBuscarP;
    private JButton btnCrearP;
    private JButton btnEditarP;
    private JButton btnBorrarP;
    private JComboBox cbDoctorID;
    private JComboBox cbPacienteID;
    private JLabel lblDoctor;
    private JLabel lblPaciente;
    private JTextField txtObservacionesC;
    private JLabel lblObservacionesC;
    private JLabel lblFechaC;
    private JButton btnCrearC;
    private JButton btnEditarC;
    private JButton btnBorrarC;
    private JPanel PanBtnC;
    private JPanel PanDatosDC;
    private JPanel PanObservacionesC;
    private JPanel PanFechaC;
    private JTextField txtNombreDC;
    private JTextField txtNombrePC;
    private JLabel lblNombreDC;
    private JLabel lblNombrePC;
    private JButton btnBuscarC;
    private JLabel lblIDC;
    private JTextField txtIDC;
    private JTextField txtFechaC;
    private JComboBox cbDiaC;
    private JComboBox cbMesC;
    private JComboBox cbAnioC;
    ArrayList<Doctor> listaD;
    ArrayList<Paciente> listaP;


    //Metodo de Seleccionar en ComboBox de Doctor
    private void seleccionarMesEnComboBox(String mes) {
        cbMesFND.setSelectedItem(mes);
    }
    private void seleccionarDiaEnComboBox(String dia) {
        cbDiaFND.setSelectedItem(dia);
    }
    private void seleccionarAnioEnComboBox(String anio) {
        cbAnioFND.setSelectedItem(anio);
    }
    private void seleccionarGeneroEnComboBox(String Genero) {
        cbGeneroD.setSelectedItem(Genero);
    }
    private void seleccionarEspecialidadEnComboBox(String Especialidad) {
        cbEspecialidadD.setSelectedItem(Especialidad);
    }

    //Metodo para Seleccionar en ComboBOX de Paciente
    private void seleccionarDiaPEnComboBox(String DiaP) {
        cbDiaP.setSelectedItem(DiaP);
    }
    private void seleccionarMesPEnComboBox(String MesP) {
        cbMesP.setSelectedItem(MesP);
    }
    private void seleccionarAnioPEnComboBox(String AnioP) {
        cbAnioP.setSelectedItem(AnioP);
    }
    private void seleccionarGeneroPEnComboBox(String GeneroP) {
        cbGeneroP.setSelectedItem(GeneroP);
    }

    //Metodo para Seleccionar en ComboBOX de Cita
    private void seleccionarIDDoctor(String IDD) { cbDoctorID.setSelectedItem(IDD);}
    private void seleccionarIDPaciente (String IDP) { cbDoctorID.setSelectedItem(IDP);
    }
    private void seleccionarDiaCita(String DiaC) { cbDiaC.setSelectedItem(DiaC);}
    private void seleccionarMesCita (String MesC) { cbMesC.setSelectedItem(MesC);
    }
    private void seleccionarAnioCita (String AnioC) { cbAnioC.setSelectedItem(AnioC);
    }

    public Menu() {
        btnBuscarD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar Doctor
                DoctorCRUD crud = new DoctorCRUD();
                String ID= txtIDD.getText();
                Doctor doctor = crud.buscarDoctorPorID(ID);
                if (doctor==null){
                    int respuesta= JOptionPane.showConfirmDialog(MiPanel, "No se encontro el doctor por ID" + ID+ "\n¿Deseas dar de alta?","Doctor no Encontrado",JOptionPane.YES_NO_OPTION);
                    if(respuesta==0){
                        limpiarFormularioDoctor();
                        btnEliminarD.setEnabled(false);
                        btnEditarD.setEnabled(false);
                        btnCrearD.setEnabled(true);
                        txtNombreD.requestFocus();
                    } else if(respuesta==1){
                        limpiarFormularioDoctor();
                    } else if(respuesta==-1){
                        limpiarFormularioDoctor();
                    }
                } else {
                    txtNombreD.setText(doctor.getNombre());
                    txtApellidoPD.setText(doctor.getApellidoP());
                    txtApellidoMD.setText(doctor.getApellidoM());
                    txtTelefonoD.setText(doctor.getTelefono());
                    txtCorreoD.setText(doctor.getCorreo());
                    //txtFechaNacD.setText(doctor.getFechaNac());
                    String MesFND = doctor.getMesFN();
                    seleccionarMesEnComboBox(MesFND);
                    String DiaFND = doctor.getDiaFN();
                    seleccionarDiaEnComboBox(DiaFND);
                    String AnioFND = doctor.getAnioFN();
                    seleccionarAnioEnComboBox(AnioFND);
                    String GeneroD = doctor.getGenero();
                    seleccionarGeneroEnComboBox(GeneroD);
                    String EspecialidadD = doctor.getEspecialidad();
                    seleccionarEspecialidadEnComboBox(EspecialidadD);
                    btnEliminarD.setEnabled(true);
                    btnEditarD.setEnabled(true);
                    btnCrearD.setEnabled(false);
                }
            }
        });

        btnCrearD.addActionListener(new ActionListener() {
            @Override
            //Crear un nuevo doctor
            public void actionPerformed(ActionEvent e) {
                if (!validarCampos()) {
                    return; // Detener el proceso si la validación falla
                }
                Doctor a = new Doctor();
                a.setID(txtIDD.getText());
                a.setNombre(txtNombreD.getText());
                a.setApellidoP(txtApellidoPD.getText());
                a.setApellidoM(txtApellidoMD.getText());
                String especialidad = (String) cbEspecialidadD.getSelectedItem();
                a.setEspecialidad(especialidad);
                a.setTelefono(txtTelefonoD.getText());
                a.setCorreo(txtCorreoD.getText());
                String genero = (String) cbGeneroD.getSelectedItem();
                a.setGenero(genero);
                String diaFN= (String) cbDiaFND.getSelectedItem();
                a.setDiaFN(diaFN);
                String mesFN = (String) cbMesFND.getSelectedItem();
                a.setMesFN(mesFN);
                String anioFN = (String) cbAnioFND.getSelectedItem();
                a.setAnioFN(anioFN);
                DoctorCRUD crud = new DoctorCRUD();
                crud.insertarDoctor(a);
                limpiarFormularioDoctor();
            }
        });
        btnEliminarD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EliminarDoctor
                String ID = txtIDD.getText();
                int respuesta= JOptionPane.showConfirmDialog(MiPanel,"¿Quieres eliminar al doctor?","Eliminar Doctor", JOptionPane.YES_NO_OPTION);
                if (respuesta ==0){
                    if (!ID.isEmpty()) {
                        //Crear el doctor a eliminar
                        Doctor doctorBorrar= new Doctor();
                        doctorBorrar.setID(ID);
                        //Eliminar el doctor con el metodo crud
                        DoctorCRUD crud = new DoctorCRUD();
                        crud.eliminarDoctor(doctorBorrar);
                        JOptionPane.showMessageDialog(MiPanel,"Se elimino el doctor exitosamente","Doctor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        limpiarFormularioDoctor();
                } else if (ID.isEmpty()){
                        Doctor doctorBorrar= new Doctor();
                        doctorBorrar.setID(ID);
                        JOptionPane.showMessageDialog(MiPanel, "No especificaste el doctor a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }else if (respuesta==1){
                    JOptionPane.showMessageDialog(MiPanel, "No se elimino el Doctor", "Doctor no Eliminado", JOptionPane.ERROR_MESSAGE);
                } else if (respuesta ==-1)
                    JOptionPane.showMessageDialog(MiPanel, "No se elimino el Doctor", "Doctor no Eliminado", JOptionPane.ERROR_MESSAGE);
            }
        });
        //Metodo de Paciente
        btnBuscarP.addActionListener(new ActionListener() {
            @Override
            //Buscar paciente con ID
            public void actionPerformed(ActionEvent e) {
                PacienteCRUD crud1 = new PacienteCRUD();
                String ID= txtIDP.getText();
                Paciente paciente = crud1.buscarPacientePorID(ID);
                if (paciente==null){
                    int respuesta=JOptionPane.showConfirmDialog(MiPanel, "No se encontro el paciente por ID: " + ID+ "\n¿Deseas dar de alta?","Paciente no Encontrado",JOptionPane.YES_NO_OPTION);
                    if(respuesta==0){
                        limpiarFormularioPaciente();
                        btnBorrarP.setEnabled(false);
                        btnEditarP.setEnabled(false);
                        btnCrearP.setEnabled(true);
                        txtNombreP.requestFocus();
                    } else if(respuesta==1){
                        limpiarFormularioPaciente();
                    } else if(respuesta==-1){
                        limpiarFormularioPaciente();
                    }
                } else {
                    txtNombreP.setText(paciente.getNombre());
                    txtApellidoPP.setText(paciente.getApellidoP());
                    txtApellidoMP.setText(paciente.getApellidoM());
                    txtTelefonoP.setText(paciente.getTelefono());
                    txtCorreoP.setText(paciente.getCorreo());
                    //txtFechaNacD.setText(doctor.getFechaNac());
                    String MesFNP = paciente.getMesFNP();
                    seleccionarMesPEnComboBox(MesFNP);
                    String DiaFNP = paciente.getDiaFNP();
                    seleccionarDiaPEnComboBox(DiaFNP);
                    String AnioFNP = paciente.getAnioFNP();
                    seleccionarAnioEnComboBox(AnioFNP);
                    String GeneroP = paciente.getGenero();
                    seleccionarGeneroEnComboBox(GeneroP);
                    txtOMP.setText(paciente.getObservacionM());
                    btnBorrarP.setEnabled(true);
                    btnEditarP.setEnabled(true);
                    btnCrearP.setEnabled(false);
                }
            }

        });
        btnCrearP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validarCamposPaciente()) {
                    return; // Detener el proceso si la validación falla
                }
                Paciente b = new Paciente();
                b.setID(txtIDP.getText());
                b.setNombre(txtNombreP.getText());
                b.setApellidoP(txtApellidoPP.getText());
                b.setApellidoM(txtApellidoMP.getText());
                b.setTelefono(txtTelefonoP.getText());
                b.setCorreo(txtCorreoP.getText());
                String generoP = (String) cbGeneroP.getSelectedItem();
                b.setGenero(generoP);
                String diaFNP= (String) cbDiaP.getSelectedItem();
                b.setDiaFNP(diaFNP);
                String mesFNP = (String) cbMesP.getSelectedItem();
                b.setMesFNP(mesFNP);
                String anioFNP = (String) cbAnioP.getSelectedItem();
                b.setAnioFNP(anioFNP);
                b.setObservacionM(txtOMP.getText());
                PacienteCRUD crud1 = new PacienteCRUD();
                crud1.insertarPaciente(b);
                limpiarFormularioPaciente();
            }

        });

        //Mostrar las IDs de la lista de Doctor y Paciente en el ComboBox en las Consultas
                DoctorCRUD crud= new DoctorCRUD();
                crud.asignarIDDoctorCB(cbDoctorID);
                PacienteCRUD crud1 = new PacienteCRUD();
                crud1.asignarIDPacienteCB(cbPacienteID);
        cbPacienteID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPacienteS = (String) cbPacienteID.getSelectedItem();
                Paciente pacienteSeleccionado = PacienteCRUD.buscarPacientePorID(idPacienteS);
                if (pacienteSeleccionado != null) {
                    txtNombrePC.setText(pacienteSeleccionado.getNombre() + " "+ pacienteSeleccionado.getApellidoP() +" " + pacienteSeleccionado.getApellidoM());
                } else {
                    txtNombrePC.setText("");
                }
            }
        });

        cbDoctorID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idDoctorS = (String) cbDoctorID.getSelectedItem();
                Doctor doctorSeleccionado = DoctorCRUD.buscarDoctorPorID(idDoctorS);
                if (doctorSeleccionado != null) {
                    txtNombreDC.setText(doctorSeleccionado.getNombre() + " "+ doctorSeleccionado.getApellidoP() + " " + doctorSeleccionado.getApellidoM());
                } else {
                    txtNombreDC.setText("");
                }
            }
        });
        btnCrearC.addActionListener(new ActionListener() {
            //Boton para crear citas
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cbDiaC.getSelectedItem().toString() + "/" + cbMesC.getSelectedItem().toString() + "/" + cbAnioC.getSelectedItem().toString();
                boolean resultado = validarFecha(fecha);
                if(resultado){
                    JOptionPane.showMessageDialog(MiPanel,"La fecha esta bien");
                    if (validarCamposCita()){
                        Cita c = new Cita();
                        c.setID(txtIDC.getText());
                        String idDoctor= (String) cbDoctorID.getSelectedItem();
                        c.setIDDoctor(idDoctor);
                        String idPaciente= (String) cbPacienteID.getSelectedItem();
                        c.setIDPaciente(idPaciente);
                        c.setNombreDoctor(txtNombreDC.getText());
                        c.setNombrePaciente(txtNombrePC.getText());
                        c.setObservaciones(txtObservacionesC.getText());
                        c.setFechaC(fecha);
                        String diaC= (String) cbDiaC.getSelectedItem();
                        c.setDiaC(diaC);
                        String mesC= (String) cbMesC.getSelectedItem();
                        c.setMesC(mesC);
                        String anioC= (String) cbAnioC.getSelectedItem();
                        c.setAnioC(anioC);
                        limpiarFormularioCita();
                    } else{
                        JOptionPane.showMessageDialog(MiPanel, "Error en los campos de la cita");
                    }
                }else {
                    JOptionPane.showMessageDialog(MiPanel, "Error en la fecha");
                    txtFechaC.requestFocus();
                }
            }
        });
        btnBuscarC.addActionListener(new ActionListener() {
            //Boton para buscar citas por ID
            @Override
            public void actionPerformed(ActionEvent e) {
                CitaCRUD crud2 = new CitaCRUD();
                String ID= txtIDC.getText();
                Cita cita = crud2.buscarCitaPorID(ID);
                if (cita==null){
                    int respuesta=JOptionPane.showConfirmDialog(MiPanel, "No se encontro la cita por ID: " + ID+ "\n¿Deseas crear una cita?","Cita no Encontrada",JOptionPane.YES_NO_OPTION);
                    if(respuesta==0){
                        limpiarFormularioCita();
                        btnBorrarC.setEnabled(false);
                        btnEditarC.setEnabled(false);
                        btnCrearC.setEnabled(true);
                        txtObservacionesC.requestFocus();
                    } else if(respuesta==1){
                        limpiarFormularioCita();
                    } else if(respuesta==-1){
                        limpiarFormularioCita();
                    }
                } else {
                    txtObservacionesC.setText(cita.getObservaciones());
                    txtFechaC.setText(cita.getFechaC());
                    String IDDC = cita.getIDDoctor();
                    seleccionarIDDoctor(IDDC);
                    String IDPC = cita.getIDPaciente();
                    seleccionarIDPaciente(IDPC);
                    txtNombreDC.setText(cita.getNombreDoctor());
                    txtNombrePC.setText(cita.getNombrePaciente());
                    txtObservacionesC.setText(cita.getObservaciones());
                    txtFechaC.setText(cita.getFechaC());
                    String DiaC = cita.getDiaC();
                    seleccionarDiaCita(DiaC);
                    String MesC = cita.getMesC();
                    seleccionarMesCita(MesC);
                    String AnioC= cita.getAnioC();
                    seleccionarAnioCita(AnioC);
                    btnBorrarC.setEnabled(true);
                    btnEditarC.setEnabled(true);
                    btnCrearC.setEnabled(false);
                }
            }
        });
    }

    //Metodo de limpiar Formularios
    private void limpiarFormularioDoctor(){
        txtNombreD.setText("");
        txtApellidoPD.setText("");
        txtApellidoMD.setText("");
        txtTelefonoD.setText("");
        txtCorreoD.setText("");
        cbEspecialidadD.setSelectedIndex(0);
        cbGeneroD.setSelectedIndex(0);
        cbDiaFND.setSelectedIndex(0);
        cbMesFND.setSelectedIndex(0);
        cbAnioFND.setSelectedIndex(0);
    }

    private void limpiarFormularioPaciente(){
        txtNombreP.setText("");
        txtApellidoPP.setText("");
        txtApellidoMP.setText("");
        txtTelefonoP.setText("");
        txtCorreoP.setText("");
        cbGeneroP.setSelectedIndex(0);
        cbDiaP.setSelectedIndex(0);
        cbMesP.setSelectedIndex(0);
        cbAnioP.setSelectedIndex(0);
        txtOMP.setText("");
    }

    private void limpiarFormularioCita(){
        //Hacerlo despues
        cbDoctorID.setSelectedIndex(0);
        cbPacienteID.setSelectedIndex(0);
        txtNombreDC.setText("");
        txtNombrePC.setText("");
        txtObservacionesC.setText("");
        txtFechaC.setText("");
        cbDiaC.setSelectedIndex(0);
        cbMesC.setSelectedIndex(0);
        cbAnioC.setSelectedIndex(0);
    }

    //Metodos de validarCampos
    public boolean validarCampos() {
        if (txtIDD.getText().isEmpty() || txtNombreD.getText().isEmpty()|| txtApellidoPD.getText().isEmpty() || txtApellidoMD.getText().isEmpty() || cbEspecialidadD.getSelectedIndex()==0||txtTelefonoD.getText().isEmpty()
        || txtTelefonoD.getText().isEmpty() || txtCorreoD.getText().isEmpty() || cbGeneroD.getSelectedIndex()==0 || cbDiaFND.getSelectedIndex()==0 || cbMesFND.getSelectedIndex()==0 || cbAnioFND.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(MiPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        }
        else{
            return true;
        }
    }

    public boolean validarCamposPaciente() {
        if (txtIDP.getText().isEmpty() || txtNombreP.getText().isEmpty()|| txtApellidoPP.getText().isEmpty() || txtApellidoMP.getText().isEmpty() ||txtTelefonoP.getText().isEmpty()|| txtOMP.getText().isEmpty()
                || txtTelefonoP.getText().isEmpty() || txtCorreoP.getText().isEmpty() || cbGeneroP.getSelectedIndex()==0 || cbDiaP.getSelectedIndex()==0 || cbMesP.getSelectedIndex()==0 || cbAnioP.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(MiPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validarCamposCita() {
        if (txtIDC.getText().isEmpty()||cbDoctorID.getSelectedIndex()==0 || cbPacienteID.getSelectedIndex()==0 || txtNombreDC.getText().isEmpty() || txtNombrePC.getText().isEmpty()
                || txtObservacionesC.getText().isEmpty() ||cbDiaC.getSelectedIndex()==0||cbMesC.getSelectedIndex()==0||cbAnioC.getSelectedIndex()==0 ) {
            JOptionPane.showMessageDialog(MiPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }

    //Metodos para Validar fechas
    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha =
                    new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date miFecha = formatoFecha.parse(fecha);
            System.out.println(miFecha);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    public static void main(String[] args){
        Menu v= new Menu();
        v.setContentPane(v.MiPanel);
        v.setSize(700,400);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }


}
