import scrapy


class ArtistsSpider(scrapy.Spider):
    name = 'main_spider'

    start_urls = [
        'http://lyricslk.com/artists'
    ]

    def parse(self, response):
        for artist in response.xpath("//div[@id='resultsWrapper']/ul/li/a"):
            if artist.xpath("./text()").extract_first().split()[-2] != 'No':
                next_page = artist.xpath("./@href").extract_first()
                next_page_url = response.urljoin(next_page)
                yield scrapy.Request(url=next_page_url, callback=self.parse_artist_url)

    def parse_artist_url(self, response):
        for song in response.xpath("//div[@class='ResTitle']/a"):
            song_page = song.xpath("./@href").extract_first()
            song_url = response.urljoin(song_page)
            yield scrapy.Request(url=song_url, callback=self.parse_song_url)

    def parse_song_url(self, response):
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
