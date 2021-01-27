
package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private final JTextField textField;
    private char operation;
    private double total;
    private boolean isFirstDigit;

    public MyFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 480);
        isFirstDigit = true;

        total = 0;

        JPanel jPanel = new JPanel();

        textField = new JTextField(30);
        textField.setEditable(false);

        jPanel.add(textField);

        JButton[] jbs = new JButton[9];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton(String.valueOf(i + 1));
            jbs[i].setPreferredSize(new Dimension(100, 70));
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            jPanel.add(jbs[i]);
        }

        JButton buttonZero = new JButton("0");
        buttonZero.setPreferredSize(new Dimension(100, 70));
        JButton buttonEquals = new JButton("=");
        buttonEquals.setPreferredSize(new Dimension(100, 70));
        JButton buttonPlus = new JButton("+");
        buttonPlus.setPreferredSize(new Dimension(100, 70));
        JButton buttonMinus = new JButton("-");
        buttonMinus.setPreferredSize(new Dimension(100, 70));
        JButton buttonDivide = new JButton("/");
        buttonDivide.setPreferredSize(new Dimension(100, 70));
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setPreferredSize(new Dimension(100, 70));
        JButton buttonDot = new JButton(".");
        buttonDot.setPreferredSize(new Dimension(30, 30));

        buttonZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculating(e);
            }
        });

        jPanel.add(buttonZero);
        jPanel.add(buttonPlus);
        jPanel.add(buttonMultiply);
        jPanel.add(buttonEquals);
        jPanel.add(buttonDot);
        jPanel.add(buttonMinus);
        jPanel.add(buttonDivide);

        setVisible(true);
        add(jPanel);
    }

    private void calculating(ActionEvent e) {
        String text = textField.getText();
        String digit = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (text.charAt(0)== '-' ||text.charAt(0)== '+'||text.charAt(0)== '/'||text.charAt(0)== '*')
            {
                textField.setText(String.valueOf("Вы сделали херню, введите цифры"));
                break;
            }
            if (((text.charAt(i)== '-' && text.charAt(i-1)== '-')||(text.charAt(i)== '-' && text.charAt(i-1)== '+')||(text.charAt(i)== '-' && text.charAt(i-1)== '*')||(text.charAt(i)== '-' && text.charAt(i-1)== '/')) ||((text.charAt(i)== '+' && text.charAt(i-1)== '-')||(text.charAt(i)== '+' && text.charAt(i-1)== '+')||(text.charAt(i)== '+' && text.charAt(i-1)== '*')||(text.charAt(i)== '+' && text.charAt(i-1)== '/'))||((text.charAt(i)== '*' && text.charAt(i-1)== '-')||(text.charAt(i)== '*' && text.charAt(i-1)== '+')||(text.charAt(i)== '*' && text.charAt(i-1)== '*')||(text.charAt(i)== '*' && text.charAt(i-1)== '/'))||((text.charAt(i)== '/' && text.charAt(i-1)== '-')||(text.charAt(i)== '/' && text.charAt(i-1)== '+')||(text.charAt(i)== '/' && text.charAt(i-1)== '*')||(text.charAt(i)== '/' && text.charAt(i-1)== '/')))
            {
                textField.setText(String.valueOf("Вы сделали херню, введите цифры"));
                break;
            }
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                double currentValue = Double.parseDouble(digit);
                if (isFirstDigit) {
                    total += currentValue;
                    isFirstDigit = false;
                } else {
                    if (operation == '-') {
                        total -= currentValue;
                    } else if (operation == '+') {
                        total += currentValue;
                    }else if (operation == '*') {
                        total *= currentValue;
                    }else if (operation == '/') {
                        total /= currentValue;
                    }
                }

                digit = "";
                operation = c;
                continue;
            }

            digit += c;
        }

        double currentValue = Double.parseDouble(digit);
        if (operation == '-') {
            total -= currentValue;
        } else if (operation == '+') {
            total += currentValue;
        }else if (operation == '*') {
            total *= currentValue;
        }else if (operation == '/') {
            total /= currentValue;
        }

        isFirstDigit = true;
        textField.setText(String.valueOf(total));
        total = 0;
    }

    public void action(ActionEvent event) {
        textField.setText(textField.getText() + event.getActionCommand());
    }
}
