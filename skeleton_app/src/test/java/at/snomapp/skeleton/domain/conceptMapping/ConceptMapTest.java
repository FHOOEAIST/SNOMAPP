package at.snomapp.skeleton.domain.conceptMapping;

import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;

public class ConceptMapTest {

    @Test
    public void printMappingtoConsole(){
        String appc = "1-2-1-2"; //APPC for eye
        String snomed = "81745001"; //APPC for the eye "region"

        ConceptMap map = new ConceptMapImpl("APPC", "SNOMED CT");
        APPCElement appcElement = new APPCElement(appc,"anatomy", "eye");
        SNOMEDElement snomedElement = new SNOMEDElement(snomed, "displayName");
        map.addMapping(appcElement,snomedElement,EquivalenceType.WIDER);

        System.out.println(map);
    }

    @Test
    public void printToTextFile(){
        String appc = "1-2-1-2"; //APPC for eye
        String snomed = "81745001"; //SNOMED: Structure of eye proper
        String snomed2 = "371398005"; //SNOMED for the eye "region"
        String snomed3 = "314859006"; //SNOMED for the eyeball axis

        ConceptMap map = new ConceptMapImpl("APPC", "SNOMED CT");
        APPCElement appcElement = new APPCElement(appc,"anatomy","eye");
        SNOMEDElement snomedElementMatch = new SNOMEDElement(snomed, "displayName");
        SNOMEDElement snomedElementWider = new SNOMEDElement(snomed2, "displayName");
        SNOMEDElement snomedElementPartOf = new SNOMEDElement(snomed3, "displayName");
        map.addMapping(appcElement,snomedElementWider,EquivalenceType.WIDER);
        map.addMapping(appcElement, snomedElementMatch, EquivalenceType.EQUAL );
        map.addMapping(appcElement,snomedElementPartOf,EquivalenceType.SUBSUMES);

        try {
            map.printMap("testConceptMap.txt");
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail();
        }

    }
}
