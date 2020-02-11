package com.hccs.skunkworks.engines;



import com.hccs.skunkworks.connections.IConnection;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Postgre implements IConnection {

    
    private final String host = "ec2-184-72-236-57.compute-1.amazonaws.com";
    private final String port = "5432";
    private final String dbname = "d8ja9cf4il3g2l";
    private final String user = "vlfetuqjfwpdcm";
    private final String pass = "32e850804a1719eb0ee009950f14d1edc657bd78ce4f2aaca901ad50b0401365";
    private final String sslString = "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    private EntityManagerFactory emf;

    public Postgre() {
        Map<String, String> properties = new WeakHashMap<>();
        properties.put("javax.persistence.jdbc.url",
                "jdbc:postgresql://" + host
                + ":" + port + "/" + dbname
                + sslString);
        properties.put("javax.persistence.jdbc.user", user);
        properties.put("javax.persistence.jdbc.password", pass);
        properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        properties.put("eclipselink.logging.level", "OFF");

        emf = Persistence.createEntityManagerFactory("SkunkWorks-ViewerPU", properties);
        System.out.println("DataBase at " + host);
    }

    public static Postgre getInstance() {
        return Postgre.EMFactoryHolder.getPostgre();
    }

    public static void closeInstance() {
        Postgre.EMFactoryHolder.closeConnection();
    }

    //<editor-fold defaultstate="collapsed" desc="FactoryHolder">
    private static class EMFactoryHolder {

        private static Postgre INSTANCE = new Postgre();

        public static Postgre getPostgre() {
            if (INSTANCE == null) {
                INSTANCE = new Postgre();
            }
            return INSTANCE;
        }

        public static void closeConnection() {
            INSTANCE.closeConn();
            INSTANCE = null;
        }

        public static EntityManagerFactory getEMFactory() {
            return INSTANCE.getEMF();
        }
    }
    //</editor-fold>

    private EntityManagerFactory getEMF() {
        return emf;
    }

    private void closeConn() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }

    @Override
    public EntityManagerFactory getInstanceEMFactory() {
        return Postgre.EMFactoryHolder.getEMFactory();

    }
}
