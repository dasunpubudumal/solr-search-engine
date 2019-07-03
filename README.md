# Solr Search Engine (CS4642 Assignment)

<a href="https://ibb.co/2dmFQS5"><img src="https://i.ibb.co/1Th05Mb/Screenshot-from-2019-07-03-12-26-31.png" alt="Screenshot-from-2019-07-03-12-26-31" border="0"></a><br /><a target='_blank' href='https://imgbb.com/'></a><br />

## Setup

* Configure your Solr IP, port and core in `config.yaml`.
* Run the `.jar` using the command `java -jar solr-engine-0.0.1-SNAPSHOT.jar`.
* By default, Tomcat runs on port `8080`. Navigate to `http://localhost:8080`, and you'll access **Fake Google**.

## Set up solr core

* Copy the template folder to 'solr-xxx/server/solr/' and rename the folder to 'songs'
* Create the core using solr admin

## Add docs to solr core using following command 

windows: java -Dc=songs -jar post.jar song.xml
linux: ./post -c songs songs.xml

