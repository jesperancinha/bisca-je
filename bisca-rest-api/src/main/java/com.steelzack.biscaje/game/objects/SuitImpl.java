package com.steelzack.biscaje.game.objects;

import com.steelzack.biscaje.game.enums.CardType;
import com.steelzack.biscaje.game.enums.DeckType;
import com.steelzack.biscaje.game.enums.SuitType;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
@Getter
public class SuitImpl implements Suit {
    private final Map<Integer, Card> cards;
    private final DeckType deckType;
    private SuitType suitType;

    public SuitImpl(final SuitType suitType, final DeckType deckType) {
        this.suitType = suitType;
        this.deckType = deckType;
        this.cards = createCards(this.suitType, this.deckType);
    }

    @Override
    public Map<Integer, Card> createCards(SuitType suitType, DeckType deckType) {
        final Map<Integer, Card> localCards = new HashMap<>();
        return Arrays.stream( //
                CardType.values()).filter( //
                cardType -> cardType.getDeckType() == deckType //
        ).collect( //
                toMap( //
                        CardType::getOrder, //
                        CardImpl::new //
                ) //
        );

    }
}