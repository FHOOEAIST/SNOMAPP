package at.snomapp.domain.appc;


import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AxisEntryTest {

    @Test
    void addChildSetsChildAndParent() {
        Entry e0 = new AxisEntry("some description");
        APPCEntry e1 = new APPCEntry("another description", "1", null);

        e0.addChild(e1);

        assertTrue(e0.children.contains(e1));
        assertEquals(e0, e1.parent);
    }

    @Test
    void getDescriptionReturnsTheDescription() {
        Entry e0 = new AxisEntry("desc");

        String description = e0.getDisplayName();

        assertEquals("desc", description);
    }

    @Test
    void getChildrenReturnsTheCorrectContainerOfChildren() {
        Entry e0 = new AxisEntry("root");
        APPCEntry e1 = new APPCEntry("child", "1", null);
        APPCEntry e2 = new APPCEntry("child", "2", null);
        APPCEntry e3 = new APPCEntry("child", "3", null);
        e0.addChild(e1);
        e0.addChild(e2);
        e0.addChild(e3);

        Set<Entry> s = e0.getChildren();

        assertTrue(s.contains(e1));
        assertTrue(s.contains(e2));
        assertTrue(s.contains(e3));
    }

    @Test
    void getParentReturnsNull() {
        Entry e0 = new AxisEntry("root");

        Entry e1 = e0.getParent();

        assertNull(e1);
    }

    @Test
    void searchReturnsAllEntriesThatMatchExactly() {
        Entry e0 = new AxisEntry("root");
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
        e0.addChild(e1);
        e0.addChild(e2);

        Set<Entry> result = e0.search("match");

        assertTrue(result.contains(e1));
        assertTrue(result.contains(e3));
        assertTrue(result.contains(e4));
        assertTrue(result.contains(e6));
        assertFalse(result.contains(e2));
        assertFalse(result.contains(e5));
    }

    @Test
    void GetLayerCodeReturnsMinus1() {
        Entry e = new AxisEntry("something");

        assertEquals(-1, e.getLayerCode());
    }


    @Test
    void GetCodeReturnsNull() {
        Entry e = new AxisEntry("something");

        assertNull(e.getCode());
    }
}