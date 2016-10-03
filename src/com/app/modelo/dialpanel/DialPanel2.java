/*
Segundo dial
 */
package com.app.modelo.dialpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialCap;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

public class DialPanel2 extends JPanel {

    DefaultValueDataset dataset;
    private final DialPlot dialplot;

    public DialPanel2() {
        super(new BorderLayout());
        dataset = new DefaultValueDataset(0.0D);
        //
        dialplot = new DialPlot();
        dialplot.setDataset(dataset);
        dialplot.setDialFrame(new StandardDialFrame());
        dialplot.setBackground(new DialBackground());
        DialTextAnnotation dialtextannotation = new DialTextAnnotation("Temperature");
        dialtextannotation.setFont(new Font("Dialog", Font.ITALIC, 14));
        dialtextannotation.setRadius(0.69999999999999996D);
        dialplot.addLayer(dialtextannotation);
        DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
        dialplot.addLayer(dialvalueindicator);
        StandardDialScale standarddialscale = new StandardDialScale(-40D, 60D, -120D, -300D, 10D, 4);
        standarddialscale.setMajorTickIncrement(10D);
        standarddialscale.setMinorTickCount(4);
        standarddialscale.setTickRadius(0.88D);
        standarddialscale.setTickLabelOffset(0.14999999999999999D);
        standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
        dialplot.addScale(0, standarddialscale);
        dialplot.addPointer(new org.jfree.chart.plot.dial.DialPointer.Pin());
        DialCap dialcap = new DialCap();
        dialplot.setCap(dialcap);
        JFreeChart jfreechart = new JFreeChart("Dial Demo 1", dialplot);
        //
        //DialPlot dialplot1 = (DialPlot) jfreechart.getPlot();
        //Agregando colores a los rangos
        StandardDialRange standarddialrange = new StandardDialRange(40D, 60D, Color.red);
        standarddialrange.setInnerRadius(0.52000000000000002D);
        standarddialrange.setOuterRadius(0.55000000000000004D);
        dialplot.addLayer(standarddialrange);
        StandardDialRange standarddialrange1 = new StandardDialRange(10D, 40D, Color.orange);
        standarddialrange1.setInnerRadius(0.52000000000000002D);
        standarddialrange1.setOuterRadius(0.55000000000000004D);
        dialplot.addLayer(standarddialrange1);
        StandardDialRange standarddialrange2 = new StandardDialRange(-40D, 10D, Color.blue);
        standarddialrange2.setInnerRadius(0.52000000000000002D);
        standarddialrange2.setOuterRadius(0.55000000000000004D);
        dialplot.addLayer(standarddialrange2);
        //
        GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
        DialBackground dialbackground = new DialBackground(gradientpaint);
        dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        dialplot.setBackground(dialbackground);
        dialplot.removePointer(0);
        org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
        pointer.setFillPaint(Color.green);
        dialplot.addPointer(pointer);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(400, 400));
        add(chartpanel);
    }

    public DefaultValueDataset getDataset() {
        return dataset;
    }

    public void setDataset(DefaultValueDataset dataset) {
        this.dataset = dataset;
    }
    
    

}
