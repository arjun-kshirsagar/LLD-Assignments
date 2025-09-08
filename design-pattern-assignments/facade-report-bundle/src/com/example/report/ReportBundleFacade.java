package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter writer;
    private final Zipper zipper;
    private final AuditLog audit;

    public ReportBundleFacade(JsonWriter writer, Zipper zipper, AuditLog audit) {
        this.writer = Objects.requireNonNull(writer, "writer");
        this.zipper = Objects.requireNonNull(zipper, "zipper");
        this.audit = Objects.requireNonNull(audit, "audit");
    }

    public Path export(Map<String,Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        // write JSON
        Path json = writer.write(data, outDir, baseName);

        // zip into baseName.zip inside outDir
        Path zip = zipper.zip(json, outDir.resolve(baseName + ".zip"));

        // audit
        audit.log("exported " + zip);

        return zip;
    }
}
