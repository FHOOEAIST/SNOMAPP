package at.snomapp.skeleton.APPC;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class APPCEntryTest {

    @Test
    void addChildSetsChildAndParent() {
        APPCEntry e0 = new APPCEntry("some description", 1);
        APPCEntry e1 = new APPCEntry("another description", 1);

        e0.addChild(e1);

        Assertions.assertTrue(e0.children.contains(e1));
    }

    @Test
    void getDescription() {
    }

    @Test
    void getChildren() {
    }

    @Test
    void getParent() {
    }

    @Test
    void search() {
    }

    @Test
    void getLayerCode() {
    }
}