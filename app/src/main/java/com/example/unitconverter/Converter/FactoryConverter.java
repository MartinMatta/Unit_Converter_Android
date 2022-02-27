package com.example.unitconverter.Converter;

import android.content.Context;

public class FactoryConverter {

    private static InputUnit inputUnit = new InputUnit();

    public static Converter createObject(String unitType, Context context) {

        Converter converter;

        switch(unitType) {
            case "Length":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Weight":
                converter = new Converter(inputUnit.weightInputUnit, context);
                break;
            case "Volume":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Temperature":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Area":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Pressure":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Energy":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Power":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Force":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Time":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Frequency":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;
            case "Speed":
                converter = new Converter(inputUnit.lengthInputUnit, context);
                break;

            default:
                converter = new Converter(inputUnit.lengthInputUnit, context);
        }

        return converter;

    }

}
