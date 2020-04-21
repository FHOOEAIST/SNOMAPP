package at.snomapp.skeleton.APPC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AxisEntryTest {

    @Test
    void addChildSetsChildAndParent() {
        Entry e0 = new AxisEntry("some description");
        APPCEntry e1 = new APPCEntry("another description", 1);

        e0.addChild(e1);

        Assertions.assertTrue(e0.children.contains(e1));
        Assertions.assertEquals(e0, e1.parent);
    }

    @Test
    void getDescriptionReturnsTheDescription() {
        Entry e0 = new AxisEntry("desc");

        String description = e0.getDescription();

        Assertions.assertEquals("desc", description);
    }

    @Test
    void getChildrenReturnsTheCorrectContainerOfChildren() {
        Entry e0 = new AxisEntry("root");
        APPCEntry e1 = new APPCEntry("child", 1);
        APPCEntry e2 = new APPCEntry("child", 1);
        APPCEntry e3 = new APPCEntry("child", 1);
        e0.addChild(e1);
        e0.addChild(e2);
        e0.addChild(e3);

        Set<Entry> s = e0.getChildren();

        Assertions.assertTrue(s.contains(e1));
        Assertions.assertTrue(s.contains(e2));
        Assertions.assertTrue(s.contains(e3));
    }

    @Test
    void getParentReturnsNull() {
        Entry e0 = new AxisEntry("root");

        Entry e1 = e0.getParent();

        Assertions.assertNull(e1);
    }

    @Test
    void searchReturnsAllEntriesThatMatchExactly() {
        Entry e0 = new AxisEntry("root");
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
}