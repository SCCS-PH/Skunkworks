package com.hccs.skunkworks.connections;

import javax.persistence.EntityManagerFactory;

public interface IConnection {

    public EntityManagerFactory getInstanceEMFactory();
}
