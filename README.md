# Solr Search Engine (CS4642 Assignment)

<div align="center">
<a href="https://ibb.co/M2F8TvV"><img src="https://i.ibb.co/X2cyBQs/Screenshot-from-2019-07-03-12-26-31.png" alt="Screenshot-from-2019-07-03-12-26-31" border="0"></a>
</div>

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

