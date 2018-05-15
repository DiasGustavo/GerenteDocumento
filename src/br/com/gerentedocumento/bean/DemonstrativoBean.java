package br.com.gerentedocumento.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean
@ViewScoped
public class DemonstrativoBean {
	private LineChartModel lineGrafico;

	public LineChartModel getLineGrafico() {
		return lineGrafico;
	}

	public void setLineGrafico(LineChartModel lineGrafico) {
		this.lineGrafico = lineGrafico;
	}
	
	@PostConstruct
	public void init(){
		demonstrativos();
	}

	public void demonstrativos() {

		lineGrafico = new LineChartModel();
		

		ChartSeries processos = new ChartSeries();
		processos.setLabel("Processos");
		processos.set("abril", 200);
		processos.set("maio", 50);
		processos.set("junho", 290);
		lineGrafico.addSeries(processos);

		lineGrafico.setTitle("Processos");
		lineGrafico.setLegendPosition("e");
		lineGrafico.setShowPointLabels(true);

		lineGrafico.getAxes().put(AxisType.X, new CategoryAxis("Anos"));
		Axis yAxis = lineGrafico.getAxis(AxisType.Y);
		yAxis.setLabel("Quantidade");
		yAxis.setMin(0);
		yAxis.setMax(400);
	}
}
