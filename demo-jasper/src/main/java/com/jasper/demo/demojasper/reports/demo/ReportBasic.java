package com.jasper.demo.demojasper.reports.demo;

import com.jasper.demo.demojasper.reports.db.DbConection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class ReportBasic {
    public static void main(String[] args) throws JRException, FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:reports/Invoice-alumnos.jrxml");
        // descarga dentro del mismo proyecto
        JasperPrint jasperPrint = JasperFillManager.fillReport(file.getPath(), null,
                DbConection.conectar());
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteAlumnos.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

//         se muestra en una ventana aparte para su descarga
        /*JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
                "C:\\Users\\Ecodeup\\JaspersoftWorkspace\\Reportes Escuela\\ReporteAlumnos.jasper", null,
                Conexion.conectar());
        JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
        jasperViewer.setVisible(true);*/
    }
}
