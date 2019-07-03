const songs = require("./songs");
const fs = require('fs');

let authors = [];

for (let i = 0; i < songs.length; i++) {
    let song = songs[i];
    authors.push(song.author)
}

const authors_set = [...new Set(authors)];
let authors_json = [];

for (let i = 0; i < authors_set.length; i++) {
    let author = authors_set[i];
    authors_json.push({
        english: author,
        sinhala: ""
    });
}

fs.writeFileSync("authors.json", JSON.stringify(authors_json));
