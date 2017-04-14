package Demo;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by lenovo on 2017/3/22.
 */
public class liggageUI {
    private  JRadioButton RadioButton1;
    private JRadioButton RadioButton2;
    private JRadioButton RadioButton3;
    private JRadioButton RadioButton4;
    private JRadioButton RadioButton5;
    private JRadioButton RadioButton6;
    private JRadioButton RadioButton7;
    private JRadioButton RadioButton8;
    private JTextField textFieldprice;
    private JTextField textFieldweight;
    private JTextField textFieldsize;
    private JLabel numlabel;
    private JTextField textFieldnum;
    private JTextField textFieldresult;
    private JButton ButtonCal;
    private JButton ButtonCancel;
    private JLabel calLabel;
    private JLabel sizeLabel;
    private JPanel weightLabel;
    private JLabel priceLabel;
    private JLabel sitLabel;
    private JLabel routeLabel;//路线
    private JLabel labelshili;
    private JLabel weightshili;
    private String position;//舱位;
    private int route=-1;
    public liggageUI() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (RadioButton1.isSelected()){
                  route=0;
              }
              else if (RadioButton2.isSelected()){
                  route=1;
              }
              else if (RadioButton3.isSelected()){
                  route=2;
              }
              else if (RadioButton4.isSelected()){
                  route=3;
              }
              else if (RadioButton5.isSelected()){
                  route=4;
              }
            }
        };
        RadioButton2.addActionListener(listener);
        RadioButton3.addActionListener(listener);
        RadioButton1.addActionListener(listener);
        RadioButton4.addActionListener(listener);
        RadioButton5.addActionListener(listener);
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(RadioButton6.isSelected()){
                    position="头等舱";
                }
                else if (RadioButton7.isSelected()){
                   position="公务舱";
               }
               else if (RadioButton8.isSelected()){
                   position="经济舱";
               }
            }
        };
        RadioButton6.addActionListener(listener1);
        RadioButton7.addActionListener(listener1);
        RadioButton8.addActionListener(listener1);
        ButtonCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price= Double.valueOf(textFieldprice.getText()).doubleValue();
                int num =Integer.valueOf(textFieldnum.getText()).intValue();
                String w=textFieldweight.getText();  String s=textFieldsize.getText();
                luggage []luggage=new luggage[num];
                for (int i = 0; i < num; i++) {
                    luggage[i]=new luggage();
                }
                String []w1=w.split("、");   String []s1=s.split("、"); float []size=new float[num];
                String []s2;

                for (int i=0;i<s1.length;i++){
                    s2=s1[i].split("\\*");
                    for (int j = 0; j < s2.length; j++) {
                        size[i]+=Float.parseFloat(s2[j]);
                        float sss=size[i];
                        System.out.println(sss);
                    }

                }
                for (int i = 0; i <num ; i++) {
                    //luggage[i].setSize(size[i]);
                    luggage[i].setSize(size[i]);
                    luggage[i].setWeight(Float.parseFloat(w1[i]));
                }
                consignment co=new consignment(route,position);
                co.setNum(num); co.setTprice(price);
                double p=co.Totalamout(luggage);
                textFieldresult.setText(Double.toString(p));
            }
        });
        ButtonCancel.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                textFieldprice.setText("");
                textFieldnum.setText("");
                textFieldweight.setText("");
                textFieldsize.setText("");
                textFieldresult.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("行李托运");
        frame.setBounds(200,200,200,200);
        frame.setContentPane(new liggageUI().weightLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
