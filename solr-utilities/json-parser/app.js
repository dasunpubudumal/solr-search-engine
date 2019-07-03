const fs = require('fs');
const builder = require('xmlbuilder');

const songs = require("./songs");
const authors_json = require("./authors");

let authors = {};

for (let i = 0; i < authors_json.length; i++) {
    const author = authors_json[i];
    authors[author.english] = author.sinhala;
}

let root = builder.create('add');

for (let i = 0; i < songs.length; i++) {
    let song = songs[i];
    let doc = root.ele("doc");
    doc.ele("field", {"name": "title"}, song.title);
    doc.ele("field", {"name": "artist"}, song.artist);
    doc.ele("field", {"name": "author"}, authors[song.author]);
    doc.ele("field", {"name": "lyrics"}, song.lyrics);
}

const xml = root.end({pretty: true});
fs.writeFileSync("songs.xml", xml);
