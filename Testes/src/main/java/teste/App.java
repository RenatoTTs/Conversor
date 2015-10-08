package teste;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("JavaWorld", new Integer(75));
		pieDataset.setValue("Other", new Integer(25));
		JFreeChart chart = ChartFactory.createPieChart("Sample Pie Chart",  pieDataset,    true, false, false );
		
	}
}
