package com.example.imports;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        args = new String[1];
        args[0] = "design-pattern-assignments/adapter-csv-import/src/com/example/imports/users.csv";
        if (args.length == 0) throw new IllegalArgumentException("path required");
        Path csv = Path.of(args[0]);

        ProfileImporter importer = new CsvProfileImporter(new NaiveCsvReader(), new ProfileService());
        int n = importer.importFrom(csv);
        System.out.println("Imported " + n + " profiles");
    }
}
