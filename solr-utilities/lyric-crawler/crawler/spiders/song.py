import scrapy


class ArtistsSpider(scrapy.Spider):
    name = 'song'

    start_urls = [
        "http://lyricslk.com/lyrics/amarasiri-pieris/1749-charu-dehe-nura.html"
    ]

    def parse(self, response):
        author = self.get_author(
            response.xpath("/html/body/div[2]/div[2]/div[2]/div[4]/div[6]/span[4]/text()").extract_first())
        title, artist = self.get_title_and_artist(
            response.xpath("/html/body/div[2]/div[2]/div[2]/div[4]/div[2]/h2/text()").extract_first())

        yield {
            'title': title,
            'artist': artist,
            'author': author,
            'lyrics': self.get_lyrics(response.xpath('//*[@id="lyricsBody"]/text()').extract())
        }

    def get_title_and_artist(self, heading):
        title = heading.split("-")[0].strip()
        artist = heading.split("-")[1].strip()
        return title, artist

    def get_author(self, text):
        return text.strip(':').strip()

    def get_lyrics(self, lyrics):
        lyrics_text = ""
        for lyric in lyrics:
            text = lyric.replace(".", "").replace("/", "").strip()
            if text:
                lyrics_text = (lyrics_text + text + " ")
        return lyrics_text.strip()
