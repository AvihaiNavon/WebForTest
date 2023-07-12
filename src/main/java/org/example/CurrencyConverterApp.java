package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyConverterApp extends JFrame {
    private JLabel resultLabel;
    private JTextField amountTextField;
    private JComboBox<String> currencyComboBox;
    private JButton convertButton;

    public CurrencyConverterApp() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        resultLabel = new JLabel("Converted amount: ");
        add(resultLabel);

        amountTextField = new JTextField(10);
        add(amountTextField);

        currencyComboBox = new JComboBox<>(new String[]{"EUR/USD", "GBP/USD", "USD/JPY", "USD/CAD", "AUD/USD"});
        add(currencyComboBox);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCurrency = (String) currencyComboBox.getSelectedItem();// לוקח את הבחירה של התיבת בחירה
                try {
                    double amount = Double.parseDouble(amountTextField.getText());// ממיר את הטקסט כסף
                    double convertedAmount = convertCurrency(selectedCurrency, amount);
                    resultLabel.setText("Converted amount: " + convertedAmount);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid amount");
                }
            }
        });
        add(convertButton);

        pack();
        setVisible(true);
    }

    private double convertCurrency(String currencyPair, double amount) {
        WebDriver driver = new ChromeDriver();
            driver.get("https://www.hamara.co.il/");
            WebElement webElement=driver.findElement(By.xpath("//*[@id=\"SelectCurrencyAmount\"]"));
            webElement.sendKeys("500");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement webElement1=driver.findElement(By.xpath("//*[@id=\"select2-SelectSourceCurrency-container\"]"));
            webElement1.click();
        WebElement webElement2=driver.findElement(By.xpath("//*[@id=\"tab-one\"]/div/div[1]/div[4]/div/span/span[1]/span"));
        webElement2.click();



                return 0;
                }


                }

