package org.ffmoyano.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    static Config _config;
    static {
        try {
            _config = ConfigFactory.parseResources("ImageHosting.conf");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Config getConfig() {
        return _config;
    }

}