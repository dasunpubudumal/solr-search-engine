package com.realitix.solr_engine.solrengine.controllers;

import com.realitix.solr_engine.solrengine.beans.LyricBean;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class SolrController {

    private Logger logger = Logger.getLogger(SolrController.class);
    private HttpSolrClient solrClient;

    @PostConstruct
    public void initialize() {
        solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/songs").build();
        solrClient.setParser(new XMLResponseParser());
    }

    @GetMapping("/query")
    public ArrayList query(@RequestParam(name = "term") String term) {
        QueryResponse response = null;
        SolrQuery query = new SolrQuery();
        ArrayList<LyricBean> list = new ArrayList<LyricBean>();
        query.set("q", term);
        query.set("fl", "artist,author,title,lyrics,score");
        try {
            response = solrClient.query(query);
            SolrDocumentList documentList = response.getResults();
            for(SolrDocument document: documentList) {
                LyricBean lyricBean = new LyricBean();
                lyricBean.setTitle((String) document.getFieldValue("title"));
                lyricBean.setArtist((String) document.getFieldValue("artist"));
                lyricBean.setAuthor((String) document.getFieldValue("author"));
                lyricBean.setScore((float) document.getFieldValue("score"));
                Object[] common = {document.getFieldValue("common")};
                lyricBean.setCommon(common);
                lyricBean.setLyrics((String) document.getFieldValue("lyrics") );
                list.add(lyricBean);
            }
        } catch (SolrServerException | IOException e) {
            logger.error(e.getMessage());
        }

        return list;
    }


}
