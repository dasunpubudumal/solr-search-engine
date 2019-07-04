# Solr Search Engine (CS4642 Assignment)

<div align="center">
<a href="https://ibb.co/M2F8TvV"><img src="https://i.ibb.co/X2cyBQs/Screenshot-from-2019-07-03-12-26-31.png" alt="Screenshot-from-2019-07-03-12-26-31" border="0"></a>
</div>

## Project Description

* Lyricslk.com provides a collection of songs along with following attributes.
- Lyrics (Sinhala) 
- Artist’s name (Sinhala) 
- Author’s name (English)
- Title (Sinhala)

* Author’s name needs to be converted to sinhala since we are processing the whole query in Sinhala, and therefore we converted them manually. 

* [Scrapy](https://scapy.net/) was used to crawl the website and a seperate application was written to convert the raw data to the appropriate format which is accepted by Solr.

### Indexing Filters

* SWildcard FIlter
* Stop Words Filter
* Hunspell Stem Filter Factory for Etemming

### Query Filters

* Spell checker
* Stop Words Filter
* Synonym Filter
* Hunspell Stem Filter Factory for Stemming

### SOLR Queries

* Search songs by author, title, and artist.
* Combinations of above mentioned fields.
* Wild-card queries.
* Spell checking, queries with incorrect spellings.
* Queries with stemming.
* Queries where stopwords were eliminated.
* Queries with synonyms.

### Sample Queries

1. Songs by authors, title and artist.
    බණ්ඩාර අතාවුද
    හිත අස්සට හීන ගොඩක්
2. Keyword
    සඳ
3. Spell check
    සඳවතයේ insted of සඳවතියේ
4. Combinations
    චන්දන සඳ
5. Wild Card
    `සඳව*`
    `*කුලට`
6. Synonyms
    හඳ
7. stopwords were eliminated
    ඔබ හා මම 
8. Stemming
    ඔබත් මමත් 

## Setup

* Configure your Solr IP, port and core in `config.yaml`.
* Run the `.jar` using the command `java -jar solr-engine-0.0.1-SNAPSHOT.jar`.
* By default, Tomcat runs on port `8080`. Navigate to `http://localhost:8080`, and you'll access **Fake Google**.

## Set up solr core

* Copy the template folder to `solr-xxx/server/solr/` and rename the folder to the name of the core you specify in `config.yaml`.
* Create the core using solr admin

## Add docs to solr core using following command 

* Windows: `java -Dc=songs -jar post.jar song.xml`
* Linux: `./post -c songs songs.xml`

