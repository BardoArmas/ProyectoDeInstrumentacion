/*
Clase para mostrar los datos de entrada a manera de barras
 */
package com.app.modelo.dialpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarrasPanel {

    private final DefaultCategoryDataset dataset;
    private JFreeChart chart;
    private ChartPanel barrasChart;
    private GradientPaint gp0;
    private GradientPaint gp1;
    private GradientPaint gp2;
    private final String series1 = "SensorA";
    private final String series2 = "SensorB";
    private final String series3 = "SensorC";
    private final String category1 = "Sensores";

    public BarrasPanel() {
        //dataset = new DefaultCategoryDataset();
        dataset = new DefaultCategoryDataset();
    }

    private void createDataset() {
        // create the dataset...
        dataset.addValue(700.0, series1, category1);
        dataset.addValue(1024.0, series2, category1);
        dataset.addValue(100.0, series3, category1);

    }

    public void escribirValor(double s1, double s2, double s3) {
        dataset.setValue(s1, series1, category1);
        dataset.setValue(s2, series2, category1);
        dataset.setValue(s3, series3, category1);
    }

    public ChartPanel crearChart() {
        createDataset();
        // create the chart...
        chart = ChartFactory.createBarChart(
                "Datos de entrada", // chart title
                "Sensores", // domain axis label
                "Valor Digital", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
        chart.setBackgroundPaint(new Color(0xBBBBDD));

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.10D);

        // set up gradient paints for series...
        gp0 = new GradientPaint(
                0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, Color.lightGray
        );
        gp1 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.lightGray
        );
        gp2 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        // OPTIONAL CUSTOMISATION COMPLETED.
        barrasChart = new ChartPanel(chart);
        barrasChart.setPreferredSize(new Dimension(388, 300));
        return barrasChart;
    }
}
