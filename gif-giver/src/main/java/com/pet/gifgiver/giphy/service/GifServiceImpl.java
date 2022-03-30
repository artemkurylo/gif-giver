package com.pet.gifgiver.giphy.service;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GifServiceImpl implements GifService {
    @Value("${giphy.query.growth}")
    private String growthQuery;
    @Value("${giphy.query.decline}")
    private String declineQuery;
    @Value("${giphy.query.offset.max}")
    private int randomBound;
    private final Giphy giphy;
    private final Random random;

    @Autowired
    public GifServiceImpl(Giphy giphy, Random random) {
        this.giphy = giphy;
        this.random = random;
    }


    @Override
    public String findGrowthGif() {
        return findGif(growthQuery);
    }

    @Override
    public String findDeclineGif() {
        return findGif(declineQuery);
    }

    /**
     * Метод, предусматривает поиск случайного одного GIF файла, посредством Giphy4J
     * @param query, для поиска GIF файла
     * @return URL представление GIF файла для отображения на странице
     */
    private String findGif(String query) {
        try {
            int randomOffset = random.nextInt(randomBound);
            SearchFeed feed = giphy.search(query, randomOffset);
            int first = 0;
            return feed
                    .getDataList()
                    .get(first)
                    .getImages()
                    .getOriginal()
                    .getUrl();
        } catch (GiphyException e) {
            throw new RuntimeException();
        }
    }
}
