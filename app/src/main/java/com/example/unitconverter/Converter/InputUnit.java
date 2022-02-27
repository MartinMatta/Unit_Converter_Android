package com.example.unitconverter.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUnit {

    public List<String> lengthInputUnit = new ArrayList<String>(
            Arrays.asList(
                    "Nanometre nm",
                    "Micrometres μm",
                    "Milimetre mm",
                    "Centimeter cm",
                    "Meter m",
                    "Kilometre km")
    );

    public List<String> weightInputUnit = new ArrayList<String>(
            Arrays.asList(
                    "Milligram mg",
                    "Decigram dg",
                    "Gram g",
                    "Decagram dag",
                    "Hectogram hg",
                    "Kilogram kg",
                    "ton t")
    );

}
