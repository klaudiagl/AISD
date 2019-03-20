package ProgramService;

import java.util.List;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public final class OutputGenerator {
	
	public static void DisplayChart(List<Double> comp, List<Double> swaps){
		JFreeChart chart = null;
		XYSplineRenderer renderer = new XYSplineRenderer();
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		ValueAxis x = new NumberAxis();
		ValueAxis y = new NumberAxis();
		
		XYSeries series1 = new XYSeries("comparisons");
		XYSeries series2 = new XYSeries("swaps");
		
		for(int i=0; i<comp.size(); i++){
			series1.add(i*100, comp.get(i));
			series2.add(i*100, swaps.get(i));
		}
		
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		x.setLabel("n");
		y.setLabel("comparisons/swaps");
		
		XYPlot plot = new XYPlot(dataset, x, y, renderer);
		chart = new JFreeChart(plot);
		
		ChartPanel panel = new ChartPanel(chart);
		panel.setVisible(true);
		
		OutputPanel frame = new OutputPanel();
		frame.add(panel);
		frame.setVisible(true);
	}
}
