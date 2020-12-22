package at.snomapp.domain.appc;

public class JsonTreeTest {


    public static void main(String[] args) {

        APPCTree t0 = new APPCTree("DE");

        //modality
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
        e6.addChild(e3);
        modality.addChild(e1);
        modality.addChild(e2);

        //laterality
        AxisEntry laterality = new AxisEntry("laterality");
        APPCEntry e7 = new APPCEntry("match", "1", null);
        APPCEntry e8 = new APPCEntry("missmatch", "1-1",null);
        e7.addChild(e8);
        laterality.addChild(e7);

        //anatomy
        AxisEntry anatomy = new AxisEntry("Anatomy");
        APPCEntry e9 = new APPCEntry("match", "1", null);
        anatomy.addChild(e9);

        //procedure
        AxisEntry procedure = new AxisEntry("Procedure");


        //put all axis to tree
        t0.setModality(modality);
        t0.setAnatomy(anatomy);
        t0.setProcedure(procedure);
        t0.setLaterality(laterality);


        //print json string of all axis
        System.out.println("------Test Modality--------- ");
        System.out.println(t0.getModalityJsonString());

        System.out.println("------Test Laterality--------- ");
        System.out.println(t0.getLateralityJsonString());

        System.out.println("------Test Anatomy--------- ");
        System.out.println(t0.getAnatomyJsonString());

        System.out.println("------Test Procedure --------- ");
        System.out.println(t0.getProcedureJsonString());


    }

}
