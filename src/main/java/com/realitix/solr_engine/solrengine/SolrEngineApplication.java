package com.realitix.solr_engine.solrengine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.realitix.solr_engine.solrengine.beans.config.Configuration;
import com.realitix.solr_engine.solrengine.beans.config.SolarConfiguration;
import com.realitix.solr_engine.solrengine.controllers.SolrController;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class SolrEngineApplication {

    private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    private static Logger logger = Logger.getLogger(SolrController.class);
    public static Configuration configuration = null;

    static {
        try {
            configuration = mapper.readValue(new File("config.yaml"), Configuration.class);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SolrEngineApplication.class, args);
    }

}
