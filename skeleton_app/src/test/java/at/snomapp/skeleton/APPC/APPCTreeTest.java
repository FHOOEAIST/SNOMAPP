package at.snomapp.skeleton.APPC;

import at.snomapp.skeleton.APPC.impl.APPCEntry;
import at.snomapp.skeleton.APPC.impl.APPCTree;
import at.snomapp.skeleton.APPC.impl.AxisEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class APPCTreeTest {

    @Test
    void getLanguageReturnsSetLanguage() {
        String language = "DE";
        FourAxisTree t0 = new APPCTree(language);

        String result = t0.getLanguage();

        Assertions.assertEquals("DE", result);
    }

    @Test
    void SettersSetAxisAndSearchReturnsExactMatches() {
        FourAxisTree t0 = new APPCTree("DE");

        AxisEntry modality = new AxisEntry("modality");
        APPCEntry e1 = new APPCEntry("match", 1);
        APPCEntry e2 = new APPCEntry("missmatch", 1);
        APPCEntry e3 = new APPCEntry("match", 2);
        APPCEntry e4 = new APPCEntry("match", 2);
        APPCEntry e5 = new APPCEntry("missmatch", 3);
        APPCEntry e6 = new APPCEntry("match", 3);
        e4.addChild(e5);
        e4.addChild(e6);
        e2.addChild(e4);
        e1.addChild(e3);
        modality.addChild(e1);
        modality.addChild(e2);

        AxisEntry laterality = new AxisEntry("laterality");
        APPCEntry e7 = new APPCEntry("match", 1);
        APPCEntry e8 = new APPCEntry("missmatch", 2);
        e7.addChild(e8);
        laterality.addChild(e7);

        AxisEntry anatomy = new AxisEntry("Anatomy");
        APPCEntry e9 = new APPCEntry("match", 1);
        anatomy.addChild(e9);

        AxisEntry procedure = new AxisEntry("Procedure");

        t0.setModality(modality);
        t0.setAnatomy(anatomy);
        t0.setProcedure(procedure);
        t0.setLaterality(laterality);

        Set<Entry> result = t0.serach("match");

        Assertions.assertTrue(result.contains(e1));
        Assertions.assertTrue(result.contains(e3));
        Assertions.assertTrue(result.contains(e4));
        Assertions.assertTrue(result.contains(e6));
        Assertions.assertTrue(result.contains(e7));
        Assertions.assertTrue(result.contains(e9));
        Assertions.assertFalse(result.contains(e2));
        Assertions.assertFalse(result.contains(e5));
        Assertions.assertFalse(result.contains(e8));
    }
}