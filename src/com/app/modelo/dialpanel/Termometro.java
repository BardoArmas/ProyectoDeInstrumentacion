/*
Termometro digital
 */
package com.app.modelo.dialpanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;

public class Termometro {

    private DefaultValueDataset dataset;
    private ThermometerPlot plot;
    private JFreeChart chart;
    private ChartPanel panelChart;

    public Termometro() {
    }

    public ChartPanel crearChart() {
        dataset = new DefaultValueDataset(37.2);
        plot = new ThermometerPlot(dataset);
        chart = new JFreeChart("Termometro", plot);
        ChartUtilities.applyCurrentTheme(chart);
        panelChart = new ChartPanel(chart);
        return panelChart;
    }

    public DefaultValueDataset getDataset() {
        return dataset;
    }

    public void setDataset(DefaultValueDataset dataset) {
        this.dataset = dataset;
    }

}
