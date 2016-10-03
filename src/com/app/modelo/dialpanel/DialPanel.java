/*
 */
package com.app.modelo.dialpanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Point;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.ArcDialFrame;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;



public class DialPanel{
    private DefaultValueDataset dataset;
    private final DialPlot dialplot;
    private ChartPanel dialChart;
    
    public DialPanel(){
        dataset = new DefaultValueDataset(50D);
        dialplot = new DialPlot();
    }
    
    public ChartPanel crearChart(){
        dialplot.setView(0.20999999999999999D, 0.0D, 0.57999999999999996D, 0.29999999999999999D);
        dialplot.setDataset(dataset);
        ArcDialFrame arcdialframe = new ArcDialFrame(60D, 60D);
        arcdialframe.setInnerRadius(0.59999999999999998D);
        arcdialframe.setOuterRadius(0.90000000000000002D);
        arcdialframe.setForegroundPaint(Color.darkGray);
        arcdialframe.setStroke(new BasicStroke(3F));
        dialplot.setDialFrame(arcdialframe);
        GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(240, 240, 240));
        DialBackground dialbackground = new DialBackground(gradientpaint);
        dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        dialplot.addLayer(dialbackground);
        //Cambiar los rangos de el dial
        StandardDialScale standarddialscale = new StandardDialScale(0.0D, 1000D, 115D, -50D, 10D, 4);
        standarddialscale.setTickRadius(0.88D);
        standarddialscale.setTickLabelOffset(0.070000000000000007D);
        standarddialscale.setMajorTickIncrement(250D);
        dialplot.addScale(0, standarddialscale);
        org.jfree.chart.plot.dial.DialPointer.Pin pin = new org.jfree.chart.plot.dial.DialPointer.Pin();
        pin.setRadius(0.81999999999999995D);
        dialplot.addLayer(pin);
        JFreeChart jfreechart = new JFreeChart(dialplot);
        jfreechart.setTitle("Dial");
        dialChart =  new ChartPanel(jfreechart);
        return dialChart;
    }
    
    public DefaultValueDataset getDataset() {
        return dataset;
    }

    public void setDataset(DefaultValueDataset dataset) {
        this.dataset = dataset;
    }
}
