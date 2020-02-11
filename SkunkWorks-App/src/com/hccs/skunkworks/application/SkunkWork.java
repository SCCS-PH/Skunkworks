package com.hccs.skunkworks.application;

import com.hccs.skunkworks.connections.EngineConnector;
import com.hccs.skunkworks.engines.Postgre;

public class SkunkWork extends EngineConnector {

    public SkunkWork() {
        setEngine(Postgre.getInstance());
    }
}
