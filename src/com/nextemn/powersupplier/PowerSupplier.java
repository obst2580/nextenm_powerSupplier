package com.nextemn.powersupplier;

public class PowerSupplier {

    public static void main(String[] args) {
        ExcelConverter excelConverter = new ExcelConverter();

        String serialData = excelConverter.readExcel(args[0]);

        Serial serial = new Serial();
        try {
            serial.connect("nextemn data port", serialData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
