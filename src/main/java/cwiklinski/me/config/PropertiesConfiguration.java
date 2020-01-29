package cwiklinski.me.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesConfiguration {
    private Logger logger = Logger.getLogger(PropertiesConfiguration.class.getName());
    private String rootPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
    private String appConfigPath = rootPath + "app.properties";
    private Properties appProps;

    public PropertiesConfiguration() {
        appProps = new Properties();
    }

    public Properties getProp() {
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            logger.warning("cannot load properties file");
        }
        return appProps;
    }
}
