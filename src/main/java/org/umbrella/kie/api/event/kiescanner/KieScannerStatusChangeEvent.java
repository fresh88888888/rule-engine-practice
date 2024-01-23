package org.umbrella.kie.api.event.kiescanner;

import org.umbrella.kie.api.builder.KieScanner;

public interface KieScannerStatusChangeEvent extends KieScannerEvent{
    KieScanner.Status geStatus();
}
