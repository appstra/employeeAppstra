package com.appstra.employee.methods;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;

public class ConexionFTP {

    private FTPSClient ftp;

    public boolean conectar() throws IOException {
        boolean conect;
        this.ftp = new FTPSClient();
        this.ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        try {
            this.ftp.connect("192.168.0.2",21);
            conect = this.ftp.login("UserFTP", "appstraAdmin");
            this.ftp.setFileType(this.ftp.BINARY_FILE_TYPE);// Tipo de archivo: binario
            this.ftp.setEndpointCheckingEnabled(false); // Deshabilita la verificación del endpoint
            this.ftp.execPBSZ(0); // Establece el buffer de protección
            this.ftp.execPROT("P"); // Usa protección de datos
            this.ftp.enterLocalPassiveMode(); // Modo pasivo
            System.out.println("La conexión fue: " + conect);
        } catch (IOException e) {
            System.out.println(";conectar;FTP;" + e.getMessage());
            conect = false;
        }
        return conect;
    }

    public boolean crearCarpeta(String carpeta) throws IOException {
        try {
            if (this.ftp.makeDirectory(carpeta)) {
                cambiarCarpeta(carpeta);
                return true;
            }
        } catch (IOException e) {
            System.out.println(";crearCarpeta;FTP;" + e.getMessage());
        }
        return false;
    }

    public boolean cambiarCarpeta(String carpeta) throws IOException {
        try {
            return this.ftp.changeWorkingDirectory(carpeta);
        } catch (IOException e) {
            System.out.println(";cambiarCarpeta;FTP;" + e.getMessage());
            return false;
        }
    }

    public boolean enviarArchivo(String rutaArchivoFtp, InputStream inputStream) throws IOException {
        try {
            this.ftp.storeFile(rutaArchivoFtp, inputStream);
            return true;
        } catch (IOException e) {
            System.out.println("Error FTP: " + e);
            return false;
        }
    }

    public boolean eliminarArchivo(String rutaArchivo) throws IOException {
        try {
            return this.ftp.deleteFile(rutaArchivo);
        } catch (IOException e) {
            System.out.println(";eliminarArchivo;FTP;" + e.getMessage());
            return false;
        }
    }

    public boolean desconectar() throws IOException {
        try {
            if (this.ftp.isConnected()) {
                this.ftp.logout();
                this.ftp.disconnect();
                this.ftp = null;
            }
            return true;
        } catch (IOException e) {
            System.out.println(";desconectar;FTP;" + e.getMessage());
            return false;
        }
    }

    public String directorioActual() throws IOException {
        try {
            return this.ftp.printWorkingDirectory();
        } catch (IOException e) {
            System.out.println(";directorioActual;FTP;" + e.getMessage());
            return null;
        }
    }

    public boolean getArchivo(String rutaArchivo, OutputStream outputStream) throws IOException {
        try {
            this.ftp.setFileType(2); // Tipo de archivo: binario
            this.ftp.enterLocalPassiveMode(); // Modo pasivo
            boolean exito = this.ftp.retrieveFile(rutaArchivo, outputStream);
            outputStream.close();
            return exito;
        } catch (IOException e) {
            System.out.println(";getArchivo;FTP;" + e.getMessage());
            return false;
        }
    }

    public boolean cambiarUbicacionArchivo(String ubicacionActual, String ubicacionNueva) throws Exception {
        try {
            return this.ftp.rename(ubicacionActual, ubicacionNueva);
        } catch (IOException e) {
            System.out.println(";cambiarCarpeta;FTP;" + e.getMessage());
            return false;
        }
    }

    public boolean getValidaArchivo(String rutaArchivo) throws IOException {
        boolean exito = false;
        try {
            FTPFile[] remoteFiles = this.ftp.listFiles(rutaArchivo);
            if (remoteFiles.length > 0) {
                System.out.println("El archivo " + remoteFiles[0].getName() + " existe");
                exito = true;
            } else {
                System.out.println("El archivo " + rutaArchivo + " no existe");
                exito = false;
            }
        } catch (IOException e) {
            System.out.println(";getArchivo;FTP;" + e.getMessage());
        }
        return exito;
    }
}
