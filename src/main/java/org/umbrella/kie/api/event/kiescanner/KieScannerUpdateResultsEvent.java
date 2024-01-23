package org.umbrella.kie.api.event.kiescanner;

import org.umbrella.kie.api.builder.Results;

public interface KieScannerUpdateResultsEvent extends KieScannerEvent{
    Results getResults();
}
