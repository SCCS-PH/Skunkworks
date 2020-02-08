package com.hccs.skunkworks;

import com.hccs.skunkworks.connections.EngineConnector;
import com.hccs.skunkworks.engines.Postgre;

public class SkunkWork extends EngineConnector {

    public SkunkWork() {
        setEngine(Postgre.getInstance());
    }
}
