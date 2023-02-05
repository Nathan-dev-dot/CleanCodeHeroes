package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.application.CardNotFoundException;
import com.cleancodeheroes.card.application.port.out.CreateCardPort;
import com.cleancodeheroes.card.application.port.out.FindCardPort;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.mapper.BsonCardMapper;
import com.cleancodeheroes.shared.adapter.out.NoSQLRepository;
import com.cleancodeheroes.utils.BsonFilter;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import org.bson.BsonValue;
import org.bson.Document;

@RequiredArgsConstructor
public class NoSQLCardPersistence implements CreateCardPort, FindCardPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getNoSQLDatabase().getCollection("cards");

    @Override
    public CardId save (Card card) throws IllegalArgumentException {
        final NoSQLCardPersistenceDTO noSQLCardPersistenceDTO = new NoSQLCardPersistenceDTO(card);
        final Document cardDocument = DocumentUtils.documentFromObject(noSQLCardPersistenceDTO);
        final BsonValue insertedId = registry.insertOne(cardDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return CardId.of(insertedIdStr);
    }

    @Override
    public Card load (CardId cardId) throws CardNotFoundException {
        FindIterable<Document> res = registry.find(
                BsonFilter.byId(cardId.value())
        );
        if (DocumentUtils.sizeof(res) == 0) throw new CardNotFoundException();
        return res.map(doc -> new BsonCardMapper(doc).toDomain()).first();
    }
}
