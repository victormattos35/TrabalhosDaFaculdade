package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.List;

import br.com.mercado.DAO.ProdutoDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Teste {
	public static void main(String[] args) throws JRException, SQLException {
		try {
			System.out.println("Gerando relatório...");
			ProdutoDAO produtoDAO = new ProdutoDAO();
			List listaUs = produtoDAO.listar();

			JasperReport pathjrxml = JasperCompileManager
					.compileReport("relatorio/produto1.jrxml");
			JasperPrint printReport = JasperFillManager.fillReport(pathjrxml,
					null, new JRBeanCollectionDataSource(listaUs));
			JasperExportManager.exportReportToPdfFile(printReport,
					"relatorio/produto1.pdf");
			System.out.println("Relatorio gerado");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
