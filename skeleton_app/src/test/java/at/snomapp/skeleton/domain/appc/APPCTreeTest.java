package at.snomapp.skeleton.domain.appc;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class APPCTreeTest {

    @Test
    void getLanguageReturnsSetLanguage() {
        String language = "DE";
        APPCTree t0 = new APPCTree(language);

        String result = t0.getLanguage();

        assertEquals("DE", result);
    }

    @Test
    void SettersSetAxisAndSearchReturnsExactMatches() {
        APPCTree t0 = new APPCTree("DE");

        AxisEntry modality = new AxisEntry("modality");
        APPCEntry e1 = new APPCEntry("match", "1", null);
        APPCEntry e2 = new APPCEntry("missmatch", "2", null);
        APPCEntry e3 = new APPCEntry("match", "1-1", null);
        APPCEntry e4 = new APPCEntry("match", "2-1", null);
        APPCEntry e5 = new APPCEntry("missmatch", "2-1-1", null);
        APPCEntry e6 = new APPCEntry("match", "2-1-2", null);
        e4.addChild(e5);
        e4.addChild(e6);
        e2.addChild(e4);
        e1.addChild(e3);
        modality.addChild(e1);
        modality.addChild(e2);

        AxisEntry laterality = new AxisEntry("laterality");
        APPCEntry e7 = new APPCEntry("match", "1", null);
        APPCEntry e8 = new APPCEntry("missmatch", "1-1", null);
        e7.addChild(e8);
        laterality.addChild(e7);

        AxisEntry anatomy = new AxisEntry("Anatomy");
        APPCEntry e9 = new APPCEntry("match", "1", null);
        anatomy.addChild(e9);

        AxisEntry procedure = new AxisEntry("Procedure");

        t0.setModality(modality);
        t0.setAnatomy(anatomy);
        t0.setProcedure(procedure);
        t0.setLaterality(laterality);



        Set<Entry> result = t0.search("match");

        assertTrue(result.contains(e1));
        assertTrue(result.contains(e3));
        assertTrue(result.contains(e4));
        assertTrue(result.contains(e6));
        assertTrue(result.contains(e7));
        assertTrue(result.contains(e9));
        assertFalse(result.contains(e2));
        assertFalse(result.contains(e5));
        assertFalse(result.contains(e8));
    }
}