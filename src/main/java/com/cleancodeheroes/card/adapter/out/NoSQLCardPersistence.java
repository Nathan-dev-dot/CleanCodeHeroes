package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.application.port.out.CreateCardPort;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.domain.CardProps;
import com.cleancodeheroes.shared.NoSQLRepository;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import org.bson.BsonValue;
import org.bson.Document;

@RequiredArgsConstructor
public class NoSQLCardPersistence implements CreateCardPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getInstance().getDatabase().getCollection("cards");

    @Override
    public CardId save(Card card) throws IllegalArgumentException {
        final CardProps cardProps = CardProps.of(card);
        final NoSQLCardPersistenceDTO noSQLCardPersistenceDTO = new NoSQLCardPersistenceDTO(cardProps);
        final Document cardDocument = DocumentUtils.documentFromObject(noSQLCardPersistenceDTO);
        final BsonValue insertedId = registry.insertOne(cardDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return CardId.of(insertedIdStr);
    }
}
