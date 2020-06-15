package at.snomapp.skeleton.domain.appc;

public class TestJsonTree {


    public static void main(String[] args) {

        APPCTree t0 = new APPCTree("DE");

        AxisEntry modality = new AxisEntry("modality");
        APPCEntry e1 = new APPCEntry("match", "1");
        APPCEntry e2 = new APPCEntry("missmatch", "2");
        APPCEntry e3 = new APPCEntry("match", "1-1");
        APPCEntry e4 = new APPCEntry("match", "2-1");
        APPCEntry e5 = new APPCEntry("missmatch", "2-1-1");
        APPCEntry e6 = new APPCEntry("match", "2-1-2");
        e4.addChild(e5);
        e4.addChild(e6);
        e2.addChild(e4);
        e1.addChild(e3);
        e6.addChild(e3);
        modality.addChild(e1);
        modality.addChild(e2);

        AxisEntry laterality = new AxisEntry("laterality");
        APPCEntry e7 = new APPCEntry("match", "1");
        APPCEntry e8 = new APPCEntry("missmatch", "1-1");
        e7.addChild(e8);
        laterality.addChild(e7);

        AxisEntry anatomy = new AxisEntry("Anatomy");
        APPCEntry e9 = new APPCEntry("match", "1");
        anatomy.addChild(e9);

        AxisEntry procedure = new AxisEntry("Procedure");

        t0.setModality(modality);
        t0.setAnatomy(anatomy);
        t0.setProcedure(procedure);
        t0.setLaterality(laterality);


        System.out.println("------Test Modality--------- ");
        System.out.println(t0.getModalityJsonString(t0));

        System.out.println("------Test Laterality--------- ");
        System.out.println(t0.getLateralityJsonString(t0));

        System.out.println("------Test Anatomy--------- ");
        System.out.println(t0.getAnatomyJsonString(t0));

        System.out.println("------Test Procedure --------- ");
        System.out.println(t0.getProcedureJsonString(t0));


    }

}
