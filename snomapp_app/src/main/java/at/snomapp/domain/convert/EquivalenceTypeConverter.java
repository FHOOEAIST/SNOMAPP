package at.snomapp.domain.convert;

import at.snomapp.domain.conceptMapping.EquivalenceType;
import org.neo4j.ogm.typeconversion.AttributeConverter;

public class EquivalenceTypeConverter implements AttributeConverter<EquivalenceType, String> {

    @Override
    public String toGraphProperty(EquivalenceType equivalenceType) {
        return equivalenceType.toString();
    }

    @Override
    public EquivalenceType toEntityAttribute(String s) {
        return EquivalenceType.valueOf(s);
    }
}
