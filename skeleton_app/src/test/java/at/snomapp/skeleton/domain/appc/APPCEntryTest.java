package at.snomapp.skeleton.domain.appc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class APPCEntryTest {

    @Test
    void addChildSetsChildAndParent() {
        Entry e0 = new APPCEntry("some description", "1", null);
        APPCEntry e1 = new APPCEntry("another description", "1-1", null);

        e0.addChild(e1);

        Assertions.assertTrue(e0.children.contains(e1));
        Assertions.assertEquals(e0, e1.parent);
    }

    @Test
    void getDisplayNameReturnsTheDescription() {
        Entry e0 = new APPCEntry("desc", "1", null);

        String displayName = e0.getDisplayName();

        Assertions.assertEquals("desc", displayName);
    }

    @Test
    void getChildrenReturnsTheCorrectContainerOfChildren() {
        Entry e0 = new APPCEntry("root", "1", null);
        APPCEntry e1 = new APPCEntry("child", "1-1", null);
        APPCEntry e2 = new APPCEntry("child", "1-2", null);
        APPCEntry e3 = new APPCEntry("child", "1-3", null);
        e0.addChild(e1);
        e0.addChild(e2);
        e0.addChild(e3);

        Set<Entry> s = e0.getChildren();

        Assertions.assertTrue(s.contains(e1));
        Assertions.assertTrue(s.contains(e2));
        Assertions.assertTrue(s.contains(e3));
    }

    @Test
    void getParentReturnsCorrectAPPCParent() {
        APPCEntry e0 = new APPCEntry("child", "1-1", null);
        Entry e1 = new APPCEntry("parent", "1", null);
        e1.addChild(e0);

        Entry e2 = e0.getParent();

        Assertions.assertEquals(e1, e2);
    }

    @Test
    void getParentReturnsNullIfNotSet() {
        Entry e0 = new APPCEntry("parent", "1", null);

        Entry e1 = e0.getParent();

        Assertions.assertNull(e1);
    }

    @Test
    void getParentReturnsCorrectAxisParent() {
        APPCEntry e0 = new APPCEntry("child", "1", null);
        Entry e1 = new AxisEntry("parent");
        e1.addChild(e0);

        Entry e2 = e0.getParent();

        Assertions.assertEquals(e1, e2);
    }

    @Test
    void searchReturnsAllEntriesThatMatchExactly() {
        Entry e0 = new APPCEntry("root", "1", null);
        APPCEntry e1 = new APPCEntry("match", "1-1", null);
        APPCEntry e2 = new APPCEntry("missmatch", "1-2", null);
        APPCEntry e3 = new APPCEntry("match", "1-1-1", null);
        APPCEntry e4 = new APPCEntry("match", "1-2-1", null);
        APPCEntry e5 = new APPCEntry("missmatch", "1-2-1-1", null);
        APPCEntry e6 = new APPCEntry("match", "1-2-1-2", null);
        e4.addChild(e5);
        e4.addChild(e6);
        e2.addChild(e4);
        e1.addChild(e3);
        e0.addChild(e1);
        e0.addChild(e2);

        Set<Entry> result = e0.search("match");

        Assertions.assertTrue(result.contains(e1));
        Assertions.assertTrue(result.contains(e3));
        Assertions.assertTrue(result.contains(e4));
        Assertions.assertTrue(result.contains(e6));
        Assertions.assertFalse(result.contains(e2));
        Assertions.assertFalse(result.contains(e5));
    }

    @Test
    void getLayerCodeReturnsCorrectLayerCodeIfOnlyOneCodeExists() {
        int layer = 1;
        APPCEntry e0 = new APPCEntry("desc", "1", null);

        int code = e0.getLayerCode();

        Assertions.assertEquals(layer, code);
    }


    @Test
    void getLayerCodeReturnsCorrectLayerCodeIfCodeIsComposite() {
        int layer = 6;
        APPCEntry e0 = new APPCEntry("desc", "1-4-5-6", null);

        int code = e0.getLayerCode();

        Assertions.assertEquals(layer, code);
    }

    @Test
    void getLayerCodeReturnsMinus1IfInitializedWithNull() {
        int layer = -1;
        APPCEntry e0 = new APPCEntry("desc", null, null);

        int code = e0.getLayerCode();

        Assertions.assertEquals(layer, code);
    }

    @Test
    void getLayerCodeReturnsMinus1IfInitializedWithEmptyString() {
        int layer = -1;
        APPCEntry e0 = new APPCEntry("desc", "", null);

        int code = e0.getLayerCode();

        Assertions.assertEquals(layer, code);
    }

    @Test
    void getCodeReturnsCorrectCode() {
        String code = "1-2-5";
        APPCEntry e0 = new APPCEntry("desc", code, null);

        String res = e0.getCode();

        Assertions.assertEquals(code, res);
    }

    @Test
    void getCodeReturnsNullifSetWithNull() {
        APPCEntry e0 = new APPCEntry("desc", null, null);

        String res = e0.getCode();

        Assertions.assertNull(res);
    }

}