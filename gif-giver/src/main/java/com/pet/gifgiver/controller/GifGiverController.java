package com.pet.gifgiver.controller;

import com.pet.gifgiver.giphy.service.GifService;
import com.pet.gifgiver.service.GameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Основной контроллер, который позволяет пользователю при обращении сыграть в игру.
 */
@Controller
@RequestMapping("/gif-giver")
public class GifGiverController {
    @Value("${game.web.attribute.name}")
    private String attributeName;
    @Value("${game.web.page.name}")
    private String pageName;
    private final GameService gameService;
    private final GifService gifService;

    public GifGiverController(GameService gameService, GifService gifService) {
        this.gameService = gameService;
        this.gifService = gifService;
    }

    /**
     * Метод, в случае если базовая валюта поднялась выше своего значения относительно ранее заданного, возращает пользователю
     * HTML страницу, содерщающую GIF
     */
    @GetMapping("/game")
    public String playGame(Model model) {
        String url;
        if (gameService.isCurrencyHigherThanBefore()) {
            url = gifService.findGrowthGif();
        } else {
            url = gifService.findDeclineGif();
        }
        model.addAttribute(attributeName, url);
        return pageName;
    }
}
